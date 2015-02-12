package com.openbravo.pos.payment;

public class PaymentException extends java.lang.Exception {

    public PaymentException() {
    }


    /**
     * Constructs an instance of <code>PaymentException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public PaymentException(String msg) {
        super(msg);
    }
}
