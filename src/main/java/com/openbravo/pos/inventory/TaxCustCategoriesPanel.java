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

public class TaxCustCategoriesPanel extends JPanelTable {

    private TableDefinition ttaxcategories;
    private TaxCustCategoriesEditor jeditor;

    public TaxCustCategoriesPanel() {
    }

    @Override
    protected void init() {
        DataLogicSales dlSales = (DataLogicSales) app.getBean("com.openbravo.pos.forms.DataLogicSales");
        ttaxcategories = dlSales.getTableTaxCustCategories();
        jeditor = new TaxCustCategoriesEditor(dirty);
    }

    @Override
    public ListProvider getListProvider() {
        return new ListProviderCreator(ttaxcategories);
    }

    @Override
    public SaveProvider getSaveProvider() {
        return new SaveProvider(ttaxcategories);
    }

    @Override
    public Vectorer getVectorer() {
        return ttaxcategories.getVectorerBasic(new int[]{1});
    }

    @Override
    public ComparatorCreator getComparatorCreator() {
        return ttaxcategories.getComparatorCreator(new int[] {1});
    }

    @Override
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(ttaxcategories.getRenderStringBasic(new int[]{1}));
    }

    @Override
    public EditorRecord getEditor() {
        return jeditor;
    }

    @Override
    public String getTitle() {
        return AppLocal.getIntString("Menu.TaxCustCategories");
    }
}
