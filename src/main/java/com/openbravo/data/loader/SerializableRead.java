package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public interface SerializableRead {

    public void readValues(DataRead dr) throws BasicException;
}
