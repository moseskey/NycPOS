package com.openbravo.pos.forms;

public interface BeanFactoryApp extends BeanFactory {

    /**
     *
     * @throws BeanFactoryException
     */
    public void init(AppView app) throws BeanFactoryException;

}
