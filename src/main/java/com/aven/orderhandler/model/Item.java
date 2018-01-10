package com.aven.orderhandler.model;

public class Item {

    private final String name;

    private final double cost;

    public Item(final String name, final double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

}
