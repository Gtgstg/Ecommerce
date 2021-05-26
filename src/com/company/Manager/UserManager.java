package com.company.Manager;

import com.company.Model.Login;
import com.company.Model.User;

import java.text.ParseException;

public interface UserManager {
    public void signUp(String name, String address, String password, String dob);

    public void logIn(int userId, String password);

    public void logout(int userId);

    public void browseProducts(int userId);

    public void addProductToCart(int userId, int productId, int numberOfUnits);

    public void checkOut(int userId);

    public User getUserById(int userId);

    public void updateUserById(int userId, String name, String address, String password, String dob);

    public void removeUserById(int userId);

    public void removeProductFromCartByUserId(int userId, int productId);

    public void updateProductInCartByUserId(int userId, int productId, int units);
}
