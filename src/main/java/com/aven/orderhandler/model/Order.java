package com.aven.orderhandler.model;

import java.io.Serializable;

public class Order implements Serializable {

    private final String name;

    private final EOrderType orderType;

    private final Client owner;

    private final Item item;

    private int itemCount;

    private final double itemCost;

    private boolean executed;

    public Order(final EOrderType orderType,
                 final Client owner,
                 final Item item,
                 final int itemCount,
                 final double itemCost) {
        this.orderType = orderType;
        this.owner = owner;
        this.item = item;
        this.itemCount = itemCount;
        this.itemCost = itemCost;
        this.name = orderType.toString() + ", " + item.getName() + ", " + itemCount + ", " + itemCost;
    }

    public String getName() {
        return name;
    }

    public EOrderType getOrderType() {
        return orderType;
    }

    public Item getItem() {
        return item;
    }

    public int getItemCount() {
        return itemCount;
    }

    public double getItemCost() {
        return itemCost;
    }

    public void setItemCount(final int itemCount) {
        this.itemCount = itemCount;
    }

    public Client getOwner() {
        return owner;
    }

    public boolean isExecuted() {
        return executed;
    }

    public void setExecuted(boolean executed) {
        this.executed = executed;
    }

    @Override
    public String toString() {
        return getName();
    }

}
