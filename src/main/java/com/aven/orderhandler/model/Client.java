package com.aven.orderhandler.model;

import java.util.ArrayList;

public class Client {

    private final String name;

    private final ArrayList<Order> orders;

    public Client(final String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void sendOrder(final EOrderType orderType, final Item item,
                          final int itemCount, final double itemCost) {
        //TODO
    }

    public String getName() {
        return name;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

}
