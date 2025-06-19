package com.Assignment1.SuperShop.API;

import com.Assignment1.SuperShop.Entity.Product;
import com.Assignment1.SuperShop.ProductCategory;
import com.Assignment1.SuperShop.Service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductApi {
    public ProductService productService;

    public ProductApi(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Product getProductById(@PathVariable("id") int id)
    {
        return productService.getProductById(id);
    }

    @PostMapping("/add")
    public String addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return "Product added successfully";
    }

    @PutMapping("/update")
    public String updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
        return "Product updated successfully";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        productService.deleteProduct(id);
        return "Product deleted successfully";
    }

    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable("category") ProductCategory category) {
        return productService.getProductsByCategory(category);
    }

    @GetMapping("/available")
    public List<Product> getAvailableProducts() {
        return productService.getAvailableProducts();
    }

    @GetMapping("/expiring")
    public List<Product> getExpiringProducts() {
        return productService.getExpiringIn7Days();
    }

    @GetMapping("/discount")
    public List<Product> getDiscountedProducts(@RequestParam("category") ProductCategory category,
                                               @RequestParam("rate") double rate) {
        if (rate < 0 || rate > 1) {
            throw new IllegalArgumentException("Discount rate must be between 0 and 1.");
        }
        return productService.getDiscountedProducts(category, rate);
    }

    @GetMapping("/report/total-value")
    public Map<ProductCategory, Double> getTotalValueGroupedByCategory() {
        productService.markExpiredProductsUnavailable();
        return productService.getTotalValueGroupedByCategory();
    }


    @GetMapping("/report/discounted-by-category")
    public List<Product> getDiscountedByCategory(@RequestParam ProductCategory category,
                                                 @RequestParam double rate) {
        if (rate < 0 || rate > 1) {
            throw new IllegalArgumentException("Discount rate must be between 0 and 1.");
        }
        return productService.getDiscountedProducts(category, rate);
    }


}
