package com.aven.orderhandler.model;

public class Order {

    private final String name;

    private final EOrderType orderType;

    private final Item item;

    private int itemCount;

    private final double itemCost;

    public Order(final EOrderType orderType,
                 final Item item, final int itemCount,
                 final double itemCost) {
        this.orderType = orderType;
        this.item = item;
        this.itemCount = itemCount;
        this.itemCost = itemCost;
        this.name = orderType.toString() + " " + item.getName() + " " + itemCount;
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

}
