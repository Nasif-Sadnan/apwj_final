package com.Project.Inventory.and.Sales.Management.System.Service;

import com.Project.Inventory.and.Sales.Management.System.Entity.Product;
import com.Project.Inventory.and.Sales.Management.System.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void updateProduct(Product product) {
        productRepository.update(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.getAll();
    }

    public List<Product> getLowStockProducts(int threshold) {
        return productRepository.getLowStock(threshold);
    }

    public void restockProduct(int productId, int additionalQuantity) {
        Product product = productRepository.getById(productId);
        product.setQuantity(product.getQuantity() + additionalQuantity);
        productRepository.update(product);
    }
}
