package com.openbravo.pos.scripting;

/**
 *
 * Created on 5 de marzo de 2007, 19:56
 *
 */
public interface ScriptEngine {

    public void put(String key, Object value);

    public Object get(String key);

    public Object eval(String src) throws ScriptException;

}
