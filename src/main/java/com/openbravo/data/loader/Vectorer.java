package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public interface Vectorer {

    // public int size();

    /**
     *
     * @throws BasicException
     */
        public String[] getHeaders() throws BasicException;

    /**
     *
     * @throws BasicException
     */
    public String[] getValues(Object obj) throws BasicException;
}
