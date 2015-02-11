package com.openbravo.pos.inventory;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.DataRead;
import com.openbravo.data.loader.IKeyed;
import com.openbravo.data.loader.SerializableRead;

/**
 *
 * Created on February 13, 2007, 10:13 AM
 *
 */
public class LocationInfo implements SerializableRead, IKeyed {

    private static final long serialVersionUID = 9032683595230L;
    private String m_sID;
    private String m_sName;
    private String m_sAddress;

    /**
     * Creates a new instance of LocationInfo
     */
    public LocationInfo() {
        m_sID = null;
        m_sName = null;
        m_sAddress = null;
    }

    public Object getKey() {
        return m_sID;
    }

    /**
     *
     * @throws BasicException
     */
    public void readValues(DataRead dr) throws BasicException {
        m_sID = dr.getString(1);
        m_sName = dr.getString(2);
        m_sAddress = dr.getString(3);
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

    public String getAddress() {
        return m_sAddress;
    }

    public void setAddress(String sAddress) {
        m_sAddress = sAddress;
    }

    public String toString(){
        return m_sName;
    }
}
