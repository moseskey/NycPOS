package com.openbravo.pos.payment;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.DataRead;
import com.openbravo.data.loader.SerializableRead;
import com.openbravo.format.Formats;

public class PaymentInfoTicket extends PaymentInfo implements SerializableRead  {

    private static final long serialVersionUID = 8865238639097L;
    private double m_dTicket;
    private String m_sName;
    private String m_transactionID;
    private double m_dTendered;
    private double m_change;
    private String m_dCardName = null;

    public PaymentInfoTicket(double dTicket, String sName) {
        m_sName = sName;
        m_dTicket = dTicket;
    }

    public PaymentInfoTicket(double dTicket, String sName, String transactionID) {
        m_sName = sName;
        m_dTicket = dTicket;
        m_transactionID = transactionID;
    }

    public PaymentInfoTicket() {
        m_sName = null;
        m_dTicket = 0.0;
        m_transactionID = null;
        m_dTendered = 0.00;
    }

    @Override
    public void readValues(DataRead dr) throws BasicException {
        m_sName = dr.getString(1);
        m_dTicket = dr.getDouble(2);
        m_transactionID = dr.getString(3);
        if (dr.getDouble(4) != null) {
            m_dTendered = dr.getDouble(4);
        }
        m_dCardName = dr.getString(5);
    }

    @Override
    public PaymentInfo copyPayment() {
        return new PaymentInfoTicket(m_dTicket, m_sName);
    }

    @Override
    public String getName() {
        return m_sName;
    }

    @Override
    public double getTotal() {
        return m_dTicket;
    }

    @Override
    public String getTransactionID() {
        return m_transactionID;
    }

    @Override
    public double getPaid() {
        return (0.0);
    }

    @Override
    public double getChange() {
        return m_dTendered - m_dTicket;
    }

    @Override
    public double getTendered() {
        return (0.0);
    }

    @Override
    public String getCardName() {
        return m_dCardName;
    }


    public String printPaid() {
        return Formats.CURRENCY.formatValue(m_dTicket);
    }

    // Especificas

    public String printPaperTotal() {
        // En una devolucion hay que cambiar el signo al total
        return Formats.CURRENCY.formatValue(-m_dTicket);
    }

    public String printChange() {
        return Formats.CURRENCY.formatValue(m_dTendered - m_dTicket);
    }

    public String printTendered() {
        return Formats.CURRENCY.formatValue(m_dTendered);
    }

}

