package com.openbravo.pos.ticket;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.DataRead;
import com.openbravo.data.loader.ImageUtils;
import com.openbravo.data.loader.SerializerRead;
import com.openbravo.format.Formats;
import java.awt.image.BufferedImage;
import java.util.Properties;

public class ProductInfoExt {

    private static final long serialVersionUID = 7587696873036L;

    protected String m_ID;

    protected String m_sRef;

    protected String m_sCode;

    protected String m_sName;

    protected boolean m_bCom;

    protected boolean m_bScale;

    protected double m_dPriceBuy;

    protected double m_dPriceSell;

    protected String categoryid;

    protected String taxcategoryid;

    protected String attributesetid;

    protected BufferedImage m_Image;

    protected double m_stockCost;

    protected double m_stockVolume;
// ADDED JG 20.12.10 - Kitchen Print

    protected boolean m_bKitchen;
// ADDED JG 25.06.11 - Service
    private boolean m_bService;

    protected Properties attributes;
// ADDED JG 13 Nov 12 - Display

    protected String m_sDisplay;
// ADDED JDL 19.12.12 - Variable price product

    protected boolean m_bVprice;
// ADDED JDL 09.02.13

    protected boolean m_bVerpatrib;
// ADDED JDL 10.04.13

    protected String m_sTextTip;
// ADDED JDL 25.05.13

    protected boolean m_bWarranty;

    /**
    * JG 7 June 2014 Stock Units
    */
    public double m_dStockUnits;


    public ProductInfoExt() {
        m_ID = null;                    //1
        m_sRef = "0000";                //2
        m_sCode = "0000";               //3
        m_sName = null;                 //4
        m_bCom = false;                 //5
        m_bScale = false;               //6
        categoryid = null;              //7
        taxcategoryid = null;           //8
        attributesetid = null;          //9
        m_dPriceBuy = 0.0;              //10
        m_dPriceSell = 0.0;             //11
        m_stockCost = 0.0;              //12
        m_stockVolume = 0.0;            //13
        m_Image = null;                 //14
// ADDED JG 20.12.10 - Kitchen Print
        m_bKitchen = false;             //15
// ADDED JG 25.06.11 - Is Service
        m_bService = false;             //16
// ADDED JG 13 Nov 12 - Display
        m_sDisplay = null;              //17
        attributes = new Properties();  //18
// ADDED JDL 19.12.12 - Variable price product
        m_bVprice = false;              //19
// ADDED JDL 09.02.13
        m_bVerpatrib = false;           //20
// ADDED JDL 10.04.13
        m_sTextTip = null;              //21
// ADDED JDL 25.05.13
        m_bWarranty = false;            //22
// ADDED JG 7 June 2014 - Display
        m_dStockUnits = 0.0;              //23

    }

    public final String getID() {
        return m_ID;
    }

    public final void setID(String id) {
        m_ID = id;
    }

    public final String getReference() {
        return m_sRef;
    }

    public final void setReference(String sRef) {
        m_sRef = sRef;
    }

    public final String getCode() {
        return m_sCode;
    }

    public final void setCode(String sCode) {
        m_sCode = sCode;
    }

    public final String getName() {
        return m_sName;
    }

    public final void setName(String sName) {
        m_sName = sName;
    }

// ADDED JG 13 Nov 12 - Display

    public final String getDisplay() {
        return m_sDisplay;
    }

    public final void setDisplay(String sDisplay) {
        m_sDisplay = sDisplay;
    }
//**

    /**
     *
     */
    public final boolean isCom() {
        return m_bCom;
    }

    public final void setCom(boolean bValue) {
        m_bCom = bValue;
    }

    public final boolean isScale() {
        return m_bScale;
    }

    public final void setScale(boolean bValue) {
        m_bScale = bValue;
    }

// ADDED JG 20.12.10 - Kitchen Print

    public final boolean isKitchen() {
        return m_bKitchen;
    }

    public final void setKitchen(boolean bValue) {
        m_bKitchen = bValue;
    }
// **

// ADDED JG 25.06.11 - Is Service

    public final boolean isService() {
        return m_bService;
    }

    public final void setService(boolean bValue) {
        m_bService = bValue;
    }
// **

// ADDED JDL 19.12.12 - Variable price product
    public final boolean isVprice() {
        return m_bVprice;
    }

