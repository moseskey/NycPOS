package com.openbravo.pos.printer.ticket;

import java.awt.Font;
import java.awt.geom.AffineTransform;

public class BasicTicketForScreen extends BasicTicket {

    private static Font BASEFONT = new Font("Monospaced", Font.PLAIN, 12).deriveFont(AffineTransform.getScaleInstance(1.0, 1.40));
// JG 14 June 2014 - reduce height/scale to get some screen space back
    private static int FONTHEIGHT = 16;
    private static double IMAGE_SCALE = .85;

//    private static int FONTHEIGHT = 20;
//    private static double IMAGE_SCALE = 1.0;

    @Override
    protected Font getBaseFont() {
        return BASEFONT;
    }

    @Override
    protected int getFontHeight() {
        return FONTHEIGHT;
    }

    @Override
    protected double getImageScale() {
        return IMAGE_SCALE;
    }
}
