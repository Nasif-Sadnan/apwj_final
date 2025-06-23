package com.Assignment2.SuperShop.Entity;

import java.time.LocalDateTime;

public class Cart {
    private Integer id;

    private User user;

    private Product product;

    private int quantity;

    private LocalDateTime addedAt;

    public Cart() {
        this.id = id;
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.addedAt = addedAt;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(LocalDateTime addedAt) {
        this.addedAt = addedAt;
    }
}
