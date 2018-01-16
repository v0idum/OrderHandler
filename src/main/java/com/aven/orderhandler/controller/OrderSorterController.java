package com.aven.orderhandler.controller;

import com.aven.orderhandler.model.EOrderType;
import com.aven.orderhandler.model.Order;

import java.util.ArrayList;

public class OrderSorterController {

    private final ArrayList<Order> purchaseOrders;

    private final ArrayList<Order> offerOrders;

    public OrderSorterController() {
        this.purchaseOrders = new ArrayList<>();
        this.offerOrders = new ArrayList<>();
    }

    public void sortOrder(final Order order) {
        if (order.getOrderType() == EOrderType.PURCHASE) {
            purchaseOrders.add(order);
        } else {
            offerOrders.add(order);
        }
    }

    public ArrayList<Order> getPurchaseOrders() {
        return purchaseOrders;
    }

    public ArrayList<Order> getOfferOrders() {
        return offerOrders;
    }

}
