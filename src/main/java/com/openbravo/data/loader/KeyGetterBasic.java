package com.openbravo.data.loader;

public class KeyGetterBasic implements IKeyGetter {

    private int [] m_aElems;

    /**
     * Creates a new instance of KeyGetterBasic
     * @param aElems */
    public KeyGetterBasic(int[] aElems) {
        m_aElems = aElems;
    }

    public Object getKey(Object value) {
        if (value == null) {
            return null;
        } else {
            Object[] avalue = (Object []) value;
            Object[] akey = new Object[m_aElems.length];
            for (int i = 0; i < m_aElems.length; i++) {
                akey[i] = avalue[m_aElems[i]];
            }
            return akey;
        }
    }
}
