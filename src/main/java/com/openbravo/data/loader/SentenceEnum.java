package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public interface SentenceEnum {

    /**
     *
     * @throws BasicException
     */
    public void load() throws BasicException;

    /**
     *
     * @throws BasicException
     */
    public void load(Object params) throws BasicException;

    /**
     *
     * @throws BasicException
     */
    public Object getCurrent() throws BasicException;

    /**
     *
     * @throws BasicException
     */
    public boolean next() throws BasicException;
}
