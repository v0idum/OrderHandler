package com.aven.orderhandler.model;

import java.io.Serializable;

public class Item implements Serializable {

    private final String name;

    public Item(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
