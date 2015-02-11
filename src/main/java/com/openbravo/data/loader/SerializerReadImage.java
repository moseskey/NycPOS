package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public class SerializerReadImage implements SerializerRead {

    public static final SerializerRead INSTANCE = new SerializerReadImage();

    /**
     * Creates a new instance of SerializerReadImage */
    private SerializerReadImage() {
    }

    /**
     *
     * @throws BasicException
     */
    public Object readValues(DataRead dr) throws BasicException {
        return Datas.IMAGE.getValue(dr,1);
    }

}
