package com.openbravo.pos.epm;

import com.openbravo.data.loader.IKeyed;

public class BreaksInfo implements IKeyed {

    private static final long serialVersionUID = 8936482715929L;
    private String m_sID;
    private String m_sName;

    public BreaksInfo(String id, String name) {
        m_sID = id;
        m_sName = name;
    }

    @Override
    public Object getKey() {
        return m_sID;
    }

    public void setID(String sID) {
        m_sID = sID;
    }

    public String getID() {
        return m_sID;
    }

    public String getName() {
        return m_sName;
    }

    public void setName(String sName) {
        m_sName = sName;
    }

    @Override
    public String toString() {
        return m_sName;
    }
}
