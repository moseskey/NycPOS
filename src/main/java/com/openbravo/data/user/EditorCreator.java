package com.openbravo.data.user;

import com.openbravo.basic.BasicException;

public interface EditorCreator {

    /**
     *
     * @throws BasicException
     */
    public Object createValue() throws BasicException;
}
