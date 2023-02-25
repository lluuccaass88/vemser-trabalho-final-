package src.logistica.repository;

import src.logistica.exception.BancoDeDadosException;
import src.logistica.model.Perfil;
import src.logistica.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository implements Repositorio<Integer, Usuario> {

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        try {
            String sql = "SELECT LOGISTICA.SEQ_USUARIO.NEXTVAL mysequence FROM DUAL";

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                return rs.getInt("mysequence");
            }
            return null;
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao buscar sequence de Usuário " + e);
        }
    }

    @Override
    public Usuario adicionar(Usuario usuario) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Integer proximoId = this.getProximoId(con);
            usuario.setId(proximoId);

            String sql = "INSERT INTO LOGISTICA.USUARIO\n" +
                    "(ID_USUARIO, NOME, USUARIO, SENHA, PERFIL, CPF, CNH)\n" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, usuario.getId());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getUsuario());
            stmt.setString(4, usuario.getSenha());
            stmt.setInt(5, usuario.getPerfil().getPerfil());
            stmt.setString(6, usuario.getCpf());
            stmt.setString(7, usuario.getCnh());

            int res = stmt.executeUpdate();
            if (res == 0) {
                throw new BancoDeDadosException("Erro ao adicionar usuario");
            } else {
                System.out.println("Usuario cadastrado com sucesso!" +
                        "\nadicionarUsuario.res=" + res);
            }
            return usuario;
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao adicionar usuario: " + e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean remover(Integer id) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM LOGISTICA.USUARIO WHERE ID_USUARIO = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            int res = stmt.executeUpdate();
            if (res == 0) {
                throw new BancoDeDadosException("Erro ao remover usuário");
            } else {
                System.out.println("Usuário removido com sucesso!" +
                        "\nremoverUsuário.res=" + res);
                return res > 0;
            }
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao remover usuário" + e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean editar(Integer id, Usuario usuario) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE LOGISTICA.USUARIO SET ");
            sql.append(" NOME = ?, ");
            sql.append(" USUARIO = ?, ");
            sql.append(" SENHA = ?, ");
            sql.append(" PERFIL = ?, ");
            sql.append(" CPF = ?, ");
            sql.append(" CNH = ? ");
            sql.append(" WHERE ID_USUARIO = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getUsuario());
            stmt.setString(3, usuario.getSenha());
            stmt.setInt(4, usuario.getPerfil().getPerfil());
            stmt.setString(5, usuario.getCpf());
            stmt.setString(6, usuario.getCnh());
            stmt.setInt(7, id);

            int res = stmt.executeUpdate();
            System.out.println("editarUsuario.res=" + res);

            return res > 0;
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao editar usuário" + e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Usuario> listar() throws BancoDeDadosException {
        List<Usuario> usuarios = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM LOGISTICA.USUARIO"; // Consulta SQL no banco

            ResultSet rs = stmt.executeQuery(sql); // Executa-se a consulta

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("ID_USUARIO"));
                usuario.setNome(rs.getString("NOME"));
                usuario.setUsuario(rs.getString("USUARIO"));
                usuario.setSenha(rs.getString("SENHA"));
                usuario.setPerfil(Perfil.ofTipoPerfil(rs.getInt("PERFIL")));
                usuario.setCpf(rs.getString("CPF"));
                usuario.setCnh(rs.getString("CNH"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao listar usuarios: " + e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return usuarios;
    }


    public Usuario login(String usurario, String senha) throws BancoDeDadosException{
        Usuario usuario = new Usuario();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "SELECT * FROM LOGISTICA.USUARIO u \n" +
                    "\tWHERE u.USUARIO = ? AND u.SENHA = ?"; // Consulta SQL no banco
            PreparedStatement stmt = con.prepareStatement(sql); // Prepara a consulta

            stmt.setString(1, usurario);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery(); // Executa-se a consulta


            while (rs.next()) {
                usuario.setId(rs.getInt("ID_USUARIO"));
                usuario.setNome(rs.getString("NOME"));
                usuario.setUsuario(rs.getString("USUARIO"));
                usuario.setSenha(rs.getString("SENHA"));
                usuario.setPerfil(Perfil.ofTipoPerfil(rs.getInt("PERFIL")));
                usuario.setCpf(rs.getString("CPF"));
                usuario.setCnh(rs.getString("CNH"));
            }
            return usuario;
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao listar usuarios: " + e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}