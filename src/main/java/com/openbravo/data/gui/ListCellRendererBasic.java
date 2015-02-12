package com.openbravo.data.gui;

import com.openbravo.data.loader.IRenderString;
import java.awt.*;
import javax.swing.*;

public class ListCellRendererBasic extends DefaultListCellRenderer {

    private IRenderString m_renderer;

    public ListCellRendererBasic(IRenderString renderer) {
        m_renderer = renderer;
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, null, index, isSelected, cellHasFocus);

        String s = m_renderer.getRenderString(value);
        setText((s == null || s.equals("")) ? " " : s); // Un espacio en caso de nulo para que no deja la celda chiquitita.
        return this;
    }

}
