package com.openbravo.pos.scripting;

public class ScriptException extends java.lang.Exception {

    public ScriptException() {
    }


    /**
     * Constructs an instance of <code>ScriptException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ScriptException(String msg) {
        super(msg);
    }

    public ScriptException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
