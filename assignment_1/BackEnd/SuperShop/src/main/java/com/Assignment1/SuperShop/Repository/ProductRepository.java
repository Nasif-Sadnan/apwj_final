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
        products.add(new Product(1, "Tomato", ProductCategory.Vegetables, 10.0, 10, LocalDate.of(2025, 7, 12), true));
        products.add(new Product(2, "Potato", ProductCategory.Vegetables, 10.0, 10, LocalDate.of(2025, 5, 12), true));
        products.add(new Product(3, "Cabbage", ProductCategory.Vegetables, 10.0, 10, LocalDate.of(2025, 5, 12), true));
        products.add(new Product(4, "Onion", ProductCategory.Vegetables, 10.0, 10, LocalDate.of(2025, 5, 12), true));
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

    // Add in ProductRepository
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
