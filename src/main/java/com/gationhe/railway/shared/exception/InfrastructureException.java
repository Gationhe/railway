package com.gationhe.railway.shared.exception;

public class InfrastructureException extends RuntimeException {

    public InfrastructureException() {
        super();
    }

    public InfrastructureException(String message) {
        super(message);
    }

    public InfrastructureException(String message, Throwable cause) {
        super(message, cause);
    }

}
