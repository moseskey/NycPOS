package com.openbravo.pos.forms;

import java.util.ArrayList;
import javax.swing.Action;

public class MenuDefinition {

    private String m_sKey;

    private ArrayList m_aMenuElements;

    /**
     * Creates a new instance of MenuDefinition
     * @param skey */
    public MenuDefinition(String skey) {
        m_sKey = skey;
        m_aMenuElements = new ArrayList();
    }

    public String getKey() {
        return m_sKey;
    }

    public String getTitle() {
        return AppLocal.getIntString(m_sKey);
    }

    public void addMenuItem(Action act) {
        MenuItemDefinition menuitem = new MenuItemDefinition(act);
        m_aMenuElements.add(menuitem);
    }

    public void addMenuTitle(String keytext) {
        MenuTitleDefinition menutitle = new MenuTitleDefinition();
        menutitle.KeyText = keytext;
        m_aMenuElements.add(menutitle);
    }

    public MenuElement getMenuElement(int i) {
        return (MenuElement) m_aMenuElements.get(i);
    }

    public int countMenuElements() {
        return m_aMenuElements.size();
    }

}
