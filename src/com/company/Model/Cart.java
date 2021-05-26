package com.company.Model;

public class Cart {
    private int productId;
    private int numberOfPurchase;

    public Cart(int productId, int numberOfPurchase) {
        this.productId = productId;
        this.numberOfPurchase = numberOfPurchase;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getNumberOfPurchase() {
        return numberOfPurchase;
    }

    public void setNumberOfPurchase(int numberOfPurchase) {
        this.numberOfPurchase = numberOfPurchase;
    }
}
