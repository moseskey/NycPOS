package com.openbravo.data.user;

import com.openbravo.basic.BasicException;

public class EditorCreatorComposed implements EditorCreator{

    private EditorCreator[] m_editors;

    /**
     * Creates a new instance of EditorCreatorComposed
     * @param editors */
    public EditorCreatorComposed(EditorCreator... editors) {
        m_editors = editors;
    }

    /**
     *
     * @throws BasicException
     */
    public Object createValue() throws BasicException {

        Object[] value = new Object[m_editors.length];
        for (int i = 0; i < m_editors.length; i++) {
            value[i] = m_editors[i].createValue();
        }

        return value;
    }
}
