package com.spring.utility.cipher;


public class CipherException extends RuntimeException {

    private static final long serialVersionUID = -8534122844354198801L;


    public CipherException() {
        super();
    }


    public CipherException(String message, Throwable cause) {
        super(message, cause);
    }


    public CipherException(String message) {
        super(message);
    }


    public CipherException(Throwable cause) {
        super(cause);
    }
}
