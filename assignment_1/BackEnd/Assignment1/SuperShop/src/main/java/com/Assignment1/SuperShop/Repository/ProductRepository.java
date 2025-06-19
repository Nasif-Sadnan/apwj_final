package com.Assignment1.SuperShop.Repository;

import com.Assignment1.SuperShop.Entity.Product;
import com.Assignment1.SuperShop.ProductCategory;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {
    public static final List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1, "Tomato", ProductCategory.Vegetables, 12.0, 10, LocalDate.of(2025, 7, 12), true));
        products.add(new Product(2, "Potato", ProductCategory.Vegetables, 11.4, 10, LocalDate.of(2025, 6, 21), true));
        products.add(new Product(3, "Cabbage", ProductCategory.Vegetables, 14.0, 10, LocalDate.of(2025, 6, 22), true));
        products.add(new Product(4, "Onion", ProductCategory.Vegetables, 17.0, 10, LocalDate.of(2025, 6, 23), true));
        products.add(new Product(5, "Beef", ProductCategory.Meat, 665.0, 12, LocalDate.of(2025, 6, 21), true));
        products.add(new Product(6, "Pork", ProductCategory.Meat, 300.0, 10, LocalDate.of(2025, 6, 26), true));
        products.add(new Product(7, "Chicken", ProductCategory.Meat, 325.4, 10, LocalDate.of(2025, 6, 27), true));
        products.add(new Product(8, "Milk", ProductCategory.Groceries, 18.0, 10, LocalDate.of(2025, 6, 21), true));
        products.add(new Product(9, "Bread", ProductCategory.Groceries, 10.0, 10, LocalDate.of(2025, 6, 21), true));
        products.add(new Product(10, "Rice", ProductCategory.Groceries, 14.0, 10, LocalDate.of(2025, 6, 23), true));
        products.add(new Product(11, "Sugar", ProductCategory.Groceries, 12.0, 10, LocalDate.of(2025, 6, 27), true));
        products.add(new Product(12, "Salt", ProductCategory.Groceries, 10.0, 10, LocalDate.of(2025, 6, 27), true));
        products.add(new Product(13, "Soap", ProductCategory.BeautyCare, 12.0, 10, LocalDate.of(2025, 6, 20), true));
        products.add(new Product(14, "Shampoo", ProductCategory.BeautyCare, 12.0, 10, LocalDate.of(2025, 6, 21), true));
        products.add(new Product(15, "Toothpaste", ProductCategory.BeautyCare, 17.0, 10, LocalDate.of(2025, 6, 22), true));
        products.add(new Product(16, "Toothbrush", ProductCategory.BeautyCare, 12.6, 10, LocalDate.of(2025, 6, 21), true));
        products.add(new Product(17, "Cycle", ProductCategory.Others, 10000.0, 10, LocalDate.of(2029, 6, 21), true));
        products.add(new Product(18, "Mobile", ProductCategory.Others, 10000.0, 10, LocalDate.of(2029, 6, 21), true));

    }

    public List<Product> getAllProducts() {
        return products;
    }


    public Product getProductById(int id) {
        return products.stream().filter(product -> product.getID() == id).findFirst().orElse(null);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(Product product) {
        int index = products.indexOf(product);
        if (index != -1) {
            products.set(index, product);
        }
    }



    public void deleteProductById(int id) {
        products.removeIf(product -> product.getID() == id);
    }

    public List<Product> getProductsByCategory(ProductCategory category) {
        return products.stream().filter(product -> product.getCategory() == category).toList();
    }

    public List<Product> getExpiringIn7Days() {
        LocalDate today = LocalDate.now();
        LocalDate in7Days = today.plusDays(7);
        return products.stream()
                .filter(p -> p.getExpiryDate() != null &&
                        !p.getExpiryDate().isBefore(today) &&
                        !p.getExpiryDate().isAfter(in7Days))
                .toList();
    }

    public List<Product> getProductsByAvailability(boolean isAvailable) {
        return products.stream().filter(product -> product.getAvailable() == isAvailable).toList();
    }

    public List<Product> getDiscountedByCategory(ProductCategory category, double discountRate) {
        return products.stream()
                .filter(p -> p.getCategory() == category)
                .map(p -> new Product(
                        p.getID(),
                        p.getName(),
                        p.getCategory(),
                        p.getPrice() * (1 - discountRate), // Corrected logic
                        p.getQuantity(),
                        p.getExpiryDate(),
                        p.getAvailable()
                ))
                .toList();
    }

<<<<<<< HEAD
    
=======
   
>>>>>>> 0f2c241f1a6abe2dd499d7d22df4053ffd1772c0
    public void markExpiredProductsUnavailable() {
        LocalDate today = LocalDate.now();
        products.forEach(p -> {
            if (p.getExpiryDate() != null && p.getExpiryDate().isBefore(today)) {
                p.setAvailable(false);
            }
        });
    }

    public Map<ProductCategory, Double> getTotalValueGroupedByCategory() {
        return products.stream()
                .filter(Product::getAvailable)
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.summingDouble(p -> p.getPrice() * p.getQuantity())
                ));
    }


}
