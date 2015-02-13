package com.openbravo.pos.scripting;

/**
 *
 * Created on 5 de marzo de 2007, 19:56
 *
 */
public class ScriptFactory {

    public static final String VELOCITY = "velocity";

    public static final String BEANSHELL = "beanshell";

    public static final String RHINO = "rhino";

    private ScriptFactory() {
    }

    public static ScriptEngine getScriptEngine(String name) throws ScriptException {
// JG 16 May use switch
        switch (name) {
            case VELOCITY:
                return new ScriptEngineVelocity();
            case BEANSHELL:
                return new ScriptEngineBeanshell();
            //        } else if (RHINO.equals(name)) {
            //            return new ScriptEngineRhino();
            //        } else if (name.startsWith("generic:")) {
            //            return new ScriptEngineGeneric(name.substring(8));
            default:
                throw new ScriptException("Script engine not found: " + name);
        }
    }
}
