package com.openbravo.pos.payment;

import java.awt.*;

public class JPaymentSelectCustomer extends JPaymentSelect {

    protected JPaymentSelectCustomer(java.awt.Frame parent, boolean modal, ComponentOrientation o) {
        super(parent, modal, o);
    }
    protected JPaymentSelectCustomer(java.awt.Dialog parent, boolean modal, ComponentOrientation o) {
        super(parent, modal, o);
    }

    public static JPaymentSelect getDialog(Component parent) {

        Window window = getWindow(parent);

        if (window instanceof Frame) {
            return new JPaymentSelectCustomer((Frame) window, true, parent.getComponentOrientation());
        } else {
            return new JPaymentSelectCustomer((Dialog) window, true, parent.getComponentOrientation());
        }
    }

    @Override
    protected void addTabs() {
// Bank Payment Receipt - Thanks Steve Clough! August 2011
        addTabPayment(new JPaymentSelect.JPaymentCashCreator());
        addTabPayment(new JPaymentSelect.JPaymentChequeCreator());
        addTabPayment(new JPaymentSelect.JPaymentPaperCreator());
        addTabPayment(new JPaymentSelect.JPaymentBankCreator());
        addTabPayment(new JPaymentSelect.JPaymentMagcardCreator());
        setHeaderVisible(true);
    }

    @Override
    protected void setStatusPanel(boolean isPositive, boolean isComplete) {

        setAddEnabled(isPositive && !isComplete);
        setOKEnabled(isPositive);
    }

    @Override
    protected PaymentInfo getDefaultPayment(double total) {
        return new PaymentInfoCash_original(total, total);
    }
}
