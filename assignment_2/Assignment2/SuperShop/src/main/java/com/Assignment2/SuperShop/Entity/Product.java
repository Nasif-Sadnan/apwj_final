package com.Assignment2.SuperShop.Entity;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class Product {
        private Integer id;

        @NotNull
        private String name;

        @NotNull
        private double price;

        @NotNull
        private int quantity;

        @NotNull
        private LocalDate expiryDate;

        private boolean available;

        private ProductCategory category;

        public Product() {
                this.id = id;
                this.name = name;
                this.price = price;
                this.quantity = quantity;
                this.expiryDate = expiryDate;
                this.available = available;
                this.category = category;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public double getPrice() {
                return price;
        }

        public void setPrice(double price) {
                this.price = price;
        }

        public int getQuantity() {
                return quantity;
        }

        public void setQuantity(int quantity) {
                this.quantity = quantity;
        }

        public LocalDate getExpiryDate() {
                return expiryDate;
        }

        public void setExpiryDate(LocalDate expiryDate) {
                this.expiryDate = expiryDate;
        }

        public boolean isAvailable() {
                return available;
        }

        public void setAvailable(boolean available) {
                this.available = available;
        }

        public ProductCategory getCategory() {
                return category;
        }

        public void setCategory(ProductCategory category) {
                this.category = category;
        }
}
