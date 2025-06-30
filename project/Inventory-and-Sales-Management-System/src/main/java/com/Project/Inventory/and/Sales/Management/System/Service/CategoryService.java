package com.Project.Inventory.and.Sales.Management.System.Service;

import com.Project.Inventory.and.Sales.Management.System.Entity.Category;
import com.Project.Inventory.and.Sales.Management.System.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.getAll();
    }

    public Category getCategoryById(int id) {
        return categoryRepository.getById(id);
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory(Category category) {
        categoryRepository.update(category);
    }

    public void deleteCategory(int id) {
        categoryRepository.delete(id);
    }
}
