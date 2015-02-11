package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public class SerializerWriteBasicExt implements SerializerWrite<Object[]> {

    private Datas[] m_classes;
    private int[] m_index;

    /**
     * Creates a new instance of SerializerWriteBasic
     * @param index
     */
    public SerializerWriteBasicExt(Datas[] classes, int[] index) {
        m_classes = classes;
        m_index = index;
    }

    /**
     *
     * @throws BasicException
     */
    @Override
    public void writeValues(DataWrite dp, Object[] obj) throws BasicException {

        for (int i = 0; i < m_index.length; i++) {
            m_classes[m_index[i]].setValue(dp, i + 1, obj[m_index[i]]);
        }
    }

}
