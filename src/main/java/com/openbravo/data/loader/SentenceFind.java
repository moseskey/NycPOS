package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public interface SentenceFind {

    /**
     *
     * @throws BasicException
     */
    public Object find() throws BasicException;

    /**
     *
     * @throws BasicException
     */
    public Object find(Object params) throws BasicException;

    /**
     *
     * @throws BasicException
     */
    public Object find(Object... params) throws BasicException;
}
