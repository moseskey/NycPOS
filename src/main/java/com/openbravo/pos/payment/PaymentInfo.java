package com.openbravo.pos.payment;

import com.openbravo.format.Formats;

public abstract class PaymentInfo {

    public abstract String getName();

    public abstract double getTotal();

    public abstract PaymentInfo copyPayment();

    public abstract String getTransactionID();

    public abstract double getPaid();

    public abstract double getChange();

    public abstract double getTendered();

    public abstract String getCardName();

    public String printTotal() {
        return Formats.CURRENCY.formatValue(getTotal());
    }
}
