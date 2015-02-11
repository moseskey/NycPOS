package com.openbravo.pos.payment;

import javax.swing.JComponent;

public interface PaymentPanel {

    public void activate(String sTransaction, double dTotal);

    public JComponent getComponent();

    public PaymentInfoMagcard getPaymentInfoMagcard();
}
