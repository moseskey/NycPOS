package com.openbravo.pos.inventory;

import com.openbravo.data.gui.ListCellRendererBasic;
import com.openbravo.data.loader.ComparatorCreator;
import com.openbravo.data.loader.TableDefinition;
import com.openbravo.data.loader.Vectorer;
import com.openbravo.data.user.EditorRecord;
import com.openbravo.data.user.ListProvider;
import com.openbravo.data.user.ListProviderCreator;
import com.openbravo.data.user.SaveProvider;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.forms.DataLogicSales;
import com.openbravo.pos.panels.JPanelTable;
import javax.swing.ListCellRenderer;

public class LocationsPanel extends JPanelTable {

    private TableDefinition tlocations;
    private LocationsView jeditor;

    public LocationsPanel() {
    }

    @Override
    protected void init() {
        DataLogicSales dlSales = (DataLogicSales) app.getBean("com.openbravo.pos.forms.DataLogicSales");
        tlocations = dlSales.getTableLocations();
        jeditor = new LocationsView(dirty);
    }

    @Override
    public ListProvider getListProvider() {
        return new ListProviderCreator(tlocations);
    }

    @Override
    public SaveProvider getSaveProvider() {
        return new SaveProvider(tlocations);
    }

    @Override
    public Vectorer getVectorer() {
        return tlocations.getVectorerBasic(new int[]{1, 2});
    }

    @Override
    public ComparatorCreator getComparatorCreator() {
        return tlocations.getComparatorCreator(new int[] {1, 2});
    }

    @Override
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(tlocations.getRenderStringBasic(new int[]{1}));
    }

    @Override
    public EditorRecord getEditor() {
        return jeditor;
    }

    @Override
    public String getTitle() {
        return AppLocal.getIntString("Menu.Locations");
    }
}
