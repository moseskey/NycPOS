package com.openbravo.pos.forms;

import com.openbravo.pos.scripting.ScriptEngine;
import com.openbravo.pos.scripting.ScriptException;
import com.openbravo.pos.scripting.ScriptFactory;
import com.openbravo.pos.util.StringUtils;
import java.io.IOException;

public class BeanFactoryScript implements BeanFactoryApp {

    private BeanFactory bean = null;
    private String script;

    public BeanFactoryScript(String script) {
        this.script = script;
    }

    @Override
    public void init(AppView app) throws BeanFactoryException {

        // Resource
        try {
            ScriptEngine eng = ScriptFactory.getScriptEngine(ScriptFactory.BEANSHELL);
            eng.put("app", app);

            bean = (BeanFactory) eng.eval(StringUtils.readResource(script));
            if (bean == null) {
                // old definition
                bean = (BeanFactory) eng.get("bean");
            }

            // todo // llamar al init del bean
            if (bean instanceof BeanFactoryApp) {
                ((BeanFactoryApp) bean).init(app);
            }
// JG 16 May use multicatch
        } catch (ScriptException | IOException e) {
            throw new BeanFactoryException(e);
        }
    }

    @Override
    public Object getBean() {
        return bean.getBean();
    }
}
