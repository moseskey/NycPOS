package com.openbravo.data.loader;

public class KeyGetterFirst implements IKeyGetter {

    private int [] m_aElems;

    public KeyGetterFirst(int[] aElems) {
        m_aElems = aElems;
    }

    public Object getKey(Object value) {
        if (value == null) {
            return null;
        } else {
            Object[] avalue = (Object []) value;
            return avalue[m_aElems[0]];
        }
    }
}
