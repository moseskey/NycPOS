package com.openbravo.pos.scanpal2;

public class ProductDownloaded {

    private String m_sCode;
    private double m_dQuantity;

    public ProductDownloaded() {
    }

    public void setCode(String value) {
        m_sCode = value;
    }

    public String getCode() {
        return m_sCode;
    }

    public void setQuantity(double value) {
        m_dQuantity = value;
    }

    public double getQuantity() {
        return m_dQuantity;
    }
}
