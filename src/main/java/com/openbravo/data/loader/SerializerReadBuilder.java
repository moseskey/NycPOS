package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public class SerializerReadBuilder  implements SerializerRead {

    private SerializableBuilder m_sb;

    /**
     * Creates a new instance of SerializerReadBuilder
     * @param sb */
    public SerializerReadBuilder(SerializableBuilder sb) {
        m_sb = sb;
    }

    /**
     *
     * @throws BasicException
     */
    public Object readValues(DataRead dr) throws BasicException {
        SerializableRead sr = m_sb.createNew();
        sr.readValues(dr);
        return sr;
    }

}
