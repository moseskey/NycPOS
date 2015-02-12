package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public class SerializerReadBasic implements SerializerRead {

    private Datas[] m_classes;

    public SerializerReadBasic(Datas[] classes) {
        m_classes = classes;
    }

    public Object readValues(DataRead dr) throws BasicException {

        Object[] m_values = new Object[m_classes.length];
        for (int i = 0; i < m_classes.length; i++) {
            m_values[i] = m_classes[i].getValue(dr, i + 1);
        }
        return m_values;
    }
}
