package com.aven.orderhandler.controller;

import com.aven.orderhandler.model.Client;
import com.aven.orderhandler.model.Contract;
import com.aven.orderhandler.model.Order;

import java.util.ArrayList;
import java.util.Objects;

public class OrderMatcherController {

    public Contract matchOrders(final ArrayList<Order> purchases, final ArrayList<Order> offers) {
        for (Order purchase : purchases) {
            for (Order offer : offers) {
                if (matches(purchase, offer)) {
                    final Contract contract = new Contract(new Client[]{purchase.getOwner(), offer.getOwner()}, purchase);
                    purchases.remove(purchase);
                    offers.remove(offer);
                    return contract;
                }
            }
        }
        return null;
    }

    private boolean matches(final Order purchase, final Order offer) {
        if (!Objects.equals(purchase.getItem().getName().toLowerCase(), offer.getItem().getName().toLowerCase())) {
            return false;
        }
        if (purchase.getItemCount() > offer.getItemCount()) {
            return false;
        }
        if (purchase.getItemCost() < offer.getItemCost()) {
            return false;
        }
        if (purchase.getOwner() == offer.getOwner()) {
            return false;
        }
        return true;
    }

}
