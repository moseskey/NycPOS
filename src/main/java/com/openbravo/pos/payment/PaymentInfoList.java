package com.openbravo.pos.payment;

import java.util.Iterator;
import java.util.LinkedList;

public class PaymentInfoList {

    private final LinkedList<PaymentInfo> m_apayment;

    /**
     * Creates a new instance of PaymentInfoComposed
     */
    public PaymentInfoList() {
// JG 16 May 12 use diamond inference
        m_apayment = new LinkedList<>();
    }

    public double getTotal() {

        double dTotal = 0.0;
        Iterator i = m_apayment.iterator();
        while (i.hasNext()) {
            PaymentInfo p = (PaymentInfo) i.next();
            dTotal += p.getTotal();
        }

        return dTotal;
    }

    public boolean isEmpty() {
        return m_apayment.isEmpty();
    }

    public void add(PaymentInfo p) {
        m_apayment.addLast(p);
    }

    public void removeLast() {
        m_apayment.removeLast();
    }

    public LinkedList<PaymentInfo> getPayments() {
        return m_apayment;
    }
}
