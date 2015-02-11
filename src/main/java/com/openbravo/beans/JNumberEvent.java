package com.openbravo.beans;

import java.util.EventObject;

/**
 *
 * @version
 */
public class JNumberEvent extends EventObject {

    private char m_cKey;

    public JNumberEvent(Object source, char cKey) {
        super(source);
        m_cKey = cKey;
    }

    public char getKey() {
        return m_cKey;
    }

}
