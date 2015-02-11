package com.openbravo.format;

import java.text.ParseException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class FormatsRESOURCE extends Formats {

    private ResourceBundle m_rb;
    private String m_sPrefix;

    /**
     * Creates a new instance of FormatsRESOURCE
     */
    public FormatsRESOURCE(ResourceBundle rb, String sPrefix) {
        m_rb = rb;
        m_sPrefix = sPrefix;
    }

    @Override
    protected String formatValueInt(Object value) {
        try {
            return m_rb.getString(m_sPrefix + (String) value);
        } catch (MissingResourceException e) {
            return (String) value;
        }
    }

    /**
     *
     * @throws ParseException
     */
    @Override
    protected Object parseValueInt(String value) throws ParseException {
        return value;
    }

    @Override
    public int getAlignment() {
        return javax.swing.SwingConstants.LEFT;
    }
}
