package com.openbravo.data.loader;

import com.openbravo.format.Formats;
import com.openbravo.basic.BasicException;

public class VectorerBasic implements Vectorer {

    private int[] m_aiIndex;
    private String[] m_asHeaders;
    private Formats[] m_aFormats;

    public VectorerBasic(String[] asHeaders, Formats[] aFormats, int[] aiIndex) {
        m_asHeaders = asHeaders;
        m_aFormats = aFormats;
        m_aiIndex = aiIndex;
    }

    public String[] getHeaders() throws BasicException {

        String[] asvalues = new String[m_aiIndex.length];
        for (int i = 0; i < m_aiIndex.length; i++) {
            asvalues[i] = m_asHeaders[m_aiIndex[i]];
        }

        return asvalues;
    }

    public String[] getValues(Object obj) throws BasicException {
        Object[] avalues = (Object[]) obj;
        String[] asvalues = new String[m_aiIndex.length];
        for (int i = 0; i < m_aiIndex.length; i++) {
            asvalues[i] = m_aFormats[m_aiIndex[i]].formatValue(avalues[m_aiIndex[i]]);
        }

        return asvalues;
    }
}
