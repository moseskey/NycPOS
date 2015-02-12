package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public interface SentenceFind {

    public Object find() throws BasicException;

    public Object find(Object params) throws BasicException;

    public Object find(Object... params) throws BasicException;
}
