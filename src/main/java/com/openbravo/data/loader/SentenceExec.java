package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public interface SentenceExec {

    /**
     *
     * @throws BasicException
     */
    public int exec() throws BasicException;

    /**
     *
     * @throws BasicException
     */
    public int exec(Object params) throws BasicException;

    /**
     *
     * @throws BasicException
     */
    public int exec(Object... params) throws BasicException;
}
