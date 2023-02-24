package src.logistica.repository;

import oracle.jdbc.proxy.annotation.Post;
import src.logistica.exception.BancoDeDadosException;
import src.logistica.model.Posto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostoRepository implements Repositorio<Integer, Posto> {
    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        try {
            String sql = "SELECT LOGISTICA.SEQ_POSTO.NEXTVAL mysequence FROM DUAL";

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                return rs.getInt("mysequence");
            }
            return null;
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao buscar sequence de Rotas" + e);
        }
    }


    @Override
    public Posto adicionar(Posto posto) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Integer proximoId = this.getProximoId(con);
            posto.setId_posto(proximoId);

            String sql = "INSERT INTO LOGISTICA.POSTO\n" +
                    "(ID_POSTO, NOMEPOSTO, VALORCOMBUSTIVEL)\n" +
                    "VALUES(?, ?, ?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, posto.getId_posto());
            stmt.setString(2, posto.getNomePosto());
            stmt.setDouble(3, posto.getValorCombustível());

            int res = stmt.executeUpdate();

            if (res == 0) {
                throw new BancoDeDadosException("Erro ao adicionar posto");
            } else {
                System.out.println("Posto adicionada com sucesso!" +
                        "\nadicionarPosto.res=" + res);
            }
            return posto;
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao adicionar posto" + e);
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

            String sql = "DELETE FROM LOGISTICA.POSTO WHERE ID_POSTO = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            if (res == 0) {
                throw new BancoDeDadosException("Erro ao remover posto");
            } else {
                System.out.println("Posto removida com sucesso!" +
                        "\nremoverPostoPorId.res=" + res);
                return res > 0;
            }
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao remover posto" + e);
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
    public boolean editar(Integer id, Posto posto) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE LOGISTICA.POSTO SET ");
            sql.append("NOMEPOSTO = ?, ");
            sql.append("VALORCOMBUSTIVEL = ? ");
            sql.append("WHERE ID_POSTO =  ?");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setString(1, posto.getNomePosto());
            stmt.setDouble(2, posto.getValorCombustível());
            stmt.setInt(3, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();

            if (res == 0) {
                throw new BancoDeDadosException("Erro ao editar posto.");
            } else {
                System.out.println("Posto editado com sucesso!" +
                        "\neditarPostoPorId.res=" + res);
                return res > 0;
            }
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao editar posto: " + e);
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
    public List<Posto> listar() throws BancoDeDadosException {
        List<Posto> postos = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "SELECT * FROM LOGISTICA.POSTO";

            PreparedStatement stmt = con.prepareStatement(sql);
            // Executa-se a consulta
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Posto posto = new Posto();
                posto.setId_posto(rs.getInt("ID_POSTO"));
                posto.setNomePosto(rs.getString("NOMEPOSTO"));
                posto.setValorCombustível(rs.getDouble("VALORCOMBUSTIVEL"));
                postos.add(posto);
            }
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao listar postos" + e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return postos;
    }

    public Posto buscarPorId(int id)throws BancoDeDadosException{
        Connection con = null;
        Posto posto = new Posto();

        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "SELECT * FROM LOGISTICA.POSTO WHERE ID_POSTO = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            // Executa-se a consulta
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                posto.setId_posto(rs.getInt("ID_POSTO"));
                posto.setNomePosto(rs.getString("NOMEPOSTO"));
                posto.setValorCombustível(rs.getDouble("VALORCOMBUSTIVEL"));
            }

        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao buscas o postos" + e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return posto;
    }
}
