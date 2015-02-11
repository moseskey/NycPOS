package com.openbravo.pos.printer.escpos;

import com.openbravo.pos.printer.DeviceTicket;

public class DeviceDisplayESCPOS extends DeviceDisplaySerial {

    private UnicodeTranslator trans;

    /**
     * Creates a new instance of DeviceDisplayESCPOS
     * @param trans */
    public DeviceDisplayESCPOS(PrinterWritter display, UnicodeTranslator trans) {
        this.trans = trans;
        init(display);
    }

    @Override
    public void initVisor() {
        display.init(ESCPOS.INIT);
        display.write(ESCPOS.SELECT_DISPLAY); // Al visor
        display.write(trans.getCodeTable());
        display.write(ESCPOS.VISOR_HIDE_CURSOR);
        display.write(ESCPOS.VISOR_CLEAR);
        display.write(ESCPOS.VISOR_HOME);
        display.flush();
    }

//    @Override
//    public void clearLines() {
//        display.write(ESCPOS.SELECT_DISPLAY);
//        display.write(ESCPOS.VISOR_CLEAR);
//        display.write(ESCPOS.VISOR_HOME);
//        display.flush();
//    }


    @Override
    public void repaintLines() {

        display.write(ESCPOS.SELECT_DISPLAY);
        display.write(ESCPOS.VISOR_CLEAR);
        display.write(ESCPOS.VISOR_HOME);
        display.write(trans.transString(DeviceTicket.alignLeft(m_displaylines.getLine1(), 20)));
        display.write(trans.transString(DeviceTicket.alignLeft(m_displaylines.getLine2(), 20)));
        display.flush();
    }
}
