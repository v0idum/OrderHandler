package com.aven.orderhandler.model;

public class Contract {

    private final Client[] participants;

    private final Order order;

    private final double totalAmount;

    public Contract(final Client[] participants, final Order order) {
        this.participants = participants;
        this.order = order;
        this.totalAmount = order.getItemCost() * order.getItemCount();
    }

    public Client[] getParticipants() {
        return participants;
    }

    public Order getOrder() {
        return order;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

}
