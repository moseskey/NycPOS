package com.openbravo.pos.printer.ticket;

import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class PrintItemLine implements PrintItem {

    protected Font font;

    protected int fontheight;

    protected int textsize;

    protected List<StyledText> m_atext;

    /**
     * Creates a new instance of PrinterItemLine
     * @param fontheight
     */
    public PrintItemLine(int textsize, Font font, int fontheight) {
        this.textsize = textsize;
        this.font = font;
        this.fontheight = fontheight;

// JG 16 May 12 use diamond inference
        m_atext = new ArrayList<>();
    }

    public void addText(int style, String text) {
        m_atext.add(new StyledText(style, text));
    }

    @Override
    public void draw(Graphics2D g, int x, int y, int width) {

        MyPrinterState ps = new MyPrinterState(textsize);
        int left = x;
        for (int i = 0; i < m_atext.size(); i++) {
            StyledText t = m_atext.get(i);
            g.setFont(ps.getFont(font, t.style));
            g.drawString(t.text, left, y);
            left += g.getFontMetrics().getStringBounds(t.text, g).getWidth();
        }
    }

    @Override
    public int getHeight() {
        return fontheight * MyPrinterState.getLineMult(textsize);
    }

    protected static class StyledText {

        public StyledText(int style, String text) {
            this.style = style;
            this.text = text;
        }

        public int style;

        public String text;
    }
}
