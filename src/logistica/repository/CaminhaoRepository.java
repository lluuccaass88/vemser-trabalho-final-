package src.logistica.repository;

import src.logistica.exception.BancoDeDadosException;
import src.logistica.model.Caminhao;
import src.logistica.model.EmViagem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CaminhaoRepository implements Repositorio<Integer, Caminhao> {

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
    public Caminhao adicionar(Caminhao caminhao) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Integer proximoId = this.getProximoId(con);
            caminhao.setIdCaminhao(proximoId);

            String sql = "INSERT INTO LOGISTICA.CAMINHAO\n" +
                    "(ID_CAMINHAO, NOME, PLACA, GASOLINA, EMVIAGEM)\n" +
                    "VALUES(?, ?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, caminhao.getIdCaminhao());
            stmt.setString(2, caminhao.getModelo());
            stmt.setString(3, caminhao.getPlaca());
            stmt.setInt(4, caminhao.getGasolina());
            stmt.setString(5, caminhao.getEmViagem().toString());

            int res = stmt.executeUpdate();
            if (res == 0) {
                throw new BancoDeDadosException("Erro ao adicionar colaborador");
            } else {
                System.out.println("Colaborador adicionado com sucesso!" +
                        "\nadicionarColaborador.res=" + res);
            }
            return caminhao;
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
    public boolean editar(Integer id, Caminhao caminhao) throws BancoDeDadosException {
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
    public List<Caminhao> listar() throws BancoDeDadosException {
        List<Caminhao> caminhoes = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM LOGISTICA.CAMINHAO";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Caminhao caminhao = getCaminhaoFromResultSet(rs);
                caminhoes.add(caminhao);
            }
            return caminhoes;
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao listar caminhoes" + e);
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

    // Método criado para evitar repetição de código e para usar 2 tabelas
    private Caminhao getCaminhaoFromResultSet(ResultSet rs) throws SQLException {
        Caminhao caminhao = new Caminhao();
        caminhao.setIdCaminhao(rs.getInt("ID_CAMINHAO"));
        caminhao.setModelo(rs.getString("MODELO"));
        caminhao.setPlaca(rs.getString("PLACA"));
        caminhao.setGasolina(rs.getInt("GASOLINA"));
        caminhao.setEmViagem(EmViagem.getOpcaoEmViagem(rs.getInt("EM_VIAGEM")));
        return caminhao;
    }
}