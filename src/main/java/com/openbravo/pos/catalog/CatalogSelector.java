package com.openbravo.pos.catalog;

import com.openbravo.basic.BasicException;
import java.awt.Component;
import java.awt.event.ActionListener;

public interface CatalogSelector {

    public void loadCatalog() throws BasicException;

    public void showCatalogPanel(String id);

    public void setComponentEnabled(boolean value);

    public Component getComponent();

    public void addActionListener(ActionListener l);

    public void removeActionListener(ActionListener l);
}
