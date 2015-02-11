package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public class SerializerWriteString implements SerializerWrite<String> {

    public static final SerializerWrite INSTANCE = new SerializerWriteString();

    /**
     * Creates a new instance of SerializerWriteString
     */
    private SerializerWriteString() {
    }

    /**
     *
     * @throws BasicException
     */
    public void writeValues(DataWrite dp, String obj) throws BasicException {
        Datas.STRING.setValue(dp, 1, obj);
    }
}
