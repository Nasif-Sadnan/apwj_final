package com.Assignment2.SuperShop.Entity;

import java.time.LocalDateTime;

public class Order {
    private Integer id;

    private User user;

    private double totalAmount;

    private LocalDateTime orderDate;

    public Order() {
        this.id = id;
        this.user = user;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
