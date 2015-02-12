package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public class SerializerWriteInteger implements SerializerWrite<Integer> {

    public static final SerializerWrite INSTANCE = new SerializerWriteInteger();

    private SerializerWriteInteger() {
    }

    public void writeValues(DataWrite dp, Integer obj) throws BasicException {
        Datas.INT.setValue(dp, 1, obj);
    }
}
