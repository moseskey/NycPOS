package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public abstract class SentenceExecAdapter implements SentenceExec {

    /**
     *
     * @throws BasicException
     */
    public int exec() throws BasicException {
        return exec((Object) null);
    }

    /**
     *
     * @throws BasicException
     */
    public int exec(Object... params) throws BasicException {
        return exec((Object) params);
    }

    /**
     *
     * @throws BasicException
     */
    public abstract int exec(Object params) throws BasicException;
}
