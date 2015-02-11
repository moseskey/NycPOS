package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public interface ISQLBuilderStatic {

    /**
     *
     * @throws BasicException
     */
    public String getSQL(SerializerWrite sw, Object params) throws BasicException;
}
