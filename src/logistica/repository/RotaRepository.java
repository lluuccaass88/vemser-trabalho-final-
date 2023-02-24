package src.logistica.repository;

import src.logistica.exception.BancoDeDadosException;
import src.logistica.model.Rota;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RotaRepository implements Repositorio<Integer, Rota> {

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        try {
            String sql = "SELECT LOGISTICA.SEQ_ROTA.NEXTVAL mysequence FROM DUAL";

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
    public Rota adicionar(Rota rota) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Integer proximoId = this.getProximoId(con);
            rota.setId_rota(proximoId);

            //Adicionando a rota na sua respectiva tabela do banco de dados
            String sql = "INSERT INTO LOGISTICA.ROTA\n" +
                    "(ID_ROTA, DESCRICAO, LOCALPARTIDA, LOCALDESTINO)\n" +
                    "VALUES(?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, rota.getId_rota());
            stmt.setString(2, rota.getDescricao());
            stmt.setString(3, rota.getLocalPartida());
            stmt.setString(4, rota.getLocalDestino());

            int res = stmt.executeUpdate();

            if (res == 0) {
                throw new BancoDeDadosException("Erro ao adicionar rota");
            } else {
                System.out.println("Rota adicionada com sucesso!" +
                        "\nadicionarRota.res=" + res);
            }

            return rota;
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao adicionar rota" + e);
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


    public Rota adicionarPosto_X_Rota(Rota rota, int index) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            //inserindo o id de rota e o id de posto na tabela ROTA_X_POSTO
            String sql = "INSERT INTO LOGISTICA.ROTA_X_POSTO\n" +
                    "(ID_ROTA, ID_POSTO)\n" +
                    "VALUES(?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, rota.getId_rota());
            stmt.setInt(2, rota.getListaPostoCadastrado().get(index).getId_posto());

            int res = stmt.executeUpdate();

            if (res == 0) {
                throw new BancoDeDadosException("Erro ao adicionar POSTO_X_ROTA");
            } else {
                System.out.println("POSTO_X_ROTA adicionada com sucesso!" +
                        "\nadicionarPOSTO_X_ROTA.res=" + res);
            }

            return rota;
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao adicionar POSTO_X_ROTA" + e);
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

            String sql = "DELETE FROM LOGISTICA.ROTA WHERE ID_ROTA = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            if (res == 0) {
                throw new BancoDeDadosException("Erro ao remover rota");
            } else {
                System.out.println("Rota removida com sucesso!" +
                        "\nremoverRotaPorId.res=" + res);
                return res > 0;
            }
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao remover rota" + e);
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
    public boolean editar(Integer id, Rota rota) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE LOGISTICA.ROTA SET ");
            sql.append("DESCRICAO = ?, ");
            sql.append("LOCALPARTIDA = ?, ");
            sql.append("LOCALDESTINO = ? ");
            sql.append("WHERE ID_ROTA =  ?");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setString(1, rota.getDescricao());
            stmt.setString(2, rota.getLocalPartida());
            stmt.setString(3, rota.getLocalDestino());
            stmt.setInt(4, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();

            if (res == 0) {
                throw new BancoDeDadosException("Erro ao editar rota.");
            } else {
                System.out.println("Rota editada com sucesso!" +
                        "\neditarRotaPorId.res=" + res);
                return res > 0;
            }
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao editar rota: " + e);
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
    public List<Rota> listar() throws BancoDeDadosException {
        List<Rota> rotas = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "SELECT * FROM LOGISTICA.ROTA";

            PreparedStatement stmt = con.prepareStatement(sql);
            // Executa-se a consulta
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Rota rota = new Rota();
                rota.setId_rota(rs.getInt("ID_ROTA"));
                rota.setDescricao(rs.getString("DESCRICAO"));
                rota.setLocalDestino(rs.getString("LOCALPARTIDA"));
                rota.setLocalPartida(rs.getString("LOCALDESTINO"));
                rotas.add(rota);
            }
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao listar rotas" + e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rotas;
    }
}
