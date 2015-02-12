package com.openbravo.pos.mant;

import com.openbravo.data.gui.ListCellRendererBasic;
import com.openbravo.data.loader.Datas;
import com.openbravo.data.loader.TableDefinition;
import com.openbravo.data.loader.Vectorer;
import com.openbravo.data.user.EditorRecord;
import com.openbravo.data.user.ListProvider;
import com.openbravo.data.user.ListProviderCreator;
import com.openbravo.data.user.SaveProvider;
import com.openbravo.format.Formats;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.panels.JPanelTable;
import javax.swing.ListCellRenderer;

public class JPanelFloors extends JPanelTable {

    private TableDefinition tfloors;
    private FloorsEditor jeditor;

    public JPanelFloors() {
    }

    @Override
    protected void init() {
        tfloors = new TableDefinition(app.getSession(),
            "FLOORS"
            , new String[] {"ID", "NAME", "IMAGE"}
            , new String[] {"ID", AppLocal.getIntString("Label.Name"), "IMAGE"}
            , new Datas[] {Datas.STRING, Datas.STRING, Datas.IMAGE}
            , new Formats[] {Formats.NULL, Formats.STRING}
            , new int[] {0}
        );
        jeditor = new FloorsEditor(dirty);
    }

    @Override
    public ListProvider getListProvider() {
        return new ListProviderCreator(tfloors);
    }

    @Override
    public Vectorer getVectorer() {
        return tfloors.getVectorerBasic(new int[]{1});
    }

    @Override
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(tfloors.getRenderStringBasic(new int[]{1}));
    }

    @Override
    public SaveProvider getSaveProvider() {
        return new SaveProvider(tfloors);
    }

    @Override
    public EditorRecord getEditor() {
        return jeditor;
    }

    @Override
    public String getTitle() {
        return AppLocal.getIntString("Menu.Floors");
    }
}
