package com.openbravo.pos.inventory;

import com.openbravo.format.Formats;
import com.openbravo.pos.ticket.ProductInfoExt;
import com.openbravo.pos.util.StringUtils;

public class InventoryLine {

    private double m_dMultiply;
    private double m_dPrice;

    private String m_sProdID;
    private String m_sProdName;

    private String attsetid;
    private String attsetinstid;
    private String attsetinstdesc;

    /**
     * Creates a new instance of InventoryLine
     * @param oProduct
     */
    public InventoryLine(ProductInfoExt oProduct) {
        m_sProdID = oProduct.getID();
        m_sProdName = oProduct.getName();
        m_dMultiply = 1.0;
        m_dPrice = oProduct.getPriceBuy();
        attsetid = oProduct.getAttributeSetID();
        attsetinstid = null;
        attsetinstdesc = null;
    }

    public InventoryLine(ProductInfoExt oProduct, double dpor, double dprice) {
        m_sProdID = oProduct.getID();
        m_sProdName = oProduct.getName();
        m_dMultiply = dpor;
        m_dPrice = dprice;
        attsetid = oProduct.getAttributeSetID();
        attsetinstid = null;
        attsetinstdesc = null;
    }

    public String getProductID() {
        return m_sProdID;
    }

    public String getProductName() {
        return m_sProdName;
    }

    public void setProductName(String sValue) {
        if (m_sProdID == null) {
            m_sProdName = sValue;
        }
    }

    public double getMultiply() {
        return m_dMultiply;
    }

    public void setMultiply(double dValue) {
        m_dMultiply = dValue;
    }

    public double getPrice() {
        return m_dPrice;
    }

    public void setPrice(double dValue) {
        m_dPrice = dValue;
    }

    public double getSubValue() {
        return m_dMultiply * m_dPrice;
    }

    public String getProductAttSetInstId() {
        return attsetinstid;
    }

    public void setProductAttSetInstId(String value) {
        attsetinstid = value;
    }

    public String getProductAttSetId() {
        return attsetid;
    }

    public String getProductAttSetInstDesc() {
        return attsetinstdesc;
    }

    public void setProductAttSetInstDesc(String value) {
        attsetinstdesc = value;
    }

    public String printName() {
        return StringUtils.encodeXML(m_sProdName);
    }

    public String printPrice() {
        if (m_dMultiply == 1.0) {
            return "";
        } else {
            return Formats.CURRENCY.formatValue(getPrice());
        }
    }

    public String printMultiply() {
        return Formats.DOUBLE.formatValue(m_dMultiply);
    }

    public String printSubValue() {
        return Formats.CURRENCY.formatValue(getSubValue());
    }
}
