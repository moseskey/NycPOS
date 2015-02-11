package com.openbravo.pos.sales.restaurant;

import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import com.openbravo.data.gui.NullIcon;
import com.openbravo.data.loader.DataRead;
import com.openbravo.data.loader.SerializableRead;
import com.openbravo.basic.BasicException;
import java.awt.Insets;

public class Place implements SerializableRead, java.io.Serializable {

    private static final long serialVersionUID = 8652254694281L;
    private static final Icon ICO_OCU = new ImageIcon(Place.class.getResource("/images/edit_group.png"));
    private static final Icon ICO_FRE = new NullIcon(22, 22);

    private String m_sId;
    private String m_sName;
    private int m_ix;
    private int m_iy;
    private String m_sfloor;
    private String m_customer;
    private String m_waiter;
    private String m_ticketId;
    private Boolean m_tableMoved;

    private boolean m_bPeople;
    private JButton m_btn;

    /**
     * Creates a new instance of TablePlace
     */
    public Place() {
    }

    /**
     *
     * @throws BasicException
     */
    @Override
    public void readValues(DataRead dr) throws BasicException {
        m_sId = dr.getString(1);
        m_sName = dr.getString(2);
        m_ix = dr.getInt(3).intValue();
        m_iy = dr.getInt(4).intValue();
        m_sfloor = dr.getString(5);
        m_customer = dr.getString(6);
        m_waiter = dr.getString(7);
        m_ticketId = dr.getString(8);
        m_tableMoved = dr.getBoolean(9);

        m_bPeople = false;
        m_btn = new JButton();

        m_btn.setFocusPainted(false);
        m_btn.setFocusable(false);
        m_btn.setRequestFocusEnabled(false);
        m_btn.setHorizontalTextPosition(SwingConstants.CENTER);
        m_btn.setVerticalTextPosition(SwingConstants.BOTTOM);
        m_btn.setIcon(ICO_FRE);
        m_btn.setText(m_sName);
        m_btn.setMargin(new Insets(2,5,2,5));

    }

    public String getId() { return m_sId; }

    public String getName() { return m_sName; }

    public int getX() { return m_ix; }

    public int getY() { return m_iy; }

    public String getFloor() { return m_sfloor; }

    public JButton getButton() { return m_btn; }

    public String getCustomer(){ return m_customer; }

    public String getWaiter(){ return m_waiter;}

    public boolean hasPeople() {
        return m_bPeople;
    }

    public void setPeople(boolean bValue) {
        m_bPeople = bValue;
        m_btn.setIcon(bValue ? ICO_OCU : ICO_FRE);
    }

    public void setButtonBounds() {
        Dimension d = m_btn.getPreferredSize();
        m_btn.setPreferredSize(new Dimension(d.width +30,d.height + 15));
        d = m_btn.getPreferredSize();
        m_btn.setBounds(m_ix - d.width / 2, m_iy - d.height / 2, d.width, d.height);
    }

    public void setButtonText(String btnText){
        m_btn.setText(btnText);
    }

}


