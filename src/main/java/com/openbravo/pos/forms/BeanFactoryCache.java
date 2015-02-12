package com.openbravo.pos.forms;

public abstract class BeanFactoryCache implements BeanFactoryApp {

    private Object bean = null;

    public abstract Object constructBean(AppView app) throws BeanFactoryException;

    @Override
    public void init(AppView app) throws BeanFactoryException {
        bean = constructBean(app);
    }

    @Override
    public Object getBean() {
        return bean;
    }
}
