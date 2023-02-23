package src.logistica.exception;

import java.sql.SQLException;

public class BancoDeDadosException extends SQLException {

    public BancoDeDadosException(String cause) {
        super(cause);
    }
}