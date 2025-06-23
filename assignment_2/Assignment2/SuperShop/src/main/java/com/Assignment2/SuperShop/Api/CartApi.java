package com.Assignment2.SuperShop.Api;

import com.Assignment2.SuperShop.Entity.Cart;
import com.Assignment2.SuperShop.Service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartApi {

    private final CartService cartSvc;

    public CartApi(CartService cartSvc) {
        this.cartSvc = cartSvc;
    }

    @GetMapping("/user/{userId}")
    public List<Cart> getByUser(@PathVariable int userId) {
        return cartSvc.getByUserId(userId);
    }

    @PostMapping("/add")
    public void add(@RequestParam int userId, @RequestParam int productId, @RequestParam int quantity) {
        cartSvc.add(userId, productId, quantity);
    }

    @PutMapping("/{id}")
    public void updateQuantity(@PathVariable int id, @RequestParam int quantity) {
        cartSvc.updateQuantity(id, quantity);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable int id) {
        cartSvc.remove(id);
    }

    @DeleteMapping("/user/{userId}")
    public void clearUserCart(@PathVariable int userId) {
        cartSvc.clearUserCart(userId);
    }
}
