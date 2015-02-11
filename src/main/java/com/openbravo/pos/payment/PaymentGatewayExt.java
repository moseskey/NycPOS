package com.openbravo.pos.payment;

public class PaymentGatewayExt implements PaymentGateway {

    /**
     * Creates a new instance of PaymentGatewayExt
     */
    public PaymentGatewayExt() {
    }

    @Override
    public void execute(PaymentInfoMagcard payinfo) {
        payinfo.paymentOK("OK", payinfo.getTransactionID() , "");
    }
}
