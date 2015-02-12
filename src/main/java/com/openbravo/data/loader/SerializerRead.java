package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public interface SerializerRead {

    public Object readValues(DataRead dr) throws BasicException;
}
