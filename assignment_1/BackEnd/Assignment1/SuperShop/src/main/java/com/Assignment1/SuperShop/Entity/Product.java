package com.Assignment1.SuperShop.Entity;

import com.Assignment1.SuperShop.ProductCategory;

import java.time.LocalDate;

public class Product {
    private int ID ;
    private String Name ;
    private ProductCategory Category ;
    private double Price ;
    private int Quantity ;
    private LocalDate ExpiryDate ;
    private Boolean IsAvailable ;

    public Product(int ID, String Name, ProductCategory Category, double Price, int Quantity, LocalDate ExpiryDate, Boolean IsAvailable) {
        this.ID = ID;
        this.Name = Name;
        this.Category = Category;
        this.Price = Price;
        this.Quantity = Quantity;
        this.ExpiryDate = ExpiryDate;
        this.IsAvailable = IsAvailable;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public ProductCategory getCategory() {
        return Category;
    }

    public void setCategory(ProductCategory Category) {
       this.Category = Category;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public LocalDate getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(LocalDate ExpiryDate) {
        this.ExpiryDate = ExpiryDate;
    }

    public Boolean getAvailable() {
        return IsAvailable;
    }

    public void setAvailable(Boolean IsAvailable) {
        this.IsAvailable = IsAvailable;
    }
}
