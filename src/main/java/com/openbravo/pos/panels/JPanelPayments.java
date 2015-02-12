package com.openbravo.pos.panels;

import com.openbravo.data.user.EditorRecord;
import com.openbravo.data.user.ListProvider;
import com.openbravo.data.user.SaveProvider;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.forms.DataLogicSales;

public class JPanelPayments extends JPanelTable {

    private PaymentsEditor jeditor;
    private DataLogicSales m_dlSales = null;

    public JPanelPayments() {
    }

    @Override
    protected void init() {
        m_dlSales = (DataLogicSales) app.getBean("com.openbravo.pos.forms.DataLogicSales");
        jeditor = new PaymentsEditor(app, dirty);
    }

    @Override
    public ListProvider getListProvider() {
        return null;
    }

    @Override
    public SaveProvider getSaveProvider() {
        return  new SaveProvider(null
                , m_dlSales.getPaymentMovementInsert()
                , m_dlSales.getPaymentMovementDelete());
    }

    @Override
    public EditorRecord getEditor() {
        return jeditor;
    }

    @Override
    public String getTitle() {
        return AppLocal.getIntString("Menu.Payments");
    }
}
