package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public interface SerializableWrite {

    public void writeValues(DataWrite dp) throws BasicException;
}
