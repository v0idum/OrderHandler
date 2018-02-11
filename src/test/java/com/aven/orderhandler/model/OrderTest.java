package com.aven.orderhandler.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void getOrderType() {
        final EOrderType type = EOrderType.PURCHASE;
        final Order order = new Order(type, new Client("Client"), new Item("Item"), 0, 0);

        final EOrderType actual = order.getOrderType();
        assertEquals(type, actual);
    }

    @Test
    void getItem() {
        final Item item = new Item("Item");
        final Order order = new Order(EOrderType.PURCHASE, new Client("Client"), item, 0, 0);

        final Item actual = order.getItem();
        assertEquals(item, actual);
    }

    @Test
    void getItemCount() {
        final int itemCount = 5;
        final Order order = new Order(EOrderType.PURCHASE, new Client("Client"), new Item("Item"), itemCount, 0);

        final int actualCount = order.getItemCount();
        assertEquals(itemCount, actualCount);
    }

    @Test
    void getItemCost() {
        final double itemCost = 100.0;
        final Order order = new Order(EOrderType.PURCHASE, new Client("Client"), new Item("Item"), 0, itemCost);

        final double actualCount = order.getItemCost();
        assertEquals(itemCost, actualCount);
    }

    @Test
    void getOwner() {
        final Client client = new Client("Client");
        final Order order = new Order(EOrderType.PURCHASE, client, new Item("Item"), 0, 0);

        final Client actual = order.getOwner();
        assertEquals(client, actual);
    }

}