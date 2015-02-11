package com.openbravo.pos.panels;

import com.openbravo.data.loader.ComparatorCreator;
import com.openbravo.data.loader.Vectorer;
import com.openbravo.data.model.Row;
import com.openbravo.data.user.ListProvider;
import com.openbravo.data.user.SaveProvider;
import javax.swing.ListCellRenderer;

public abstract class JPanelTable2 extends JPanelTable {

    protected Row row;

    protected ListProvider lpr;

    protected SaveProvider spr;

    @Override
    public final ListProvider getListProvider() {
        return lpr;
    }

    @Override
    public final SaveProvider getSaveProvider() {
        return spr;
    }

    @Override
    public final Vectorer getVectorer() {
        return row.getVectorer();
    }

    @Override
    public final ComparatorCreator getComparatorCreator() {
        return row.getComparatorCreator();
    }

    @Override
    public final ListCellRenderer getListCellRenderer() {
        return row.getListCellRenderer();
    }
}
