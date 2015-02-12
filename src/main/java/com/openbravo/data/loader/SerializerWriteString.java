package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public class SerializerWriteString implements SerializerWrite<String> {

    public static final SerializerWrite INSTANCE = new SerializerWriteString();

    private SerializerWriteString() {
    }

    public void writeValues(DataWrite dp, String obj) throws BasicException {
        Datas.STRING.setValue(dp, 1, obj);
    }
}
