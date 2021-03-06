package com.openbravo.pos.epm;

import com.openbravo.data.loader.IKeyed;

public class LeavesInfo implements IKeyed {

    private static final long serialVersionUID = 8936482715929L;
    private String m_sID;
    private String m_sName;
    private String m_sEmployeeID;
    private String m_sStartDate;
    private String m_sEndDate;
    private String m_sNotes;


    public LeavesInfo(String id, String name, String employeeid, String startdate, String enddate,
                      String notes) {
        m_sID = id;
        m_sName = name;
        m_sEmployeeID = employeeid;
        m_sStartDate = startdate;
        m_sEndDate = enddate;
        m_sNotes = notes;
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

    public String getEmployeeID() {
        return m_sEmployeeID;
    }

    public void setEmployeeID(String EmployeeID) {
        this.m_sEmployeeID = EmployeeID;
    }

    public String getStartDate() {
        return m_sStartDate;
    }

    public void setStartDate(String StartDate) {
        this.m_sStartDate = StartDate;
    }

    public String getEndDate() {
        return m_sEndDate;
    }

    public void setEndDate(String EndDate) {
        this.m_sEndDate = EndDate;
    }

    public String getNotes() {
        return m_sNotes;
    }

    public void setNotes(String Notes) {
        this.m_sNotes = Notes;
    }
}
