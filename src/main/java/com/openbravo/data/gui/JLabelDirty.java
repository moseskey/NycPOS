package com.openbravo.data.gui;

import com.openbravo.data.user.DirtyListener;
import com.openbravo.data.user.DirtyManager;
import javax.swing.*;

public class JLabelDirty extends JLabel {

    private static Icon m_IconModif = null;
    private static Icon m_IconNull = null;

    /**
     * Creates a new instance of JDirtyPicture
     */
    public JLabelDirty(DirtyManager dm) {

        if (m_IconModif == null) {
            m_IconModif = new ImageIcon(getClass().getResource("/images/edit.png"));
        }
        if (m_IconNull == null) {
            m_IconNull = new NullIcon(16, 16);
        }

        dm.addDirtyListener(new DirtyListener() {
            public void changedDirty(boolean bDirty) {
                setIcon(bDirty ? m_IconModif : m_IconNull);
            }
        });
    }
}
