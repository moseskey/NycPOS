package com.openbravo.editor;

public class JEditorString extends JEditorText {

    public JEditorString() {
        super();
    }

    @Override
    protected final int getMode() {
        return EditorKeys.MODE_STRING;
    }

    @Override
    protected int getStartMode() {
        return MODE_Abc1;
    }

}

