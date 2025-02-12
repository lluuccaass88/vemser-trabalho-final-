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
            String sql = "SELECT LOGISTICA.SEQ_VIAGEM.NEXTVAL mysequence FROM DUAL";

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                return rs.getInt("mysequence");
            }
            return null;
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao buscar sequence de viagem " + e);
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
                    "(ID_VIAGEM, ID_CAMINHAO, ID_ROTA, ID_USUARIO, FINALIZADA)\n" +
                    "VALUES(?, ?, ?, ?, ?)";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, viagem.getIdViagem());
            stmt.setInt(2, viagem.getCaminhao().getIdCaminhao());
            stmt.setInt(3, viagem.getRota().getIdRota());
            stmt.setInt(4, viagem.getUsuario().getId());
            stmt.setInt(5, viagem.getFinalizada());

            int res = stmt.executeUpdate();
            if (res == 0) {
                throw new BancoDeDadosException("Erro ao adicionar viagem");
            } else {
                System.out.println("Viagem cadastrada com sucesso!" +
                        "\nadicionarViagem.res=" + res);
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

            String sql = "UPDATE LOGISTICA.VIAGEM SET FINALIZADA = 1 WHERE ID_VIAGEM = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            // Executa-se a consulta SQL
            int res = stmt.executeUpdate();
            if (res == 0) {
                throw new BancoDeDadosException("Erro ao remover Viagem");
            } else {
                System.out.println("Viagem finalizada com sucesso!" +
                        "\nremoverCaminhão.res=" + res);
                return res > 0;
            }
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao finalizar viagem" + e);
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
            sql.append("UPDATE LOGISTICA.VIAGEM SET\n");
            sql.append(" ID_CAMINHAO = ?,");
            sql.append(" ID_ROTA = ?,");
            sql.append(" ID_USUARIO = ?,");
            sql.append(" FINALIZADA = ?");
            sql.append(" WHERE ID_VIAGEM = ?");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setInt(1, viagem.getCaminhao().getIdCaminhao());
            stmt.setInt(2, viagem.getRota().getIdRota());
            stmt.setInt(3, viagem.getUsuario().getId());
            stmt.setInt(4, viagem.getFinalizada());
            stmt.setInt(5, id);

            int res = stmt.executeUpdate();

            if (res == 0) {
                throw new BancoDeDadosException("Erro ao editar viagem");
            } else {
                System.out.println("Viagem editada com sucesso!" +
                        "\neditarViagem.res=" + res);
                return res > 0;
            }
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao editar viagem" + e);
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

            String sql = "SELECT * \n" +
                    "\tFROM LOGISTICA.VIAGEM v\n" +
                    "\t\tINNER JOIN LOGISTICA.USUARIO u  ON v.ID_USUARIO = u.ID_USUARIO \n" +
                    "\t\tINNER JOIN LOGISTICA.CAMINHAO c ON c.ID_CAMINHAO = v.ID_CAMINHAO \n" +
                    "\t\tINNER JOIN LOGISTICA.ROTA r ON r.ID_ROTA = r.ID_ROTA \n" +
                    "ORDER BY v.ID_VIAGEM";

            PreparedStatement stmt = con.prepareStatement(sql);
            // Executa-se a consulta
            ResultSet rs = stmt.executeQuery();

            Viagem viagemAnt = new Viagem();
            viagemAnt.setIdViagem(0);

            while (rs.next()) {
                Viagem viagem = new Viagem();
                Usuario usuario = new Usuario();
                Rota rota = new Rota();
                Caminhao caminhao = new Caminhao();

                usuario.setId(rs.getInt("ID_USUARIO"));
                usuario.setNome(rs.getString("NOME"));
                usuario.setUsuario(rs.getString("USUARIO"));
                usuario.setSenha(rs.getString("SENHA"));
                usuario.setPerfil(Perfil.ofTipoPerfil(rs.getInt("PERFIL")));
                usuario.setCpf(rs.getString("CPF"));
                usuario.setCnh(rs.getString("CNH"));

                rota.setIdRota(rs.getInt("ID_ROTA"));
                rota.setDescricao(rs.getString("DESCRICAO"));
                rota.setLocalDestino(rs.getString("LOCALPARTIDA"));
                rota.setLocalPartida(rs.getString("LOCALDESTINO"));

                caminhao.setIdCaminhao(rs.getInt("ID_CAMINHAO"));
                caminhao.setModelo(rs.getString("MODELO"));
                caminhao.setPlaca(rs.getString("PLACA"));
                caminhao.setGasolina(rs.getInt("GASOLINA"));
                caminhao.setEmViagem(EmViagem.getOpcaoEmViagem(rs.getInt("EMVIAGEM")));

                viagem.setIdViagem(rs.getInt("ID_VIAGEM"));
                viagem.setFinalizada(rs.getInt("FINALIZADA"));
                viagem.setUsuario(usuario);
                viagem.setRota(rota);
                viagem.setCaminhao(caminhao);

                if (viagemAnt.getIdViagem() != viagem.getIdViagem()) { //Faz com que não se crie rotas repetidas
                    viagens.add(viagem);
                    viagemAnt.setIdViagem(viagem.getIdViagem());
                }

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

    public Viagem buscaViagemId(int index) throws BancoDeDadosException{
        Connection con = null;
        Viagem viagem = new Viagem();
        
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "SELECT * \n" +
                    "\tFROM LOGISTICA.VIAGEM v\n" +
                    "\t\tINNER JOIN LOGISTICA.USUARIO u  ON v.ID_USUARIO = u.ID_USUARIO \n" +
                    "\t\tINNER JOIN LOGISTICA.CAMINHAO c ON c.ID_CAMINHAO = v.ID_CAMINHAO \n" +
                    "\t\tINNER JOIN LOGISTICA.ROTA r ON r.ID_ROTA = r.ID_ROTA \n" +
                    "WHERE v.ID_VIAGEM  = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, index);
            // Executa-se a consulta
            ResultSet rs = stmt.executeQuery();
                  
            while (rs.next()) {

                Usuario usuario = new Usuario();
                Rota rota = new Rota();
                Caminhao caminhao = new Caminhao();

                usuario.setId(rs.getInt("ID_USUARIO"));
                usuario.setNome(rs.getString("NOME"));
                usuario.setUsuario(rs.getString("USUARIO"));
                usuario.setSenha(rs.getString("SENHA"));
                usuario.setPerfil(Perfil.ofTipoPerfil(rs.getInt("PERFIL")));
                usuario.setCpf(rs.getString("CPF"));
                usuario.setCnh(rs.getString("CNH"));

                rota.setIdRota(rs.getInt("ID_ROTA"));
                rota.setDescricao(rs.getString("DESCRICAO"));
                rota.setLocalDestino(rs.getString("LOCALPARTIDA"));
                rota.setLocalPartida(rs.getString("LOCALDESTINO"));

                caminhao.setIdCaminhao(rs.getInt("ID_CAMINHAO"));
                caminhao.setModelo(rs.getString("MODELO"));
                caminhao.setPlaca(rs.getString("PLACA"));
                caminhao.setGasolina(rs.getInt("GASOLINA"));
                caminhao.setEmViagem(EmViagem.getOpcaoEmViagem(rs.getInt("EMVIAGEM")));

                viagem.setIdViagem(rs.getInt("ID_VIAGEM"));
                viagem.setUsuario(usuario);
                viagem.setRota(rota);
                viagem.setCaminhao(caminhao);

            }

        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao listar viagens cadastradas: " + e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return viagem;
    }
}