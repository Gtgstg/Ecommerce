package com.company.Manager;

import com.company.Model.Product;

import java.util.HashMap;

public class ProductManagerImpl implements ProductManager {
    private static ProductManager productManager;
    private HashMap<Integer, Product> products;
    private int totalProduct;

    public static ProductManager getInstance() {
        if (productManager == null) {
            productManager = new ProductManagerImpl();
        }
        return productManager;
    }

    public ProductManagerImpl() {
        this.products = new HashMap<Integer, Product>();
        this.totalProduct = 0;
    }

    public void addProduct(String name, String description, int price) {
        if (!checkProductExists(name, description, price)) {
            Product currentProduct = new Product(++this.totalProduct, name, description, price);
            products.put(totalProduct, currentProduct);
            System.out.println("Product added successully");
        } else {
            System.out.println("Already Exists");
        }
    }

    public Product getProductById(int productId) {
        if (products.containsKey(productId)) {
            System.out.println("Product Id      Name       Descpiption       Price");
            Product product = products.get(productId);
            System.out.println(product.getProductId() + "       " + product.getName() + "       " + product.getDescription() + "       " + product.getPrice());
            return product;
        }
//        System.out.println("There is no product " + productId);
        return null;
    }

    public void removeProductById(int productId) {
        if (products.containsKey(productId)) {
            products.remove(productId);
            System.out.println(productId + " removed successfully.");
        } else {
            System.out.println("Product is not available.");
        }
    }

    public void updateProductById(int productId, String name, String description, int price) {
        if (products.containsKey(productId)) {
            Product product = products.get(productId);
            product.setDescription(description);
            product.setPrice(price);
            product.setName(name);
            System.out.println(productId + " updated successfully.");
        } else {
            System.out.println("Product is not available.");
        }
    }

    public void showProducts() {
        System.out.println("Product Id       Name       Description       Price");
        for (Product product : products.values()) {
            System.out.println(product.getProductId() + "       " + product.getName() + "       " + product.getDescription() + "       " + product.getPrice());
        }
    }

    public boolean checkProductExists(String name, String description, int price) {
        Product currentProduct = new Product(0, name, description, price);
        for (Product product : products.values()) {
            if (product.equals(currentProduct)) {
                return true;
            }
        }
        return false;
    }
}
