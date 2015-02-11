package com.openbravo.editor;

import com.openbravo.format.Formats;

public class JEditorDouble extends JEditorNumber {

    /**
     * Creates a new instance of JEditorDouble
     */
    public JEditorDouble() {
    }

    protected Formats getFormat() {
        return Formats.DOUBLE;
    }

    protected int getMode() {
        return EditorKeys.MODE_DOUBLE;
    }
}
