package com.Cesar_Market.domain;

public class PurchaseItem {
    private int productId;
    private int quantity;
    private double total;
    private boolean state;

    public int getProductId() {
        return productId;
    }

    public void setProductID(int productID) {
        this.productId = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
