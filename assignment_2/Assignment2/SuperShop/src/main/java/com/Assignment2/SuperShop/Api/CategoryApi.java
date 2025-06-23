package com.Assignment2.SuperShop.Api;

import com.Assignment2.SuperShop.Entity.ProductCategory;
import com.Assignment2.SuperShop.Service.CategoryService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@Validated
public class CategoryApi {
    private final CategoryService catSvc;

    public CategoryApi(CategoryService catSvc) {
        this.catSvc = catSvc;
    }

    @GetMapping("/all")
    public List<ProductCategory> getAll() {
        return catSvc.getAll();
    }

    @GetMapping("/{id}")
    public ProductCategory getById(@PathVariable int id) {
        return catSvc.getById(id);
    }

}
