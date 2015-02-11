package com.openbravo.pos.printer.printer;

import com.openbravo.pos.printer.ticket.BasicTicket;
import com.openbravo.pos.printer.ticket.PrintItem;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

public class PrintableBasicTicket implements Printable {

    private int imageable_width;
    private int imageable_height;
    private int imageable_x;
    private int imageable_y;

    private BasicTicket ticket;

    public PrintableBasicTicket(BasicTicket ticket, int imageable_x, int imageable_y, int imageable_width, int imageable_height) {
        this.ticket = ticket;
        this.imageable_x = imageable_x;
        this.imageable_y = imageable_y;
        this.imageable_width = imageable_width;
        this.imageable_height = imageable_height;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {

        Graphics2D g2d = (Graphics2D) graphics;

        int line = 0;
        int currentpage = 0;
        int currentpagey = 0;
        boolean printed = false;

//        System.out.println(pageFormat.getImageableX());
//        System.out.println(pageFormat.getImageableY());
//        System.out.println(pageFormat.getImageableWidth());
//        System.out.println(pageFormat.getImageableHeight());

        g2d.translate(imageable_x, imageable_y);

        java.util.List<PrintItem> commands = ticket.getCommands();

        while (line < commands.size()) {

            int itemheight = commands.get(line).getHeight();

            if (currentpagey + itemheight <= imageable_height) {
                currentpagey += itemheight;
            } else {
                currentpage ++;
                currentpagey = itemheight;
            }

            if (currentpage < pageIndex) {
                line ++;
            } else if (currentpage == pageIndex) {
                printed = true;
                commands.get(line).draw(g2d, 0, currentpagey - itemheight, imageable_width);

                line ++;
            } else if (currentpage > pageIndex) {
                line ++;
            }
        }

        return printed
            ? Printable.PAGE_EXISTS
            : Printable.NO_SUCH_PAGE;
    }
}
