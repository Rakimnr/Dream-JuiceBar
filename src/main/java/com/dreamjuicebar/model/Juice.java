package com.dreamjuicebar.model;

import java.math.BigDecimal;

/** Menu catalog entity (product master). */
public class Juice {
    private final String id;
    private String name;
    private BigDecimal price;

    public Juice(String id, String name, BigDecimal price) {
        this.id = id;
        this.name = name.trim();
        this.price = price;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public BigDecimal getPrice() { return price; }

    public void setName(String name) { this.name = name.trim(); }
    public void setPrice(BigDecimal price) { this.price = price; }

    @Override
    public String toString() {
        return id + " - " + name + " (" + price + ")";
    }
}
