package com.Assignment2.SuperShop.Service;

import com.Assignment2.SuperShop.Entity.ProductCategory;
import com.Assignment2.SuperShop.Repository.ProductCategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryService {
    private final ProductCategoryRepository categoryRepo;

    public CategoryService(ProductCategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public List<ProductCategory> getAll() {
        return categoryRepo.getAll();
    }

    public ProductCategory getById(int id) {
        return categoryRepo.getById(id);
    }
}
