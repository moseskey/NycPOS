package com.openbravo.pos.payment;

public class MagCardReaderFac {

    private MagCardReaderFac() {
    }

    public static MagCardReader getMagCardReader(String sReader) {
// JG 16 May 12 use switch
        switch (sReader) {
            case "Intelligent":
                return new MagCardReaderIntelligent();
            case "Generic":
                return new MagCardReaderGeneric();
            default:
                return null;
        }
    }
}
