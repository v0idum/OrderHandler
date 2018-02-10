package com.aven.orderhandler.controller;

import com.aven.orderhandler.model.EOrderType;
import com.aven.orderhandler.model.Item;
import com.aven.orderhandler.model.Order;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class OrderSorterControllerTest {

    @Test
    void testSortOrderWhenTypeIsPurchase() {
        OrderSorterController sorterController = new OrderSorterController();
        final Item item = new Item("Laptop");
        final Order purchase = new Order(EOrderType.PURCHASE, null, item, 0, 0);
        final ArrayList<Order> purchaseList = new ArrayList<>();
        final ArrayList<Order> offerList = new ArrayList<>();
        sorterController.sortOrder(purchase, purchaseList, offerList);

        assertEquals(false, purchaseList.isEmpty());
        assertEquals(true, offerList.isEmpty());
    }

    @Test
    void testSortOrderWhenTypeIsOffer() {
        OrderSorterController sorterController = new OrderSorterController();
        final Item item = new Item("Laptop");
        final Order purchase = new Order(EOrderType.OFFER, null, item, 0, 0);
        final ArrayList<Order> purchaseList = new ArrayList<>();
        final ArrayList<Order> offerList = new ArrayList<>();
        sorterController.sortOrder(purchase, purchaseList, offerList);

        assertEquals(true, purchaseList.isEmpty());
        assertEquals(false, offerList.isEmpty());
    }

}