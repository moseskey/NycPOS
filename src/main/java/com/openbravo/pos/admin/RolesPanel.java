package com.openbravo.pos.admin;

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

public class RolesPanel extends JPanelTable {

    private TableDefinition troles;
    private TableDefinition trolesmenu;
    private RolesView jeditor;


    public RolesPanel() {
     }

    @Override
    protected void init() {
        DataLogicAdmin dlAdmin  = (DataLogicAdmin) app.getBean("com.openbravo.pos.admin.DataLogicAdmin");
        troles = dlAdmin.getTableRoles();
        jeditor = new RolesView(dirty);
    }

    @Override
    public ListProvider getListProvider() {
        return new ListProviderCreator(troles);
    }

    @Override
    public SaveProvider getSaveProvider() {
        return new SaveProvider(troles);
    }

    @Override
    public Vectorer getVectorer() {
        return troles.getVectorerBasic(new int[] {1});
    }

    @Override
    public ComparatorCreator getComparatorCreator() {
        return troles.getComparatorCreator(new int[] {1});
    }

    @Override
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(troles.getRenderStringBasic(new int[] {1}));
    }

    @Override
    public EditorRecord getEditor() {
        return jeditor;
    }

    @Override
    public String getTitle() {
        return AppLocal.getIntString("Menu.Roles");
    }
}
