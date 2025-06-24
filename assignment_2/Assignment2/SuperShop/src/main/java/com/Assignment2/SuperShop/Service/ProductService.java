package com.Assignment2.SuperShop.Service;

import com.Assignment2.SuperShop.Entity.Product;
import com.Assignment2.SuperShop.Repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepo;

    public ProductService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> getAll() {
        return productRepo.getAll();
    }

    public Product getById(int id) {
        return productRepo.getById(id);
    }

    public void save(Product p) {
        productRepo.save(p);
    }

    public void update(Product p) {
        productRepo.update(p);
    }

    public void delete(int id) {
        productRepo.delete(id);
    }
}
