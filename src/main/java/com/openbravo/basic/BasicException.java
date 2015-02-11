package com.openbravo.basic;

public class BasicException extends java.lang.Exception {

    /**
     * Creates a new instance of <code>DataException</code> without detail message.
     */
    public BasicException() {
    }

    /**
     *
     */
    public BasicException(String msg) {
        super(msg);
    }

    /**
     *
     */
    public BasicException(String msg, Throwable cause) {
        super(msg, cause);
    }

    /**
     *
     */
    public BasicException(Throwable cause) {
        super(cause);
    }
}
