package com.openbravo.pos.customers;

import com.openbravo.basic.BasicException;
import java.awt.Component;
import java.awt.event.ActionListener;

public interface TicketSelector {

    public void loadCustomers() throws BasicException;

    public void setComponentEnabled(boolean value);

    public Component getComponent();

    public void addActionListener(ActionListener l);

    public void removeActionListener(ActionListener l);
}
