package com.openbravo.format;

import java.text.ParseException;

public class FormatsValidate extends Formats {

    private Formats m_fmt;
    private FormatsConstrain[] m_aConstrains;

    public FormatsValidate(Formats fmt, FormatsConstrain[] constrains) {
        m_fmt = fmt;
        m_aConstrains = constrains;
    }
    public FormatsValidate(Formats fmt) {
        this(fmt, new FormatsConstrain[0]);
    }
    public FormatsValidate(Formats fmt, FormatsConstrain constrain) {
        this(fmt, new FormatsConstrain[] {constrain});
    }

    @Override
    protected String formatValueInt(Object value) {
        return m_fmt.formatValueInt(value);
    }

    @Override
    protected Object parseValueInt(String value) throws ParseException {
        // Primero obtenemos el valor
        Object val = m_fmt.parseValueInt(value);
        for (int i = 0; i < m_aConstrains.length; i++) {
            val = m_aConstrains[i].check(val);
        }

        return val;
    }

    @Override
    public int getAlignment() {
        return m_fmt.getAlignment();
    }
}
