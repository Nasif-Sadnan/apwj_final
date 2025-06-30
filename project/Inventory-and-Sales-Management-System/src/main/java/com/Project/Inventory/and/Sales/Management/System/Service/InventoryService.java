package com.Project.Inventory.and.Sales.Management.System.Service;

import com.Project.Inventory.and.Sales.Management.System.Entity.Product;
import com.Project.Inventory.and.Sales.Management.System.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    private ProductRepository productRepository;

    public List<Product> getInventoryReport() {
        return productRepository.getAll();
    }

    public List<Product> getLowStockReport(int threshold) {
        return productRepository.getLowStock(threshold);
    }
}
