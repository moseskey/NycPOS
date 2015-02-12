package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public class SerializerReadImage implements SerializerRead {

    public static final SerializerRead INSTANCE = new SerializerReadImage();

    private SerializerReadImage() {
    }

    public Object readValues(DataRead dr) throws BasicException {
        return Datas.IMAGE.getValue(dr,1);
    }

}
