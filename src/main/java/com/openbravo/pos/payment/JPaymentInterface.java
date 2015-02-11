package com.openbravo.pos.payment;

import com.openbravo.pos.customers.CustomerInfoExt;
import java.awt.Component;

public interface JPaymentInterface {

    public void activate(CustomerInfoExt customerext, double dTotal, String transactionID);

    public PaymentInfo executePayment();

    public Component getComponent();
}
