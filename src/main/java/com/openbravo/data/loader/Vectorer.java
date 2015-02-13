package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public interface Vectorer {

    // public int size();

    public String[] getHeaders() throws BasicException;

    public String[] getValues(Object obj) throws BasicException;
}
