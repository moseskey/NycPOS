package com.openbravo.pos.printer.escpos;

import com.openbravo.pos.printer.DevicePrinter;
import com.openbravo.pos.printer.TicketPrinterException;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

public class DevicePrinterPlain implements DevicePrinter  {

    private static final byte[] NEW_LINE = {0x0D, 0x0A}; // Print and carriage return

    private PrinterWritter out;
    private UnicodeTranslator trans;

    // Creates new TicketPrinter

        public DevicePrinterPlain(PrinterWritter CommOutputPrinter) throws TicketPrinterException {

        out = CommOutputPrinter;
        trans = new UnicodeTranslatorStar(); // The star translator stands for the 437 int char page
    }

    @Override
    public String getPrinterName() {
        return "Plain";
    }

    @Override
    public String getPrinterDescription() {
        return null;
    }

    @Override
    public JComponent getPrinterComponent() {
        return null;
    }

    @Override
    public void reset() {
    }

    @Override
    public void beginReceipt() {
    }

    @Override
    public void printImage(BufferedImage image) {
    }

    @Override
    public void printLogo(){

    }

    @Override
    public void printBarCode(String type, String position, String code) {
        if (! DevicePrinter.POSITION_NONE.equals(position)) {
            out.write(code);
            out.write(NEW_LINE);
        }
    }

    @Override
    public void beginLine(int iTextSize) {
    }

    @Override
    public void printText(int iStyle, String sText) {
        out.write(trans.transString(sText));
    }

    @Override
    public void endLine() {
        out.write(NEW_LINE);
    }

    @Override
    public void endReceipt() {
        out.write(NEW_LINE);
        out.write(NEW_LINE);
        out.write(NEW_LINE);
        out.write(NEW_LINE);
        out.write(NEW_LINE);
        out.flush();
    }

    @Override
    public void openDrawer() {
    }
}

