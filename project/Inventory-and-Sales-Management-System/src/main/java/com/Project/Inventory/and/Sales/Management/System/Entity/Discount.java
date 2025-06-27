package com.Project.Inventory.and.Sales.Management.System.Entity;

import java.time.LocalDate;

public class Discount {
    private Integer id;
    private Integer productId;
    private Double discountPercent;
    private LocalDate startDate;
    private LocalDate endDate;


    public Discount() {}

    public Discount(Integer id, Integer productId, Double discountPercent, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.productId = productId;
        this.discountPercent = discountPercent;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
