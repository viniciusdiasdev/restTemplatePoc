package com.placar.resultado.exceptions;

public class ServerException extends RuntimeException {

    private static final long serialVersionUID = 4928599035264976611L;

    public ServerException(String message) {
        super(message);
    }

    public ServerException(Throwable t) {
        super(t);
    }
}
