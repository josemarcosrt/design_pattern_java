package com.example.hexagonalorder.domain;

public class Order {
    private final String id;
    private final String product;
    private final int quantity;

    public Order(String id, String product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public boolean isValid() {
        return quantity > 0;
    }

    public String getId() { return id; }
    public String getProduct() { return product; }
    public int getQuantity() { return quantity; }
}