    // ADDED JDL 09.02.13 - for Chris
    public final boolean isVerpatrib() {
        return m_bVerpatrib;
    }

    public final String getTextTip() {
        return m_sTextTip;
    }

    public final boolean getWarranty() {
        return m_bWarranty;
    }

    public final void setWarranty(boolean bValue) {
        m_bWarranty = bValue;
    }

    public final String getCategoryID() {
        return categoryid;
    }

    public final void setCategoryID(String sCategoryID) {
        categoryid = sCategoryID;
    }

    public final String getTaxCategoryID() {
        return taxcategoryid;
    }

    public final void setTaxCategoryID(String value) {
        taxcategoryid = value;
    }

    public final String getAttributeSetID() {
        return attributesetid;
    }

    public final void setAttributeSetID(String value) {
        attributesetid = value;
    }

    public final double getPriceBuy() {
        return m_dPriceBuy;
    }

    public final void setPriceBuy(double dPrice) {
        m_dPriceBuy = dPrice;
    }

    public final double getPriceSell() {
        return m_dPriceSell;
    }

    public final void setPriceSell(double dPrice) {
        m_dPriceSell = dPrice;
    }

    /**
     * JG 7 June 2014
     *
     */
    public final Double getStockUnits() {
        return m_dStockUnits;

    }
    public final void setStockUnits(double dStockUnits) {
        m_dStockUnits = dStockUnits;
    }

    public final double getStockVolume() {
        return m_stockVolume;
    }

    public final void setStockVolume(double dStockVolume) {
        m_stockVolume = dStockVolume;
    }

    public final double getStockCost() {
        return m_stockCost;
    }

    public final void setStockCost(double dPrice) {
        m_stockCost = dPrice;
    }

    public final void setTextTip(String value) {
        m_sTextTip = value;
    }

    public final double getPriceSellTax(TaxInfo tax) {
        return m_dPriceSell * (1.0 + tax.getRate());
    }

    public String printPriceSell() {
        return Formats.CURRENCY.formatValue(new Double(getPriceSell()));
    }

    public String printPriceSellTax(TaxInfo tax) {
        return Formats.CURRENCY.formatValue(new Double(getPriceSellTax(tax)));
    }

    public BufferedImage getImage() {
        return m_Image;
    }

    public void setImage(BufferedImage img) {
        m_Image = img;
    }

    public String getProperty(String key) {
        return attributes.getProperty(key);
    }

    public String getProperty(String key, String defaultvalue) {
        return attributes.getProperty(key, defaultvalue);
    }

    public void setProperty(String key, String value) {
        attributes.setProperty(key, value);
    }

    public Properties getProperties() {
        return attributes;
    }

    public static SerializerRead getSerializerRead() {
        return new SerializerRead() {
            @Override
            public Object readValues(DataRead dr) throws BasicException {
                ProductInfoExt product = new ProductInfoExt();
                product.m_ID = dr.getString(1);
                product.m_sRef = dr.getString(2);
                product.m_sCode = dr.getString(3);
                product.m_sName = dr.getString(4);
                product.m_bCom = dr.getBoolean(5);
                product.m_bScale = dr.getBoolean(6);
                product.m_dPriceBuy = dr.getDouble(7);
                product.m_dPriceSell = dr.getDouble(8);
                product.taxcategoryid = dr.getString(9);
                product.categoryid = dr.getString(10);
                product.attributesetid = dr.getString(11);
                product.m_Image = ImageUtils.readImage(dr.getBytes(12));
                product.attributes = ImageUtils.readProperties(dr.getBytes(13));
                product.m_bKitchen = dr.getBoolean(14);
                product.m_bService = dr.getBoolean(15);
// ADDED JG 13 Nov 12 - Display
                product.m_sDisplay = dr.getString(16);
// ADDED JDL 19.12.12
                product.m_bVprice = dr.getBoolean(17);
// ADDED JDL 09.0.2.13 for Chris
                product.m_bVerpatrib = dr.getBoolean(18);
// ADDED JDL 09.04.13
                product.m_sTextTip = dr.getString(19);
// ADDED JDL 25.04.13
                product.m_bWarranty = dr.getBoolean(20);
// JG July 2014 - added for Stock count
                product.m_dStockUnits = dr.getDouble(21);

                return product;
            }
        };
    }

    @Override
    public final String toString() {
        return m_sRef + " - " + m_sName;
    }
}
