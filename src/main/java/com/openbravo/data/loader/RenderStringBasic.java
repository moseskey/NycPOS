package com.openbravo.data.loader;

import com.openbravo.format.Formats;

public class RenderStringBasic implements IRenderString {

    private Formats[] m_aFormats;
    private int[] m_aiIndex;

    /**
     * Creates a new instance of StringnizerBasic
     * @param aiIndex
     */
    public RenderStringBasic(Formats[] fmts, int[] aiIndex) {
        m_aFormats = fmts;
        m_aiIndex = aiIndex;
    }

    public String getRenderString(Object value) {

        if (value == null) {
            return null;
        } else {
            Object [] avalue = (Object[]) value;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < m_aiIndex.length; i++) {
                if (i > 0) {
                    sb.append(" - ");
                }
                sb.append(m_aFormats[m_aiIndex[i]].formatValue(avalue[m_aiIndex[i]]));
            }

            return sb.toString();
        }
    }

}
