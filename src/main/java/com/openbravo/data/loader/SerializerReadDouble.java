package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public class SerializerReadDouble implements SerializerRead {

    public static final SerializerRead INSTANCE = new SerializerReadDouble();

    /**
     * Creates a new instance of SerializerReadInteger
     */
    public SerializerReadDouble() {
    }

    /**
     *
     * @throws BasicException
     */
    public Object readValues(DataRead dr) throws BasicException {
        return Datas.DOUBLE.getValue(dr,1);
    }
}
