package com.openbravo.pos.inventory;

import com.openbravo.format.Formats;
import com.openbravo.pos.util.StringUtils;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class InventoryRecord {

    private final Date m_dDate;
    private final MovementReason m_reason;
    private final LocationInfo m_locationOri;
    private final List<InventoryLine> m_invlines;
    private final String user;

    /**
     * Creates a new instance of InventoryRecord
     */
    public InventoryRecord(Date d, MovementReason reason, LocationInfo location, String currentUser, List<InventoryLine> invlines) {
        m_dDate = d;
        m_reason = reason;
        m_locationOri = location;
        m_invlines = invlines;
        user = currentUser;

    }

    public Date getDate() {
        return m_dDate;
    }

    public String getUser() {
        return user;
    }

    public MovementReason getReason() {
        return m_reason;
    }

    public LocationInfo getLocation() {
        return m_locationOri;
    }

    public List<InventoryLine> getLines() {
        return m_invlines;
    }

    public boolean isInput() {
        return m_reason.isInput();
    }

    public double getSubTotal() {
        double dSuma = 0.0;
        InventoryLine oLine;
        for (Iterator<InventoryLine> i = m_invlines.iterator(); i.hasNext();) {
            oLine = i.next();
            dSuma += oLine.getSubValue();
        }
        return dSuma;
    }

    public String printDate() {
        return Formats.TIMESTAMP.formatValue(m_dDate);
    }

    public String printLocation() {
//        return m_locationOri.toString();
        return StringUtils.encodeXML(m_locationOri.toString());
    }

    public String printReason() {
//        return m_reason.toString();
        return StringUtils.encodeXML(m_reason.toString());
    }

    public String printSubTotal() {
        return Formats.CURRENCY.formatValue(getSubTotal());
    }
}
