package src.logistica.repository;

import src.logistica.exception.BancoDeDadosException;
import src.logistica.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViagemRepository implements Repositorio<Integer, Viagem>{

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        try {
            String sql = "SELECT LOGISTICA.SEQ_CAMINHAO.NEXTVAL mysequence FROM DUAL";

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                return rs.getInt("mysequence");
            }
            return null;
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao buscar sequence de Caminhão " + e);
        }
    }

    @Override
    public Viagem adicionar(Viagem viagem) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Integer proximoId = this.getProximoId(con);
            viagem.setIdViagem(proximoId);

            String sql = "INSERT INTO LOGISTICA.VIAGEM\n" +
                    "\t(ID_VIAGEM, ID_CAMINHAO, ID_ROTA, ID_USUARIO, FINALIZADA)\n" +
                    "\t\tVALUES(?, ?, ?, ?, ?);";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, viagem.getIdViagem());
            stmt.setInt(1, viagem.getCaminhao().getIdCaminhao());
            stmt.setInt(1, viagem.getRota().getIdRota());
            stmt.setInt(1, viagem.getUsuario().getId());
            stmt.setInt(1, viagem.getFinalizada());


            int res = stmt.executeUpdate();
            if (res == 0) {
                throw new BancoDeDadosException("Erro ao adicionar viagem");
            } else {
                System.out.println("Viagem cadastrado com sucesso!" +
                        "\nadicionarCaminhão.res=" + res);
            }
            return viagem;
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao adicionar viagem: " + e);
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

            String sql = "DELETE FROM LOGISTICA.CAMINHAO WHERE ID_CAMINHAO = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            // Executa-se a consulta SQL
            int res = stmt.executeUpdate();
            if (res == 0) {
                throw new BancoDeDadosException("Erro ao remover caminhão");
            } else {
                System.out.println("Caminhão removido com sucesso!" +
                        "\nremoverCaminhão.res=" + res);
                return res > 0;
            }
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao remover caminhão" + e);
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
    public boolean editar(Integer id, Viagem viagem) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE LOGISTICA.CAMINHAO SET ");
            sql.append("MODELO = ?, ");
            sql.append("PLACA = ?, ");
            sql.append("GASOLINA = ?, ");
            sql.append("EMVIAGEM = ? ");
            sql.append("WHERE ID_CAMINHAO = ?");
            PreparedStatement stmt = con.prepareStatement(sql.toString());
            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("editarCaminhao.res=" + res);
            if (res == 0) {
                throw new BancoDeDadosException("Erro ao editar caminhão");
            } else {
                System.out.println("Caminhão editado com sucesso!" +
                        "\neditarCaminhão.res=" + res);
                return res > 0;
            }
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao editar caminhão" + e);
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
    public List<Viagem> listar() throws BancoDeDadosException {
        List<Viagem> viagens = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "SELECT * FROM LOGISTICA.CAMINHAO";

            PreparedStatement stmt = con.prepareStatement(sql);
            // Executa-se a consulta
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Viagem viagem = new Viagem();
//                viagem.se
//
//                caminhao.setIdCaminhao(rs.getInt("ID_CAMINHAO"));
//                caminhao.setModelo(rs.getString("MODELO"));
//                caminhao.setPlaca(rs.getString("PLACA"));
//                caminhao.setGasolina(rs.getInt("GASOLINA"));
//                caminhao.setEmViagem(EmViagem.getOpcaoEmViagem(rs.getInt("EMVIAGEM")));
                viagens.add(viagem);
            }

        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao listar caminhoes cadastrados: " + e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return viagens;
    }
}
