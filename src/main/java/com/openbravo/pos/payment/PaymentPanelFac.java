package com.openbravo.pos.payment;

public class PaymentPanelFac {

    /**
     * Creates a new instance of PaymentPanelFac
     */
    private PaymentPanelFac() {
    }

    public static PaymentPanel getPaymentPanel(String sReader, JPaymentNotifier notifier) {
// JG 16 May 12 use switch
        switch (sReader) {
            case "Intelligent":
                return new PaymentPanelMagCard(new MagCardReaderIntelligent(), notifier);
            case "Generic":
                return new PaymentPanelMagCard(new MagCardReaderGeneric(), notifier);
            case "Keyboard":
                return new PaymentPanelType(notifier);
            default:
                // "Not defined
           return new PaymentPanelBasic(notifier);
        }
    }
}
