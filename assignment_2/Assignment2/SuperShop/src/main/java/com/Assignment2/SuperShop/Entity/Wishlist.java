package com.Assignment2.SuperShop.Entity;

import java.time.LocalDateTime;

public class Wishlist {
    private Integer id;

    private User user;

    private Product product;

    private LocalDateTime addedAt;

    public Wishlist() {
        this.id = id;
        this.user = user;
        this.product = product;
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

    public LocalDateTime getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(LocalDateTime addedAt) {
        this.addedAt = addedAt;
    }
}
