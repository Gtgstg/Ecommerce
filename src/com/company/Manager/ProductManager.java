package com.company.Manager;

import com.company.Model.Product;

import java.util.HashMap;

public interface ProductManager {
    public void showProducts();
    public void addProduct(String name, String description, int price);
    public Product getProductById(int productId);
    public void removeProductById(int productId);
    public  void updateProductById(int productId, String name, String description, int price);
}
