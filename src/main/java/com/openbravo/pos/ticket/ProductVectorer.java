package com.openbravo.pos.ticket;

import com.openbravo.format.Formats;
import com.openbravo.data.loader.Vectorer;
import com.openbravo.basic.BasicException;
import com.openbravo.pos.forms.AppLocal;
public class ProductVectorer implements Vectorer {

    private static String[] m_sHeaders = {
        AppLocal.getIntString("label.prodref"),
        AppLocal.getIntString("label.prodbarcode"),
        AppLocal.getIntString("label.prodname"),
        AppLocal.getIntString("label.prodpricebuy"),
        AppLocal.getIntString("label.prodpricesell")
    };

    /**
     * Creates a new instance of ProductVectorer
     */
    public ProductVectorer() {
    }

    /**
     *
     * @throws BasicException
     */
    public String[] getHeaders() throws BasicException {
        return m_sHeaders;
    }

    /**
     *
     * @throws BasicException
     */
    public String[] getValues(Object obj) throws BasicException {
        ProductInfoExt myprod = (ProductInfoExt) obj;
        String[] m_sValues = new String[5];
        m_sValues[0] = Formats.STRING.formatValue(myprod.getReference());
        m_sValues[1] = Formats.STRING.formatValue(myprod.getCode());
        m_sValues[2] = Formats.STRING.formatValue(myprod.getName());
        m_sValues[3] = Formats.CURRENCY.formatValue(new Double(myprod.getPriceBuy()));
        m_sValues[4] = Formats.CURRENCY.formatValue(new Double(myprod.getPriceSell()));
        return m_sValues;
    }
}
