package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public class SerializerReadInteger implements SerializerRead {

    public static final SerializerRead INSTANCE = new SerializerReadInteger();

    private SerializerReadInteger() {
    }

    public Object readValues(DataRead dr) throws BasicException {
        return Datas.INT.getValue(dr, 1);
    }
}
