package com.openbravo.pos.printer;

import com.openbravo.pos.forms.AppLocal;

public class DevicePrinterNull implements DevicePrinter {

    private String m_sName;
    private String m_sDescription;

    /**
     * Creates a new instance of DevicePrinterNull */
    public DevicePrinterNull() {
        this(null);
    }

    /**
     * Creates a new instance of DevicePrinterNull
     * @param desc */
    public DevicePrinterNull(String desc) {
        m_sName = AppLocal.getIntString("Printer.Null");
        m_sDescription = desc;
    }

    @Override
    public String getPrinterName() {
        return m_sName;
    }

    @Override
    public String getPrinterDescription() {
        return m_sDescription;
    }

    @Override
    public javax.swing.JComponent getPrinterComponent() {
        return null;
    }

    @Override
    public void reset() {
    }

    @Override
    public void beginReceipt() {
    }

    @Override
    public void printBarCode(String type, String position, String code) {
    }

    @Override
    public void printImage(java.awt.image.BufferedImage image) {
    }

    @Override
    public void beginLine(int iTextSize) {
    }

    @Override
    public void printText(int iStyle, String sText) {
    }

    @Override
    public void endLine() {
    }

    @Override
    public void endReceipt() {
    }

    @Override
    public void openDrawer() {
    }

    @Override
    public void printLogo() {

    }
}
