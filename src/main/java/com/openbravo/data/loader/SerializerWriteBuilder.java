package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public class SerializerWriteBuilder implements SerializerWrite<SerializableWrite> {

    public static final SerializerWrite INSTANCE = new SerializerWriteBuilder();

    private SerializerWriteBuilder() {
    }

    public void writeValues(DataWrite dp, SerializableWrite obj) throws BasicException {
        obj.writeValues(dp);
    }
}
