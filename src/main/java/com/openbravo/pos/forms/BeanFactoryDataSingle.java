package com.openbravo.pos.forms;

import com.openbravo.data.loader.Session;

public abstract class BeanFactoryDataSingle implements BeanFactoryApp {

    public BeanFactoryDataSingle() {
    }

    public abstract void init(Session s);

    @Override
    public void init(AppView app) throws BeanFactoryException {
        init(app.getSession());
    }

    @Override
    public Object getBean() {
        return this;
    }
}
