package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public class SerializerReadString implements SerializerRead {

    public static final SerializerRead INSTANCE = new SerializerReadString();

    private SerializerReadString() {
    }

    public Object readValues(DataRead dr) throws BasicException {
        return Datas.STRING.getValue(dr,1);
    }
}
