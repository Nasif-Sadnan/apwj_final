package com.Project.Inventory.and.Sales.Management.System.Entity;

import java.time.LocalDateTime;

public class Sale {

    private Integer id;
    private Integer userId;
    private Double totalAmount;
    private LocalDateTime saleDate;

    public Sale() {
    }

    public Sale(Integer id, Integer userId, Double totalAmount, LocalDateTime saleDate) {
        this.id = id;
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.saleDate = saleDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }
}
