package com.openbravo.pos.forms;

import com.openbravo.basic.BasicException;
import javax.swing.JComponent;

public interface JPanelView {

    public abstract String getTitle();

    /**
     *
     * @throws BasicException
     */
    public abstract void activate() throws BasicException;

    public abstract boolean deactivate();

    public abstract JComponent getComponent();
}
