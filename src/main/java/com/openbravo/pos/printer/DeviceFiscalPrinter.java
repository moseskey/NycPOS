package com.openbravo.pos.printer;

import javax.swing.JComponent;

public interface DeviceFiscalPrinter {

    public String getFiscalName();

    public JComponent getFiscalComponent();

    public void beginReceipt();

    public void endReceipt();

    public void printLine(String sproduct, double dprice, double dunits, int taxinfo);

    public void printMessage(String smessage);

    public void printTotal(String sPayment, double dpaid);

    public void printZReport();

    public void printXReport();
}
