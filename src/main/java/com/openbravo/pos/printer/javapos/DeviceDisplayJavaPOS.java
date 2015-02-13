package com.openbravo.pos.printer.javapos;

import com.openbravo.pos.printer.DeviceDisplay;
import com.openbravo.pos.printer.DeviceDisplayBase;
import com.openbravo.pos.printer.DeviceDisplayImpl;
import com.openbravo.pos.printer.TicketPrinterException;
import jpos.JposException;
import jpos.LineDisplay;
import jpos.LineDisplayConst;

public class DeviceDisplayJavaPOS implements DeviceDisplay, DeviceDisplayImpl {

    private String m_sName;
    private LineDisplay m_ld;

    private DeviceDisplayBase m_displaylines;

    public DeviceDisplayJavaPOS(String sDeviceName) throws TicketPrinterException {
        m_sName = sDeviceName;

        m_ld = new LineDisplay();
        try {
            m_ld.open(m_sName);
            m_ld.claim(10000);
            m_ld.setDeviceEnabled(true);
        } catch (JposException e) {
            throw new TicketPrinterException(e.getMessage(), e);
        }

        m_displaylines = new DeviceDisplayBase(this);
    }

    @Override
    public String getDisplayName() {
        return m_sName;
    }

    @Override
    public String getDisplayDescription() {
        return null;
    }

    @Override
    public javax.swing.JComponent getDisplayComponent() {
        return null;
    }

    @Override
    public void writeVisor(int animation, String sLine1, String sLine2) {
        m_displaylines.writeVisor(animation, sLine1, sLine2);
    }

    @Override
    public void writeVisor(String sLine1, String sLine2) {
        m_displaylines.writeVisor(sLine1, sLine2);
    }

    @Override
    public void clearVisor() {
        m_displaylines.clearVisor();
    }

    @Override
    public void repaintLines() {
        try {
            m_ld.displayTextAt(0, 0, m_displaylines.getLine1(), LineDisplayConst.DISP_DT_NORMAL);
            m_ld.displayTextAt(1, 0, m_displaylines.getLine2(), LineDisplayConst.DISP_DT_NORMAL);
        } catch (JposException e) {
        }
    }

    @Override
    public void finalize() throws Throwable {

        m_ld.setDeviceEnabled(false);
        m_ld.release();
        m_ld.close();

        super.finalize();
    }
}
