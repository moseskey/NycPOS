package com.openbravo.pos.forms;

public class BeanFactoryData implements BeanFactoryApp {

    private BeanFactoryApp bf;

    public BeanFactoryData() {
    }

    @Override
    public void init(AppView app) throws BeanFactoryException {

        try {

            String sfactoryname = this.getClass().getName();
            if (sfactoryname.endsWith("Create")) {
                sfactoryname = sfactoryname.substring(0, sfactoryname.length() - 6);
            }
            bf = (BeanFactoryApp) Class.forName(sfactoryname + app.getSession().DB.getName()).newInstance();
            bf.init(app);
// JG 16 May use multicatch
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | BeanFactoryException ex) {
            throw new BeanFactoryException(ex);
        }
    }

    @Override
    public Object getBean() {
        return bf.getBean();
    }
}
