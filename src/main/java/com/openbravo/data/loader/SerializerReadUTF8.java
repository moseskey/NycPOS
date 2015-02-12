package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public class SerializerReadUTF8 implements SerializerRead {

    public static final SerializerRead INSTANCE = new SerializerReadUTF8();

    private SerializerReadUTF8() {
    }

    public Object readValues(DataRead dr) throws BasicException {
        try {
            return new String((byte[]) Datas.BYTES.getValue(dr,1), "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            return null;
        }
    }
}
