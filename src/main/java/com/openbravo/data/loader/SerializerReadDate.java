package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;


public class SerializerReadDate implements SerializerRead {

    public static final SerializerRead INSTANCE = new SerializerReadDate();

    private SerializerReadDate() {
    }

    @Override
    public Object readValues(DataRead dr) throws BasicException {
        return Datas.TIMESTAMP.getValue(dr, 1);
    }
}
