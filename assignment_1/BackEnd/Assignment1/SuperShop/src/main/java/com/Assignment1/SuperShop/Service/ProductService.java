package com.Assignment1.SuperShop.Service;

import com.Assignment1.SuperShop.Entity.Product;
import com.Assignment1.SuperShop.ProductCategory;
import com.Assignment1.SuperShop.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    public ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Product getProductById(int id) {
        return productRepository.getProductById(id);
    }

    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    public void updateProduct(Product product) {
        productRepository.updateProduct(product);
    }

    public void deleteProduct(int id) {
        productRepository.deleteProductById(id);
    }

    public List<Product> getProductsByCategory(ProductCategory category) {
        return productRepository.getProductsByCategory(category);
    }

    public List<Product> getAvailableProducts() {
        return productRepository.getProductsByAvailability(true);
    }

    public List<Product> getExpiringIn7Days() {
        return productRepository.getExpiringIn7Days();
    }

    public List<Product> getDiscountedProducts(ProductCategory category, double discountRate) {
        return productRepository.getDiscountedByCategory(category, discountRate);
    }

    public void markExpiredProductsUnavailable() {
        productRepository.markExpiredProductsUnavailable();
    }

    public Map<ProductCategory, Double> getTotalValueGroupedByCategory() {
        return productRepository.getTotalValueGroupedByCategory();
    }




}
