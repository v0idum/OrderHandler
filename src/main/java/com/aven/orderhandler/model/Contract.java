package com.aven.orderhandler.model;

import java.io.Serializable;

public class Contract implements Serializable {

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

    @Override
    public String toString() {
        return order + ", Participants: " + participants[0].getName() + ", "
                + participants[1].getName() + "\n" + ", totalAmount: " + totalAmount;
    }

}
