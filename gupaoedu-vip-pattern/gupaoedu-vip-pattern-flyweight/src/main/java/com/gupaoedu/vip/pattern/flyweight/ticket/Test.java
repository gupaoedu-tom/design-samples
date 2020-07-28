package com.gupaoedu.vip.pattern.flyweight.ticket;

/**
 * Created by Tom.
 */
public class Test {

    public static void main(String[] args) {
        ITicket ticket = TicketFacotry.queryTicket("北京西","长沙");
        ticket.showInfo("硬座");
        ticket = TicketFacotry.queryTicket("北京西","长沙");
        ticket.showInfo("软座");
        ticket = TicketFacotry.queryTicket("北京西","长沙南");
        ticket.showInfo("硬卧");
    }
}
