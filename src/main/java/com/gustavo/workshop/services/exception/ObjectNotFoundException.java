package com.gustavo.workshop.services.exception;

public class ObjectNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -8936800461707994928L;

    public ObjectNotFoundException(String message) {
        super(message);
    }
}
