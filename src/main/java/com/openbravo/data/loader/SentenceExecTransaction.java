package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

/**
 *
 * Created on February 6, 2007, 4:06 PM
 *
 */
public abstract class SentenceExecTransaction implements SentenceExec {

    private Session m_s;

    public SentenceExecTransaction(Session s) {
        m_s = s;
    }

    /**
     *
     * @throws BasicException
     */
    public final int exec() throws BasicException {
        return exec((Object) null);
    }

    /**
     *
     * @throws BasicException
     */
    @Override
    public final int exec(Object... params) throws BasicException {
        return exec((Object) params);
    }

    /**
     *
     * @throws BasicException
     */
    @Override
    public final int exec(final Object params) throws BasicException {

        Transaction<Integer> t = new Transaction<Integer>(m_s) {
            @Override
            public Integer transact() throws BasicException{
                return execInTransaction(params);
            }
        };

        return t.execute();
    }

    /**
     *
     * @throws BasicException
     */
    protected abstract int execInTransaction(Object params) throws BasicException;
}

