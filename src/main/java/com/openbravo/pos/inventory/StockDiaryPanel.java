package com.openbravo.pos.inventory;

import com.openbravo.basic.BasicException;
import com.openbravo.data.user.EditorRecord;
import com.openbravo.data.user.ListProvider;
import com.openbravo.data.user.SaveProvider;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.forms.DataLogicSales;
import com.openbravo.pos.panels.JPanelTable;

public class StockDiaryPanel extends JPanelTable {

    private StockDiaryEditor jeditor;
    private DataLogicSales m_dlSales;

    public StockDiaryPanel() {
    }

    @Override
    protected void init() {
        m_dlSales = (DataLogicSales) app.getBean("com.openbravo.pos.forms.DataLogicSales");
        jeditor = new StockDiaryEditor(app, dirty);
    }

    @Override
    public ListProvider getListProvider() {
        return null;
    }

    @Override
    public SaveProvider getSaveProvider() {
        return  new SaveProvider(null,
                                 m_dlSales.getStockDiaryInsert(),
                                 m_dlSales.getStockDiaryDelete());
    }

    @Override
    public EditorRecord getEditor() {
        return jeditor;
    }

    @Override
    public String getTitle() {
        return AppLocal.getIntString("Menu.StockDiary");
    }

    @Override
    public void activate() throws BasicException {
        jeditor.activate(); // primero activo el editor
        super.activate();   // segundo activo el padre
    }
}
