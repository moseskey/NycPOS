package com.openbravo.editor;

import com.openbravo.format.Formats;

public class JEditorIntegerPositive extends JEditorNumber {

    /**
     * Creates a new instance of JEditorIntegerPositive
     */
    public JEditorIntegerPositive() {
    }

    protected Formats getFormat() {
        return Formats.INT;
    }

    protected int getMode() {
        return EditorKeys.MODE_INTEGER_POSITIVE;
    }
}
