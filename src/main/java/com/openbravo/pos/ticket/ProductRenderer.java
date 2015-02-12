package com.openbravo.pos.ticket;

import com.openbravo.format.Formats;
import com.openbravo.pos.util.ThumbNailBuilder;
import java.awt.*;
import javax.swing.*;
import com.openbravo.pos.forms.AppLocal;

public class ProductRenderer extends DefaultListCellRenderer {

    ThumbNailBuilder tnbprod;

    public ProductRenderer() {
        tnbprod = new ThumbNailBuilder(48,48, "/images/package.png");
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, null, index, isSelected, cellHasFocus);

        ProductInfoExt prod = (ProductInfoExt) value;
        if (prod != null) {

// JG  June 2014 Added Stock Units
//            setText("<html>" + prod.getReference() + " - " + prod.getName() + "<br>&nbsp;&nbsp;&nbsp;&nbsp;" + Formats.CURRENCY.formatValue(prod.getPriceSell()));
            setText("<html>" + prod.getReference() + " - " + prod.getName() + "<br> " +
                    "<b>" + AppLocal.getIntString("label.stockunits") +    ":</b> " + Formats.DOUBLE.formatValue(prod.getStockUnits()) + "<br /> " +
                    "<b>" + AppLocal.getIntString("label.prodpricesell") + ":</b> " +
                    Formats.CURRENCY.formatValue(prod.getPriceSell()));
            Image img = tnbprod.getThumbNail(prod.getImage());
            setIcon(img == null ? null :new ImageIcon(img));
        }

        return this;
    }
}
