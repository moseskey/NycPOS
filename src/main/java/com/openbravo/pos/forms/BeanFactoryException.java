package com.openbravo.pos.forms;

public class BeanFactoryException extends java.lang.RuntimeException {

    public BeanFactoryException() {
    }


    /**
     * Constructs an instance of <code>BeanFactoryException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public BeanFactoryException(String msg) {
        super(msg);
    }

    public BeanFactoryException(Throwable e) {
        super(e);
    }
}
