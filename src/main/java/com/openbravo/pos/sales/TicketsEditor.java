package com.openbravo.pos.sales;

import com.openbravo.pos.ticket.TicketInfo;

public interface TicketsEditor {

    public void setActiveTicket(TicketInfo oTicket, Object oTicketExt); // el ticket mas informacion extra...

    public TicketInfo getActiveTicket();
}
