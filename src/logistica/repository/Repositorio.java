package src.logistica.repository;

import src.logistica.exception.BancoDeDadosException;
import src.logistica.model.Rota;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Repositorio <CHAVE, OBJETO> {
    Integer getProximoId(Connection connection) throws SQLException;
    OBJETO adicionar(OBJETO object) throws BancoDeDadosException;
    boolean remover(CHAVE id) throws BancoDeDadosException;
    boolean editar(CHAVE id, OBJETO object) throws BancoDeDadosException;
    List<OBJETO> listar() throws BancoDeDadosException;
}