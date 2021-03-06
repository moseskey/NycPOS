package com.openbravo.editor;

import com.openbravo.format.Formats;

public class JEditorCurrencyPositive extends JEditorNumber {

    public JEditorCurrencyPositive() {
    }

    @Override
    protected Formats getFormat() {
        return Formats.CURRENCY;

    }

    @Override
    protected int getMode() {
        return EditorKeys.MODE_DOUBLE_POSITIVE;
    }
}
