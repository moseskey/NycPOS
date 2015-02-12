package com.openbravo.pos.mant;
import com.openbravo.basic.BasicException;
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
import com.openbravo.pos.forms.DataLogicSales;
import com.openbravo.pos.panels.JPanelTable;
import javax.swing.ListCellRenderer;

public class JPanelPlaces extends JPanelTable {

    private TableDefinition tplaces;
    private PlacesEditor jeditor;

    public JPanelPlaces() {
    }

    @Override
    protected void init() {
        DataLogicSales dlSales = null;
        dlSales = (DataLogicSales) app.getBean("com.openbravo.pos.forms.DataLogicSales");

        tplaces = new TableDefinition(app.getSession(),
            "PLACES"
            , new String[] {"ID", "NAME", "X", "Y", "FLOOR"}
            , new String[] {"ID", AppLocal.getIntString("Label.Name"), "X", "Y", AppLocal.getIntString("label.placefloor")}
            , new Datas[] {Datas.STRING, Datas.STRING, Datas.INT, Datas.INT, Datas.STRING}
            , new Formats[] {Formats.STRING, Formats.STRING, Formats.INT, Formats.INT, Formats.NULL}
            , new int[] {0}
        );
        jeditor = new PlacesEditor(dlSales, dirty);
    }

    @Override
    public ListProvider getListProvider() {
        return new ListProviderCreator(tplaces);
    }

    @Override
    public SaveProvider getSaveProvider() {
        return new SaveProvider(tplaces);
    }

    @Override
    public Vectorer getVectorer() {
        return tplaces.getVectorerBasic(new int[]{1});
    }

    @Override
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(tplaces.getRenderStringBasic(new int[]{1}));
    }

    @Override
    public EditorRecord getEditor() {
        return jeditor;
    }

    @Override
    public String getTitle() {
        return AppLocal.getIntString("Menu.Tables");
    }

    @Override
    public void activate() throws BasicException {
        jeditor.activate(); // primero activo el editor
        super.activate();   // segundo activo el padre
    }
}
