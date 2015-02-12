package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public interface DataResultSet extends DataRead {

    public Object getCurrent() throws BasicException;

    public boolean next() throws BasicException;

    public void close() throws BasicException;

    public int updateCount() throws BasicException;
}
