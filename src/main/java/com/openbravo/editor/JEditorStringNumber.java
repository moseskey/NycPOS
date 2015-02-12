package com.openbravo.editor;

public class JEditorStringNumber extends JEditorText {

    public JEditorStringNumber() {
        super();
    }

    protected int getMode() {
        return EditorKeys.MODE_INTEGER_POSITIVE;
    }

    protected int getStartMode() {
        return MODE_123;
    }
}
