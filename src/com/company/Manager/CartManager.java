package com.company.Manager;

import com.company.Model.Cart;

import java.util.ArrayList;
import java.util.List;

public interface CartManager {
    public int checkOut();

    public void showCart();

    public void addCart(int productId, int units);

    public void removeCart(int productId);

    public void updateCart(int productId, int units);
}
