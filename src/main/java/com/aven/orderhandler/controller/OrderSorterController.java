package com.aven.orderhandler.controller;

import com.aven.orderhandler.model.EOrderType;
import com.aven.orderhandler.model.Order;

import java.util.ArrayList;

public class OrderSorterController {

    public void sortOrder(final Order order, final ArrayList<Order> purchases, final ArrayList<Order> offers) {
        if (order.getOrderType() == EOrderType.PURCHASE) {
            purchases.add(order);
        } else {
            offers.add(order);
        }
    }

}
