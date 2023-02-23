package src.logistica.repository;

import src.logistica.exception.BancoDeDadosException;
import src.logistica.model.Motorista;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MotoristaRepository implements Repositorio<Integer, Motorista> {
    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        try {
            String sql = "SELECT SEQ_MOTORISTA.nextval mysequence FROM DUAL";

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                return rs.getInt("mysequence");
            }
            return null;
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao buscar sequence de Motorista" + e);
        }
    }

    @Override
    public Motorista adicionar(Motorista motorista) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Integer proximoId = this.getProximoId(con);
            motorista.setId(proximoId);

            String sql = "INSERT INTO MOTORISTA\n" +
                    "(ID_MOTORISTA, NOME, USUARIO, SENHA, CNH)\n" +
                    "VALUES(?, ?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, motorista.getId());
            stmt.setString(2, motorista.getNome());
            stmt.setString(3, motorista.getUsuario());
            stmt.setString(4, motorista.getSenha());
            stmt.setString(5, motorista.getCnh());

            int res = stmt.executeUpdate();
            if (res == 0) {
                throw new BancoDeDadosException("Erro ao adicionar motorista");
            } else {
                System.out.println("Motorista adicionado com sucesso!" +
                        "\nadicionarMotorista.res=" + res);
            }
            return motorista;
        } catch (SQLException e) {
            throw new BancoDeDadosException("Erro ao adicionar motorista" + e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new BancoDeDadosException("Erro ao fechar conexão" + e);
            }
        }
    }

    @Override
    public boolean remover(Integer id) throws BancoDeDadosException {
        return false;
    }

    @Override
    public boolean editar(Integer id, Motorista motorista) throws BancoDeDadosException {
        return false;
    }

    @Override
    public List<Motorista> listar() throws BancoDeDadosException {
        return null;
    }
}
