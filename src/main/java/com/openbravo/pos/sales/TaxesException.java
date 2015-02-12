package com.openbravo.pos.sales;

public class TaxesException extends Exception {

    public TaxesException(Throwable t) {
        super(t);
    }

    public TaxesException(String msg, Throwable t) {
        super(msg, t);
    }
    /**
     * Constructs an instance of <code>TaxesException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public TaxesException(String msg) {
        super(msg);
    }
}
