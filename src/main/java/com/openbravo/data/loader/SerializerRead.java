package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public interface SerializerRead {

    /**
     *
     * @throws BasicException
     */
    public Object readValues(DataRead dr) throws BasicException;
}
