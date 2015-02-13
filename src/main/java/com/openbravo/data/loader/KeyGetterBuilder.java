package com.openbravo.data.loader;

/**
 *
 * Created on 27 de febrero de 2007, 22:09
 *
 */
public class KeyGetterBuilder implements IKeyGetter {

    public final static IKeyGetter INSTANCE = new KeyGetterBuilder();

    public KeyGetterBuilder() {
    }

    public Object getKey(Object value) {

        return (value == null)
               ? null
               : ((IKeyed) value).getKey();
    }
}
