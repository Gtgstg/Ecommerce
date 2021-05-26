package com.company;

import com.company.Manager.ProductManager;
import com.company.Manager.ProductManagerImpl;
import com.company.Manager.UserManager;
import com.company.Manager.UserManagerImpl;

import java.text.ParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int id;
        int userId;
        int productId;
        int units;
        int price;
        String name;
        String address;
        String password;
        String dob;
        String input;
        String description;
        String userDetails[];
        String productDetails[];
        String cartDetails[];
        UserManager userManager = UserManagerImpl.getInstance();
        ProductManager productManager = ProductManagerImpl.getInstance();
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        while (!input.equals("exit")) {
            try {
                switch (input) {
                    //Add User
                    case "1":
                        System.out.println("Please enter: Name Adress Password DOB(dd/MM/YYYY)");
                        input = scanner.nextLine();
                        userDetails = input.split(" ");
                        name = userDetails[0];
                        address = userDetails[1];
                        for (int i = 2; i < userDetails.length - 2; i++) address += " " + userDetails[i];
                        password = userDetails[userDetails.length - 2];
                        dob = userDetails[userDetails.length - 1];
                        userManager.signUp(name, address, password, dob);
                        input = scanner.nextLine();
                        break;
                    //login
                    case "2":
                        System.out.println("Please enter: userid Password");
                        input = scanner.nextLine();
                        userDetails = input.split(" ");
                        id = 0;
                        try {
                            id = Integer.parseInt(userDetails[0]);
                        } catch (NumberFormatException e) {
                            System.out.println("Id must be Integer.");
                            break;
                        }
                        password = userDetails[1];
                        userManager.logIn(id, password);
                        input = scanner.nextLine();
                        break;
                    //logout
                    case "3":
                        System.out.println("Please enter: userid");
                        input = scanner.nextLine();
                        try {
                            id = Integer.parseInt(input);
                        } catch (NumberFormatException e) {
                            System.out.println("Id must be Integer.");
                            break;
                        }
                        userManager.logout(id);
                        input = scanner.nextLine();
                        break;
                    //browseProduct
                    case "4":
                        System.out.println("Please enter: userid");
                        input = scanner.nextLine();
                        try {
                            id = Integer.parseInt(input);
                        } catch (NumberFormatException e) {
                            System.out.println("Id must be Integer.");
                            break;
                        }
                        userManager.browseProducts(id);
                        input = scanner.nextLine();
                        break;
                    //addTocart
                    case "5":
                        System.out.println("Please enter: userid productId units");
                        input = scanner.nextLine();
                        userDetails = input.split(" ");
                        userId = 0;
                        productId = 0;
                        units = 0;
                        try {
                            userId = Integer.parseInt(userDetails[0]);
                            productId = Integer.parseInt(userDetails[1]);
                            units = Integer.parseInt(userDetails[2]);
                        } catch (NumberFormatException e) {
                            System.out.println("Ids/unit must be Integer.");
                            break;
                        }
                        userManager.addProductToCart(userId, productId, units);
                        input = scanner.nextLine();
                        break;
                    //checkout
                    case "6":
                        System.out.println("Please enter: userid");
                        input = scanner.nextLine();
                        try {
                            id = Integer.parseInt(input);
                        } catch (NumberFormatException e) {
                            System.out.println("Id must be Integer.");
                            break;
                        }
                        userManager.checkOut(id);
                        input = scanner.nextLine();
                        break;
                    //Add product
                    case "7":
                        System.out.println("Please enter: Name Description Price");
                        input = scanner.nextLine();
                        productDetails = input.split(" ");
                        name = productDetails[0];
                        description = productDetails[1];
                        for (int i = 2; i < productDetails.length - 1; i++) description += " " + productDetails[i];
                        price = Integer.parseInt(productDetails[productDetails.length - 1]);
                        productManager.addProduct(name, description, price);
                        input = scanner.nextLine();
                        break;
                    //Delete Product By ID
                    case "8":
                        System.out.println("Please enter: productId");
                        input = scanner.nextLine();
                        try {
                            id = Integer.parseInt(input);
                        } catch (NumberFormatException e) {
                            System.out.println("Id must be Integer.");
                            break;
                        }
                        productManager.removeProductById(id);
                        input = scanner.nextLine();
                        break;
                    //Update product by id
                    case "9":
                        System.out.println("Please enter: ProductID Name Description Price");
                        input = scanner.nextLine();
                        productDetails = input.split(" ");
                        try {
                            id = Integer.parseInt(productDetails[0]);
                        } catch (NumberFormatException e) {
                            System.out.println("Id must be Integer.");
                            break;
                        }
                        name = productDetails[1];
                        description = productDetails[2];
                        for (int i = 3; i < productDetails.length - 1; i++) description += " " + productDetails[i];
                        price = Integer.parseInt(productDetails[productDetails.length - 1]);
                        productManager.updateProductById(id, name, description, price);
                        input = scanner.nextLine();
                        break;
                    //udpate user by id
                    case "10":
                        System.out.println("Please enter: userid Name Address Password DOB(dd/MM/YYYY)");
                        input = scanner.nextLine();
                        userDetails = input.split(" ");
                        try {
                            id = Integer.parseInt(userDetails[0]);
                        } catch (NumberFormatException e) {
                            System.out.println("Id must be Integer.");
                            break;
                        }
                        name = userDetails[1];
                        address = userDetails[2];
                        for (int i = 3; i < userDetails.length - 2; i++) address += " " + userDetails[i];
                        password = userDetails[userDetails.length - 2];
                        dob = userDetails[userDetails.length - 1];
                        userManager.updateUserById(id, name, address, password, dob);
                        input = scanner.nextLine();
                        break;
                    // remove user.by id
                    case "11":
                        System.out.println("Please enter: userid");
                        input = scanner.nextLine();
                        try {
                            id = Integer.parseInt(input);
                        } catch (NumberFormatException e) {
                            System.out.println("Id must be Integer.");
                            break;
                        }
                        userManager.removeUserById(id);
                        input = scanner.nextLine();
                        break;
                    //update product from cart
                    case "12":
                        System.out.println("Please enter: userid productId units");
                        input = scanner.nextLine();
                        cartDetails = input.split(" ");
                        try {
                            userId = Integer.parseInt(cartDetails[0]);
                            productId = Integer.parseInt(cartDetails[1]);
                            units = Integer.parseInt(cartDetails[2]);
                        } catch (NumberFormatException e) {
                            System.out.println("Id/unit must be Integer.");
                            break;
                        }
                        userManager.updateProductInCartByUserId(userId, productId, units);
                        input = scanner.nextLine();
                        break;
                    //remove from cart
                    case "13":
                        System.out.println("Please enter: userid productId");
                        input = scanner.nextLine();
                        cartDetails = input.split(" ");
                        try {
                            userId = Integer.parseInt(cartDetails[0]);
                            productId = Integer.parseInt(cartDetails[1]);
                        } catch (NumberFormatException e) {
                            System.out.println("Id/unit must be Integer.");
                            break;
                        }
                        userManager.removeProductFromCartByUserId(userId, productId);
                        input = scanner.nextLine();
                        break;
                    default:
                        System.out.println("Please use valid inputs");
                        input = scanner.nextLine();
                }
            } catch (Exception e) {
                System.out.println("Invalid Input");
                input = scanner.nextLine();
            }
        }
    }
}