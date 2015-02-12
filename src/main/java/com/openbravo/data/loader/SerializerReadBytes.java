package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public class SerializerReadBytes implements SerializerRead {

    public static final SerializerRead INSTANCE = new SerializerReadBytes();

    private SerializerReadBytes() {
    }

    public Object readValues(DataRead dr) throws BasicException {
        return Datas.BYTES.getValue(dr,1);
    }
}
