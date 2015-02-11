package com.openbravo.data.user;

/**
 *
 * Created on 22 de marzo de 2007, 0:01
 *
 */
public class DocumentLoaderBasic implements DocumentLoader {

    public static final DocumentLoader INSTANCE = new DocumentLoaderBasic();

    /**
     * Creates a new instance of DocumentLoaderBasic
     */
    private DocumentLoaderBasic() {
    }

    public Object getValue(Object key) {
        return key;
    }

    public Object getKey(Object value) {
        return value;
    }
}
