package src.logistica.repository;

import src.logistica.exception.BancoDeDadosException;
import src.logistica.model.Colaborador;
import src.logistica.model.Colaborador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ColaboradorRepository implements Repositorio<Integer, Colaborador> {
    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        try {
            String sql = "SELECT LOGISTICA.SEQ_COLABORADOR.NEXTVAL mysequence FROM DUAL";

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                return rs.getInt("mysequence");
            }
            return null;
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao buscar sequence de Colaborador" + e);
        }
    }

    @Override
    public Colaborador adicionar(Colaborador colaborador) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Integer proximoId = this.getProximoId(con);
            colaborador.setId(proximoId);

            String sql = "INSERT INTO LOGISTICA.COLABORADOR\n" +
                    "(ID_COLABORADOR, NOME, USUARIO, SENHA, CPF)\n" +
                    "VALUES(?, ?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, colaborador.getId());
            stmt.setString(2, colaborador.getNome());
            stmt.setString(3, colaborador.getUsuario());
            stmt.setString(4, colaborador.getSenha());
            stmt.setString(5, colaborador.getCpf());

            int res = stmt.executeUpdate();
            if (res == 0) {
                throw new BancoDeDadosException("Erro ao adicionar colaborador");
            } else {
                System.out.println("Colaborador adicionado com sucesso!" +
                        "\nadicionarColaborador.res=" + res);
            }
            return colaborador;
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao adicionar colaborador" + e);
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

            String sql = "DELETE FROM LOGISTICA.COLABORADOR WHERE ID_COLABORADOR = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            if (res == 0) {
                throw new BancoDeDadosException("Erro ao remover colaborador");
            } else {
                System.out.println("Colaborador removido com sucesso!" +
                        "\nremoverColaboradorPorId.res=" + res);
                return res > 0;
            }
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao remover colaborador" + e);
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
    public boolean editar(Integer id, Colaborador colaborador) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE LOGISTICA.COLABORADOR SET ");
            sql.append("NOME = ?, ");
            sql.append("USUARIO = ?, ");
            sql.append("SENHA = ?, ");
            sql.append("CPF = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setString(1, colaborador.getNome());
            stmt.setString(2, colaborador.getUsuario());
            stmt.setString(3, colaborador.getSenha());
            stmt.setString(4, colaborador.getCpf());

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            if (res == 0) {
                throw new BancoDeDadosException("Erro ao editar colaborador");
            } else {
                System.out.println("Colaborador editado com sucesso!" +
                        "\neditarColaboradorPorId.res=" + res);
                return res > 0;
            }
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao editar colaborador" + e);
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
    public List<Colaborador> listar() throws BancoDeDadosException {
        List<Colaborador> colaboradores = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "SELECT * FROM LOGISTICA.COLABORADOR";

            PreparedStatement stmt = con.prepareStatement(sql);
            // Executa-se a consulta
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Colaborador colaborador = new Colaborador();
                colaborador.setId(rs.getInt("ID_COLABORADOR"));
                colaborador.setNome(rs.getString("NOME"));
                colaborador.setUsuario(rs.getString("USUARIO"));
                colaborador.setSenha(rs.getString("SENHA"));
                colaborador.setCpf(rs.getString("CPF"));
                colaboradores.add(colaborador);
            }
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao listar colaboradores" + e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return colaboradores;
    }
}
