package com.openbravo.pos.ticket;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.DataRead;
import com.openbravo.data.loader.IKeyed;
import com.openbravo.data.loader.SerializerRead;
import com.openbravo.format.Formats;

/**
 *
 * @version
 */
public class SalesDetailInfo_1 implements IKeyed {

    private static final long serialVersionUID = 8612449444103L;
    private String productName;
    private int lineNO;

    public int getLineNO() {
        return lineNO;
    }

    public void setLineNO(int lineNO) {
        this.lineNO = lineNO;
    }

    public double getPrice() {
        return price;
    }

    public String printPrice() {
        return Formats.CURRENCY.formatValue(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    private double price;

    public SalesDetailInfo_1(int lineNo, String productName, double price) {
        this.lineNO = lineNo;
        this.productName = productName;
        this.price = price;
    }

    public static SerializerRead getSerializerRead() {
        return new SerializerRead() {
            @Override
            public Object readValues(DataRead dr) throws BasicException {
                return new SalesDetailInfo(dr.getInt(1), dr.getString(2), dr.getDouble(3));
            }
        };
    }

    @Override
    public Object getKey() {
        return getLineNO();
    }
}
