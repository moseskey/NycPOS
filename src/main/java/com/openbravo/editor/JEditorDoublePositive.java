package com.openbravo.editor;

import com.openbravo.format.Formats;

public class JEditorDoublePositive extends JEditorNumber {

    /**
     * Creates a new instance of JEditorDoublePositive */
    public JEditorDoublePositive() {
    }

    protected Formats getFormat() {
        return Formats.DOUBLE;
    }

    protected int getMode() {
        return EditorKeys.MODE_DOUBLE_POSITIVE;
    }
}
