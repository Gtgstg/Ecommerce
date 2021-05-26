package com.company.Manager;

import com.company.Model.Cart;
import com.company.Model.Login;
import com.company.Model.Product;
import com.company.Model.User;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.text.SimpleDateFormat;

public class UserManagerImpl implements UserManager {
    private static UserManager userManager;
    private HashMap<Integer, User> users;
    private int totalUser;

    ProductManager productManager;
    CartManager cartManager;

    public UserManagerImpl() {
        this.users = new HashMap<Integer, User>();
        this.cartManager = new CartManagerImpl();
        this.productManager = ProductManagerImpl.getInstance();
        this.totalUser = 0;
    }

    public static UserManager getInstance() {
        if (userManager == null) {
            userManager = new UserManagerImpl();
        }
        return userManager;
    }

    private Login checkLoginStatus(int userId) {
        if (users.containsKey(userId)) {
            return users.get(userId).getLoginStatus();
        }
        return Login.NOUSEREXIST;
    }

    private boolean checkIfAlreadyPresent(String name, String address, String password, Date dob) {
        User currentUser = new User(0, name, address, password, dob);
        for (User user : users.values()) {
            if (user.equals(currentUser)) {
                return true;
            }
        }
        return false;
    }

    private Date getDate(String dob) {
        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
        } catch (ParseException parseException) {
            System.out.println("Date should be in dd/MM/YYYY format.");
        }
        return date;
    }

    public User getUserById(int userId) {
        if (users.containsKey(userId)) {
            System.out.println("User Id      Name       Address       Password       DOB");
            User user = users.get(userId);
            System.out.println(user.getUserId() + " " + user.getName() + "       " + user.getAddress() + "       " + user.getPassword() + "       " + user.getDob());
            return user;
        }
        System.out.println("There is no product " + userId);
        return null;
    }


    public void removeUserById(int userId) {
        if (users.containsKey(userId)) {
            users.remove(userId);
            System.out.println(userId + " removed successfully.");
        } else {
            System.out.println("User is not available.");
        }
    }

    public void updateUserById(int userId, String name, String address, String password, String dob) {
        Date date = getDate(dob);
        if (date == null) return;
        if (users.containsKey(userId)) {
            User user = users.get(userId);
            user.setName(name);
            user.setAddress(address);
            user.setPassword(password);
            user.setDob(date);
            System.out.println(userId + " udpated successfully.");
        } else {
            System.out.println("User is not available.");
        }
    }

    public void signUp(String name, String address, String password, String dob) {
        Date date = getDate(dob);
        if (date == null) return;
        if (checkIfAlreadyPresent(name, address, password, date)) {
            System.out.println("You are already registered.");
            return;
        }
        User newUser = new User(++this.totalUser, name, address, password, date);
        users.put(this.totalUser, newUser);
        System.out.println("SignUp Successful! Your userId is: " + totalUser);
    }

    public void logIn(int userId, String password) {
        if (checkLoginStatus(userId) == Login.LOGGEDOUT) {
            User user = users.get(userId);
            if (user.getPassword().equals(password)) {
                user.setLoginStatus(Login.LOGGEDIN);
                System.out.println("Login Successful!");
            } else {
                System.out.println("Invaild Password. Please Login again.");
            }

        } else if (checkLoginStatus(userId) == Login.LOGGEDIN) {
            System.out.println("Already LoggedIn.");
        } else {
            System.out.println("Please Signup First.");
        }
    }

    public void logout(int userId) {
        if (checkLoginStatus(userId) != Login.LOGGEDOUT) {
            users.get(userId).setLoginStatus(Login.LOGGEDOUT);
            System.out.println("Successfully Logged Out.");
        } else {
            System.out.println("Please Signup/Login First.");
        }
    }

    public void browseProducts(int userId) {
        if (checkLoginStatus(userId) == Login.LOGGEDIN) {
            productManager.showProducts();
        } else {
            System.out.println("Please Signup/Login First.");
        }
    }

    public void addProductToCart(int userId, int productId, int numberOfUnits) {
        if (checkLoginStatus(userId) == Login.LOGGEDIN) {
            User currentUser = users.get(userId);
            currentUser.getCart().addCart(productId, numberOfUnits);
        } else {
            System.out.println("Please Signup/Login First.");
        }
    }

    public void removeProductFromCartByUserId(int userId, int productId) {
        if (checkLoginStatus(userId) == Login.LOGGEDIN) {
            User currentUser = users.get(userId);
            currentUser.getCart().removeCart(productId);
        } else {
            System.out.println("Please Signup/Login First.");
        }
    }

    public void updateProductInCartByUserId(int userId, int productId, int units) {
        if (checkLoginStatus(userId) == Login.LOGGEDIN) {
            User currentUser = users.get(userId);
            currentUser.getCart().updateCart(productId, units);
        } else {
            System.out.println("Please Signup/Login First.");
        }
    }

    public void checkOut(int userId) {
        if (checkLoginStatus(userId) == Login.LOGGEDIN) {
            User currentUser = users.get(userId);
            currentUser.getCart().showCart();
            currentUser.getCart().checkOut();
        } else {
            System.out.println("Please Signup/Login First.");
        }
    }
}
