package com.openbravo.pos.scripting;

import bsh.EvalError;
import bsh.Interpreter;

/**
 *
 * Created on 5 de marzo de 2007, 19:57
 *
 */
class ScriptEngineBeanshell implements ScriptEngine {

    private Interpreter i;

    /**
     * Creates a new instance of ScriptEngineBeanshell
     */
    public ScriptEngineBeanshell() {
        i = new Interpreter();
    }

    @Override
    public void put(String key, Object value) {

        try {
            i.set(key, value);
        } catch (EvalError e) {
        }
    }

    @Override
    public Object get(String key) {

        try {
            return i.get(key);
        } catch (EvalError e) {
            return null;
        }
    }

    @Override
    public Object eval(String src) throws ScriptException {

        try {
            return i.eval(src);
        } catch (EvalError e) {
            throw new ScriptException(e.getMessage(), e);
        }
    }
}
