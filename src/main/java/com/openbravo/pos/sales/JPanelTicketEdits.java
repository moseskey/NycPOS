package com.openbravo.pos.sales;

import com.openbravo.basic.BasicException;
import com.openbravo.pos.ticket.ProductInfoExt;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class JPanelTicketEdits extends JPanelTicket {

    private JTicketCatalogLines m_catandlines;

    public JPanelTicketEdits() {
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public void activate() throws BasicException {
        super.activate();
        m_catandlines.loadCatalog();
    }

    public void showCatalog() {
        m_jbtnconfig.setVisible(true);
        m_catandlines.showCatalog();
    }

    public void showRefundLines(List aRefundLines) {
        // anado las lineas de refund
        // m_reflines.setLines(aRefundLines);
        m_jbtnconfig.setVisible(false);
        m_catandlines.showRefundLines(aRefundLines);
    }

    @Override
    protected JTicketsBag getJTicketsBag() {
        return new JTicketsBagTicket(m_App, this);
    }

    @Override
    protected Component getSouthComponent() {

        m_catandlines = new JTicketCatalogLines(m_App, this,
                                                "true".equals(m_jbtnconfig.getProperty("pricevisible")),
                                                "true".equals(m_jbtnconfig.getProperty("taxesincluded")),
                                                Integer.parseInt(m_jbtnconfig.getProperty("img-width", "64")),
                                                Integer.parseInt(m_jbtnconfig.getProperty("img-height", "54")));
        m_catandlines.setPreferredSize(new Dimension(
                                           0,
                                           Integer.parseInt(m_jbtnconfig.getProperty("cat-height", "245"))));
        m_catandlines.addActionListener(new CatalogListener());
        return m_catandlines;
    }

    @Override
    protected void resetSouthComponent() {
    }

    private class CatalogListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            buttonTransition((ProductInfoExt) e.getSource());
        }
    }

}
