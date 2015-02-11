package com.openbravo.pos.customers;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JList;

public class CustomerRenderer extends DefaultListCellRenderer {

    private Icon icocustomer;

    /**
     * Creates a new instance of CustomerRenderer */
    public CustomerRenderer() {

        icocustomer = new ImageIcon(getClass().getClassLoader().getResource("com/openbravo/images/customer_sml.png"));
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, null, index, isSelected, cellHasFocus);
        setText(value.toString());
        setIcon(icocustomer);
        return this;
    }
}
