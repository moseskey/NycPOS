package com.openbravo.pos.epm;

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

public class LeavesPanel extends JPanelTable {

    private TableDefinition tleaves;
    private LeavesView jeditor;

    public LeavesPanel() {
    }

    @Override
    protected void init() {
        DataLogicPresenceManagement dlPresenceManagement  = (DataLogicPresenceManagement) app.getBean("com.openbravo.pos.epm.DataLogicPresenceManagement");
        tleaves = dlPresenceManagement.getTableLeaves();
        jeditor = new LeavesView(app, dirty);
    }

    @Override
    public void activate() throws BasicException {
        jeditor.activate();
        super.activate();
    }

    @Override
    public ListProvider getListProvider() {
        return new ListProviderCreator(tleaves);
    }

    @Override
    public SaveProvider getSaveProvider() {
        return new SaveProvider(tleaves, new int[] {0, 1, 2, 3, 4, 5});
    }

    @Override
    public Vectorer getVectorer() {
        return tleaves.getVectorerBasic(new int[]{2, 5});
    }

    @Override
    public ComparatorCreator getComparatorCreator() {
        return tleaves.getComparatorCreator(new int[] {2, 3, 4, 5});
    }

    @Override
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(tleaves.getRenderStringBasic(new int[]{2}));
    }

    @Override
    public EditorRecord getEditor() {
        return jeditor;
    }

    @Override
    public String getTitle() {
        return AppLocal.getIntString("Menu.Leaves");
    }
}
