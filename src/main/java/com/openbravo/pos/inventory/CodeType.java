package com.openbravo.pos.inventory;

import com.openbravo.data.loader.IKeyed;

public class CodeType implements IKeyed {

    public static final CodeType EAN13 = new CodeType("EAN13", "EAN13");

    public static final CodeType CODE128 = new CodeType("CODE128", "CODE128");

    protected String m_sKey;

    protected String m_sValue;

    private CodeType(String key, String value) {
        m_sKey = key;
        m_sValue = value;
    }

    @Override
    public Object getKey() {
        return m_sKey;
    }

    public String getValue() {
        return m_sValue;
    }
    @Override
    public String toString() {
        return m_sValue;
    }
}
