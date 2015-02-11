package com.openbravo.pos.payment;

public interface PaymentGateway {

    public void execute(PaymentInfoMagcard payinfo);
}
