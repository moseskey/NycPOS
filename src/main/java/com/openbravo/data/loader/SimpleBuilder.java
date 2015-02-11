package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public class SimpleBuilder implements ISQLBuilderStatic {

    private String m_sSentence;

    /**
     * Creates a new instance of SimpleBuilder
     * @param sSentence */
    public SimpleBuilder(String sSentence) {
        m_sSentence = sSentence;
    }

    /**
     *
     * @throws BasicException
     */
    public String getSQL(SerializerWrite sw, Object params) throws BasicException {
        return m_sSentence;
    }

}
