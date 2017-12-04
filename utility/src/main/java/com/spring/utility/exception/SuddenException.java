package com.spring.utility.exception;


public class SuddenException extends RuntimeException {

    private static final long serialVersionUID = -8817534331929567684L;


    public SuddenException(Throwable cause) {
        super(cause);
    }


    public SuddenException(String message) {
        super(message);
    }
}
