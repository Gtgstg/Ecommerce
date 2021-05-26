package com.company.Model;

import com.company.Manager.CartManager;
import com.company.Manager.CartManagerImpl;

import java.util.Date;
import java.util.Objects;

public class User {
    private int userId;

    private String name;
    private String address;
    private String password;

    private Date dob;

    public CartManager getCart() {
        return cart;
    }

    public void setCart(CartManager cart) {
        this.cart = cart;
    }

    private Login loginStatus;
    private CartManager cart;

    public User(int userId, String name, String address, String password, Date dob) {
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.password = password;
        this.loginStatus = Login.LOGGEDIN;
        this.cart = new CartManagerImpl();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name) && address.equals(user.address) && dob.equals(user.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, dob);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Login getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Login loginStatus) {
        this.loginStatus = loginStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
