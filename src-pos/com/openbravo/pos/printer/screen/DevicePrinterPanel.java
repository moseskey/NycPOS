//    uniCenta oPOS  - Touch Friendly Point Of Sale
//    Copyright (c) 2009-2014 uniCenta & previous Openbravo POS works
//    http://www.unicenta.com
//
//    This file is part of uniCenta oPOS
//
//    uniCenta oPOS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//   uniCenta oPOS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with uniCenta oPOS.  If not, see <http://www.gnu.org/licenses/>.

package com.openbravo.pos.printer.screen;

import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.forms.AppProperties;
import com.openbravo.pos.printer.DevicePrinter;
import com.openbravo.pos.printer.ticket.BasicTicket;
import com.openbravo.pos.printer.ticket.BasicTicketForScreen;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

/**
 *
 * @author JG uniCenta
 */
public class DevicePrinterPanel extends javax.swing.JPanel implements DevicePrinter {

    private final String m_sName;

    private final JTicketContainer m_jTicketContainer;
    private BasicTicket m_ticketcurrent;
    private final AppProperties m_props;

    /** Creates new form JPrinterScreen2
     * @param props */
//JG July 2014 - Thank you Ron Isaacson    public DevicePrinterPanel() {
    public DevicePrinterPanel(AppProperties props) {
        initComponents();

        m_sName = AppLocal.getIntString("Printer.Screen");

         m_ticketcurrent = null;

        m_jTicketContainer = new JTicketContainer();
        m_jScrollView.setViewportView(m_jTicketContainer);

        m_props = props;
    }

    /**
     *
     * @return
     */
    @Override
    public String getPrinterName() {
        return m_sName;
    }

    /**
     *
     */
    @Override
    public void printLogo(){
    }

    /**
     *
     * @return
     */
    @Override
    public String getPrinterDescription() {
        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public JComponent getPrinterComponent() {
        return this;
    }

    /**
     *
     */
    @Override
    public void reset() {
        m_ticketcurrent = null;
        m_jTicketContainer.removeAllTickets();
        m_jTicketContainer.repaint();
    }

    // INTERFAZ PRINTER 2

    /**
     *
     */
        @Override
    public void beginReceipt() {
//JG July 2014 - Thank you Ron Isaacson        m_ticketcurrent = new BasicTicket();
        m_ticketcurrent = new BasicTicketForScreen();

    }

    /**
     *
     * @param image
     */
    @Override
    public void printImage(BufferedImage image) {
        m_ticketcurrent.printImage(image);
    }

    /**
     *
     * @param type
     * @param position
     * @param code
     */
    @Override
    public void printBarCode(String type, String position, String code) {
        m_ticketcurrent.printBarCode(type, position, code);
    }

    /**
     *
     * @param iTextSize
     */
    @Override
    public void beginLine(int iTextSize) {
        m_ticketcurrent.beginLine(iTextSize);
    }

    /**
     *
     * @param iStyle
     * @param sText
     */
    @Override
    public void printText(int iStyle, String sText) {
        m_ticketcurrent.printText(iStyle, sText);
    }

    /**
     *
     */
    @Override
    public void endLine() {
        m_ticketcurrent.endLine();
    }

    /**
     *
     */
    @Override
    public void endReceipt() {
//JG July 2014 - Thank you Ron Isaacson        m_jTicketContainer.addTicket(new JTicket(m_ticketcurrent));
        m_jTicketContainer.addTicket(new JTicket(m_ticketcurrent, Integer.parseInt(m_props.getProperty("screen.receipt.columns"))));
        m_ticketcurrent = null;
    }

    /**
     *
     */
    @Override
    public void openDrawer() {
        // Una simulacion
        Toolkit.getDefaultToolkit().beep();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        m_jScrollView = new javax.swing.JScrollPane();

        setLayout(new java.awt.BorderLayout());

        m_jScrollView.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        add(m_jScrollView, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane m_jScrollView;
    // End of variables declaration//GEN-END:variables

}
