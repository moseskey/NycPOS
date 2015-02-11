package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public interface DataResultSet extends DataRead {

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

    /**
     *
     * @throws BasicException
     */
    public void close() throws BasicException;

    /**
     *
     * @throws BasicException
     */
    public int updateCount() throws BasicException;
}
