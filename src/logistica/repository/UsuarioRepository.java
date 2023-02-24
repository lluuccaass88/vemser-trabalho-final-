package src.logistica.repository;

import src.logistica.exception.BancoDeDadosException;
import src.logistica.model.Usuario;

import java.sql.*;
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
        return false;
    }

    @Override
    public boolean editar(Integer id, Usuario usuario) throws BancoDeDadosException {
        return false;
    }

    @Override
    public List<Usuario> listar() throws BancoDeDadosException {
        return null;
    }
}