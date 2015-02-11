package com.openbravo.pos.forms;

import java.awt.Color;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

public class MenuTitleDefinition implements MenuElement {

    public String KeyText;

    @Override
    public void addComponent(JPanelMenu menu) {

//        if (p.x > 20) {
//            p.x = 20;
//            p.y += 55;
//        }
//        p.y += 20; // 20 puntitos extra de separacion.

        JLabel lbl = new JLabel(AppLocal.getIntString(KeyText));
        lbl.applyComponentOrientation(menu.getComponentOrientation());
        lbl.setBorder(new MatteBorder(new Insets(0, 0, 1, 0), new Color(0, 0, 0)));
//        lbl.setSize(670, 20);
//        lbl.setLocation(p);
//        p.y += 35;
//        comp.add(lbl);

        menu.addTitle(lbl);
    }
}
