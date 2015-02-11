package com.openbravo.pos.printer;

import javax.swing.JComponent;

public class DeviceFiscalPrinterNull implements DeviceFiscalPrinter {

    /**
     * Creates a new instance of DeviceFiscalPrinterNull */
    public DeviceFiscalPrinterNull() {
    }

    public DeviceFiscalPrinterNull(String desc) {
    }

    @Override
    public String getFiscalName() {
        return null;
    }

    @Override
    public JComponent getFiscalComponent() {
        return null;
    }

    @Override
    public void beginReceipt() {
    }

    @Override
    public void endReceipt() {
    }

    @Override
    public void printLine(String sproduct, double dprice, double dunits, int taxinfo) {
    }

    @Override
    public void printMessage(String smessage) {
    }

    @Override
    public void printTotal(String sPayment, double dpaid) {
    }

    @Override
    public void printZReport() {
    }

    @Override
    public void printXReport() {
    }
}
