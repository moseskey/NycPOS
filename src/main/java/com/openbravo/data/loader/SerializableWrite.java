package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public interface SerializableWrite {

    /**
     *
     * @throws BasicException
     */
    public void writeValues(DataWrite dp) throws BasicException;
}
