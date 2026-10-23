package com.gationhe.railway.shared.exception;

public class DeleteFailException extends ApplicationException {

    public DeleteFailException() {
        super();
    }

    public DeleteFailException(String message) {
        super(message);
    }

    public DeleteFailException(String message, Throwable cause) {
        super(message, cause);
    }

}
