package com.company.Manager;

import com.company.Model.Cart;
import com.company.Model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CartManagerImpl implements CartManager {
    HashMap<Integer, Cart> carts;
    ProductManager productManager = ProductManagerImpl.getInstance();

    public CartManagerImpl() {
        this.carts = new HashMap<Integer, Cart>();
    }

    public void addCart(int productId, int units) {
        if (productManager.getProductById(productId) != null) {
            carts.put(productId, new Cart(productId, units));
            System.out.println("Product added successfully in cart.");
        }
        System.out.println("Product Id not valid.");
    }

    public void showCart() {
        System.out.println("Product Id       Number of Units.");
        for (Cart cart : carts.values()) {
            System.out.println(cart.getProductId() + " " + cart.getNumberOfPurchase());
        }
    }

    public int checkOut() {
        int totalPayable = 0;
        for (Cart cart : carts.values()) {
            totalPayable += cart.getNumberOfPurchase() * productManager.getProductById(cart.getProductId()).getPrice();
        }
        System.out.println("Total Payable:" + totalPayable);
        carts = new HashMap<Integer, Cart>();
        return totalPayable;
    }

    public void removeCart(int productId) {
        carts.remove(productId);
        System.out.println(productId + " sucessfully removed from cart.");
    }

    public void updateCart(int productId, int units) {
        if (carts.containsKey(productId)) {
            Cart cart = carts.get(productId);
            cart.setNumberOfPurchase(units);
            System.out.println(productId + " sucessfully updated in cart.");
        } else {
            System.out.println(productId + " Not Present.");
        }
    }
}
