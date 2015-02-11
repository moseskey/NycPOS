package com.openbravo.data.user;

import com.openbravo.basic.BasicException;

public interface Finder {

    /**
     *
     * @throws BasicException
     */
    public boolean match(Object obj) throws BasicException;
}
