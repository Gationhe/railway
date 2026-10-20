package com.gationhe.railway.shared.exception;

public class GetSqlFailException extends InfrastructureException {

    public GetSqlFailException() {
        super();
    }

    public GetSqlFailException(String message) {
        super(message);
    }

    public GetSqlFailException(String message, Throwable cause) {
        super(message, cause);
    }

}
