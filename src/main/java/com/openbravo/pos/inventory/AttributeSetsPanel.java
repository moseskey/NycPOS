package com.openbravo.pos.inventory;

import com.openbravo.data.loader.Datas;
import com.openbravo.data.model.*;
import com.openbravo.data.user.EditorRecord;
import com.openbravo.format.Formats;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.panels.JPanelTable2;

public class AttributeSetsPanel extends JPanelTable2 {

    private EditorRecord editor;

    /**
     * Creates a new instance of JPanelCategories */
    public AttributeSetsPanel() {
    }

    @Override
    protected void init() {

        row = new Row(
                new Field("ID", Datas.STRING, Formats.STRING),
                new Field(AppLocal.getIntString("Label.Name"), Datas.STRING, Formats.STRING, true, true, true)
        );

        Table table = new Table(
                "ATTRIBUTESET",
                new PrimaryKey("ID"),
                new Column("NAME"));

        lpr = row.getListProvider(app.getSession(), table);
        spr = row.getSaveProvider(app.getSession(), table);

        editor = new AttributeSetsEditor(dirty);
    }

    @Override
    public EditorRecord getEditor() {
        return editor;
    }

    @Override
    public String getTitle() {
        return AppLocal.getIntString("Menu.AttributeSets");
    }
}
