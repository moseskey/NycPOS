package com.openbravo.pos.thirdparties;

import javax.swing.ListCellRenderer;
import com.openbravo.data.gui.ListCellRendererBasic;
import com.openbravo.data.loader.ComparatorCreator;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.panels.*;
import com.openbravo.data.loader.TableDefinition;
import com.openbravo.data.loader.Vectorer;
import com.openbravo.data.user.EditorRecord;
import com.openbravo.data.user.SaveProvider;
import com.openbravo.data.user.ListProvider;
import com.openbravo.data.user.ListProviderCreator;

public class ThirdPartiesPanel extends JPanelTable {

    private TableDefinition tthirdparties;
    private ThirdPartiesView jeditor;

    public ThirdPartiesPanel() {
    }

    protected void init() {
        DataLogicThirdParties dlThirdParties = (DataLogicThirdParties)
                                               app.getBean("com.openbravo.pos.thirdparties.DataLogicThirdParties");
        tthirdparties = dlThirdParties.getTableThirdParties();
        jeditor = new ThirdPartiesView(app, dirty);
    }

    public ListProvider getListProvider() {
        return new ListProviderCreator(tthirdparties);
    }

    public SaveProvider getSaveProvider() {
        return new SaveProvider(tthirdparties);
    }

    public Vectorer getVectorer() {
        return tthirdparties.getVectorerBasic(new int[] {1, 2, 3, 4});
    }

    public ComparatorCreator getComparatorCreator() {
        return tthirdparties.getComparatorCreator(new int[] {1, 2, 3, 4});
    }

    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(tthirdparties.getRenderStringBasic(new int[] {1, 2}));
    }

    public EditorRecord getEditor() {
        return jeditor;
    }

    public String getTitle() {
        return AppLocal.getIntString("Menu.ThirdPartiesManagement");
    }
}
