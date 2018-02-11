package com.aven.orderhandler.controller;

import com.aven.orderhandler.model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrderMatcherControllerTest {

    @Test
    void matchOrdersWhenOrdersAreEquivalent() {
        final Order purchase = new Order(EOrderType.PURCHASE, new Client("Client"), new Item("Item"), 1, 500);
        final Order offer = new Order(EOrderType.OFFER, new Client("Client"), new Item("Item"), 1, 500);

        final ArrayList<Order> purchases = new ArrayList<>();
        final ArrayList<Order> offers = new ArrayList<>();

        purchases.add(purchase);
        offers.add(offer);

        final OrderMatcherController matcherController = new OrderMatcherController();

        final Contract contract = matcherController.matchOrders(purchases, offers);
        assertNotNull(contract);
    }

    @Test
    void matchOrdersWhenPurchaseCostMoreThanOffers() {
        final Order offer = new Order(EOrderType.OFFER, new Client("Client"), new Item("Item"), 1, 500);
        final Order purchase = new Order(EOrderType.PURCHASE, new Client("Client"), new Item("Item"), 1, 501);

        final ArrayList<Order> purchases = new ArrayList<>();
        final ArrayList<Order> offers = new ArrayList<>();

        purchases.add(purchase);
        offers.add(offer);

        final OrderMatcherController matcherController = new OrderMatcherController();

        final Contract contract = matcherController.matchOrders(purchases, offers);
        assertNotNull(contract);
    }

    @Test
    void matchOrdersWhenPurchaseCostLessThanOffers() {
        final Order offer = new Order(EOrderType.OFFER, new Client("Client"), new Item("Item"), 1, 501);
        final Order purchase = new Order(EOrderType.PURCHASE, new Client("Client"), new Item("Item"), 1, 500);

        final ArrayList<Order> purchases = new ArrayList<>();
        final ArrayList<Order> offers = new ArrayList<>();

        purchases.add(purchase);
        offers.add(offer);

        final OrderMatcherController matcherController = new OrderMatcherController();

        final Contract contract = matcherController.matchOrders(purchases, offers);
        assertNull(contract);
    }

    @Test
    void matchOrdersWhenPurchaseItemCountLessThanOffers() {
        final Order offer = new Order(EOrderType.OFFER, new Client("Client"), new Item("Item"), 2, 500);
        final Order purchase = new Order(EOrderType.PURCHASE, new Client("Client"), new Item("Item"), 1, 500);

        final ArrayList<Order> purchases = new ArrayList<>();
        final ArrayList<Order> offers = new ArrayList<>();

        purchases.add(purchase);
        offers.add(offer);

        final OrderMatcherController matcherController = new OrderMatcherController();

        final Contract contract = matcherController.matchOrders(purchases, offers);
        assertNotNull(contract);
    }

    @Test
    void matchOrdersWhenPurchaseItemCountMoreThanOffers() {
        final Order offer = new Order(EOrderType.OFFER, new Client("Client"), new Item("Item"), 1, 500);
        final Order purchase = new Order(EOrderType.PURCHASE, new Client("Client"), new Item("Item"), 2, 500);

        final ArrayList<Order> purchases = new ArrayList<>();
        final ArrayList<Order> offers = new ArrayList<>();

        purchases.add(purchase);
        offers.add(offer);

        final OrderMatcherController matcherController = new OrderMatcherController();

        final Contract contract = matcherController.matchOrders(purchases, offers);
        assertNull(contract);
    }

    @Test
    void matchOrdersWhenPurchaseAndOfferOwnerAreTheSame() {
        final Client owner = new Client("Owner");
        final Order offer = new Order(EOrderType.OFFER, owner, new Item("Item"), 1, 500);
        final Order purchase = new Order(EOrderType.PURCHASE, owner, new Item("Item"), 2, 500);

        final ArrayList<Order> purchases = new ArrayList<>();
        final ArrayList<Order> offers = new ArrayList<>();

        purchases.add(purchase);
        offers.add(offer);

        final OrderMatcherController matcherController = new OrderMatcherController();

        final Contract contract = matcherController.matchOrders(purchases, offers);
        assertNull(contract);
    }

    @Test
    void matchOrdersWhenPurchaseAndOfferOwnerAreNotTheSame() {
        final Client owner1 = new Client("Owner1");
        final Client owner2 = new Client("Owner2");
        final Order offer = new Order(EOrderType.OFFER, owner1, new Item("Item"), 1, 500);
        final Order purchase = new Order(EOrderType.PURCHASE, owner2, new Item("Item"), 1, 500);

        final ArrayList<Order> purchases = new ArrayList<>();
        final ArrayList<Order> offers = new ArrayList<>();

        purchases.add(purchase);
        offers.add(offer);

        final OrderMatcherController matcherController = new OrderMatcherController();

        final Contract contract = matcherController.matchOrders(purchases, offers);
        assertNotNull(contract);
    }



}