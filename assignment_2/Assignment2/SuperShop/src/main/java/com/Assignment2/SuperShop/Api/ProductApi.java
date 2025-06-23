package com.Assignment2.SuperShop.Api;

import com.Assignment2.SuperShop.Entity.Product;
import com.Assignment2.SuperShop.Service.ProductService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Validated
public class ProductApi {
    private final ProductService prodSvc;

    public ProductApi(ProductService prodSvc) {
        this.prodSvc = prodSvc;
    }

    @GetMapping("/all")
    public List<Product> getAll() {
        return prodSvc.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id) {
        return prodSvc.getById(id);
    }

    @PostMapping("/{id}")
    public void save(@RequestBody Product product) {
        prodSvc.save(product);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Product product, @PathVariable int id) {
        product.setId(id);
        prodSvc.update(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        prodSvc.delete(id);
    }
}
