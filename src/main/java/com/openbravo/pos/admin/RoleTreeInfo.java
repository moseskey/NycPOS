package com.openbravo.pos.admin;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.DataRead;
import com.openbravo.data.loader.IKeyed;
import com.openbravo.data.loader.SerializableRead;

public class RoleTreeInfo implements SerializableRead, IKeyed {

    private static final long serialVersionUID = 9110127845969L;
    private String m_parentNode;
    private String m_treeNode;
    private String m_class;
    private String m_description;

    public RoleTreeInfo() {
        m_parentNode = null;
        m_treeNode = null;
        m_class = null;
        m_description = null;
    }

    /**
     *
     * @throws BasicException
     */
    @Override
    public void readValues(DataRead dr) throws BasicException {
        m_parentNode = dr.getString(1);
        m_treeNode = dr.getString(2);
        m_class = dr.getString(3);
        m_description = dr.getString(4);
    }

    public String getParent() {
        return m_parentNode;
    }

    public String getNode() {
        return m_treeNode;
    }

    public String getRoleClass() {
        return m_class;
    }

    public String getDescription() {
           return m_description;
    }

    @Override
    public Object getKey() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
