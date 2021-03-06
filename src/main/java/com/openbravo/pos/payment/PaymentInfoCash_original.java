package com.openbravo.pos.payment;

import com.openbravo.format.Formats;

public class PaymentInfoCash_original extends PaymentInfo {

    private double m_dPaid;
    private double m_dTotal;
    private double m_dTendered;
    private String m_dCardName = null;

    public PaymentInfoCash_original(double dTotal, double dPaid) {
        m_dTotal = dTotal;
        m_dPaid = dPaid;
    }

    @Override
    public PaymentInfo copyPayment() {
        return new PaymentInfoCash_original(m_dTotal, m_dPaid);
    }

    @Override
    public String getTransactionID() {
        return "no ID";
    }

    @Override
    public String getName() {
        return "cash";
    }

    @Override
    public double getTotal() {
        return m_dTotal;
    }

    @Override
    public double getPaid() {
        return m_dPaid;
    }

    @Override
    public double getTendered() {
        return m_dTendered;
    }

    @Override
    public double getChange() {
        return m_dPaid - m_dTotal;
    }

    @Override
    public String getCardName() {
        return m_dCardName;
    }

    public String printPaid() {
        return Formats.CURRENCY.formatValue(new Double(m_dPaid));
    }

    public String printChange() {
        return Formats.CURRENCY.formatValue(new Double(m_dPaid - m_dTotal));
    }

}
