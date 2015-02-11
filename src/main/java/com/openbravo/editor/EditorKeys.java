package com.openbravo.editor;

public interface EditorKeys {

    public final static int MODE_STRING = 0;

    public final static int MODE_DOUBLE = 1;

    public final static int MODE_DOUBLE_POSITIVE = 2;

    public final static int MODE_INTEGER = 3;

    public final static int MODE_INTEGER_POSITIVE = 4;

    public void setActive(EditorComponent e, int imode);

    public void setInactive(EditorComponent e);
}
