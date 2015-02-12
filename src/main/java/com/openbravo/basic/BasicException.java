package com.openbravo.basic;

public class BasicException extends java.lang.Exception {

    public BasicException() {
    }

    public BasicException(String msg) {
        super(msg);
    }

    public BasicException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public BasicException(Throwable cause) {
        super(cause);
    }
}
