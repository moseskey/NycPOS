package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public interface SentenceExec {

    public int exec() throws BasicException;

    public int exec(Object params) throws BasicException;

    public int exec(Object... params) throws BasicException;
}
