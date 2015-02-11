package com.openbravo.pos.forms;

import java.awt.Dimension;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class MenuItemDefinition implements MenuElement {

    private Action act;

    public MenuItemDefinition(Action act) {
        this.act = act;
    }

    @Override
    public void addComponent(JPanelMenu menu) {

        JButton btn = new JButton(act);

        btn.setFocusPainted(false);
        btn.setFocusable(false);
        btn.setRequestFocusEnabled(false);
        btn.setHorizontalAlignment(SwingConstants.LEADING);
        btn.setPreferredSize(new Dimension(150, 40));

//        btn.setSize(220, 50);
//        btn.setLocation(p);
//        if (p.x >= 470) {
//            p.x = 20;
//            p.y += 55;
//        } else {
//            p.x += 225;
//        }
//        comp.add(btn);

        menu.addEntry(btn);
    }
}
