package com.openbravo.pos.admin;

import com.openbravo.basic.BasicException;
import com.openbravo.data.gui.ListCellRendererBasic;
import com.openbravo.data.loader.ComparatorCreator;
import com.openbravo.data.loader.TableDefinition;
import com.openbravo.data.loader.Vectorer;
import com.openbravo.data.user.EditorRecord;
import com.openbravo.data.user.ListProvider;
import com.openbravo.data.user.ListProviderCreator;
import com.openbravo.data.user.SaveProvider;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.panels.JPanelTable;
import javax.swing.ListCellRenderer;

public class PeoplePanel extends JPanelTable {

    private TableDefinition tpeople;
    private PeopleView jeditor;

    public PeoplePanel() {
    }

    @Override
    protected void init() {
        DataLogicAdmin dlAdmin = (DataLogicAdmin) app.getBean("com.openbravo.pos.admin.DataLogicAdmin");
        tpeople = dlAdmin.getTablePeople();
        jeditor = new PeopleView(dlAdmin, dirty);
    }

    @Override
    public ListProvider getListProvider() {
        return new ListProviderCreator(tpeople);
    }

    @Override
    public SaveProvider getSaveProvider() {
        return new SaveProvider(tpeople);
    }

    @Override
    public Vectorer getVectorer() {
        return tpeople.getVectorerBasic(new int[]{1});
    }

    @Override
    public ComparatorCreator getComparatorCreator() {
        return tpeople.getComparatorCreator(new int[] {1, 3});
    }

    @Override
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(tpeople.getRenderStringBasic(new int[]{1}));
    }

    @Override
    public EditorRecord getEditor() {
        return jeditor;
    }

    @Override
    public void activate() throws BasicException {

        jeditor.activate(); // primero el editor
        super.activate(); // y luego cargamos los datos
    }

    @Override
    public String getTitle() {
        return AppLocal.getIntString("Menu.Users");
    }
}
