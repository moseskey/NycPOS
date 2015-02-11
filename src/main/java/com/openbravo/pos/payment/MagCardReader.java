package com.openbravo.pos.payment;

public interface MagCardReader {

    public String getReaderName();

    public void reset();

    public void appendChar(char c);

    public boolean isComplete();

    public String getHolderName();

    public String getCardNumber();

    public String getExpirationDate();

    public String getTrack1();

    public String getTrack2();

    public String getTrack3();
}
