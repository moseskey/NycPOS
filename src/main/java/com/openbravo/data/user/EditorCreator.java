package com.openbravo.data.user;

import com.openbravo.basic.BasicException;

public interface EditorCreator {

    public Object createValue() throws BasicException;
}
