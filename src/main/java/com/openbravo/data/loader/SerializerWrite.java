package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public interface SerializerWrite<T> {

    public void writeValues(DataWrite dp, T obj) throws BasicException;
}
