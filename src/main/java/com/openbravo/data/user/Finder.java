package com.openbravo.data.user;

import com.openbravo.basic.BasicException;

public interface Finder {

    public boolean match(Object obj) throws BasicException;
}
