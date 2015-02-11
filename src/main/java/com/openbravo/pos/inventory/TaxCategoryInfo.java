package com.openbravo.pos.inventory;

import com.openbravo.data.loader.IKeyed;
import java.io.Serializable;

/**
 *
 * @version
 */
public class TaxCategoryInfo implements Serializable, IKeyed {

    private static final long serialVersionUID = 8959679342805L;
    private String m_sID;
    private String m_sName;

    public TaxCategoryInfo(String sID, String sName) {
        m_sID = sID;
        m_sName = sName;
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
    public String toString(){
        return m_sName;
    }
}
