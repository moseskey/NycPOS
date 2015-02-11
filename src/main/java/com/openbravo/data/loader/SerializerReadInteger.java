package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public class SerializerReadInteger implements SerializerRead {

    public static final SerializerRead INSTANCE = new SerializerReadInteger();

    /**
     * Creates a new instance of SerializerReadInteger
     */
    private SerializerReadInteger() {
    }

    /**
     *
     * @throws BasicException
     */
    public Object readValues(DataRead dr) throws BasicException {
        return Datas.INT.getValue(dr,1);
    }
}
