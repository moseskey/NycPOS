package com.openbravo.pos.admin;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.DataRead;
import com.openbravo.data.loader.IKeyed;
import com.openbravo.data.loader.SerializableRead;

/**
 *
 * Created on 27 de febrero de 2007, 23:27
 *
 */
public class PeopleInfo implements SerializableRead, IKeyed {

    private static final long serialVersionUID = 9110127845966L;
    private String m_sID;

    protected String m_sName;

    public PeopleInfo() {
        m_sID = null;
        m_sName = null;
    }

    public Object getKey() {
        return m_sID;
    }

    public void readValues(DataRead dr) throws BasicException {
        m_sID = dr.getString(1);
        m_sName = dr.getString(2);
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

    public void setName(String sValue) {
        m_sName = sValue;
    }

    public String toString() {
        return m_sName;
    }
}
