package com.openbravo.pos.forms;

public class BeanFactoryObj implements BeanFactory {

    private Object bean = null;

    /**
     * Creates a new instance of BeanFactoryObj
     * @param bean
     */
    public BeanFactoryObj(Object bean) {
        this.bean = bean;
    }

    @Override
    public Object getBean() {
        return bean;
    }

}
