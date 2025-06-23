package com.Assignment2.SuperShop.Api;

import com.Assignment2.SuperShop.Entity.Wishlist;
import com.Assignment2.SuperShop.Service.WishlistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistApi {
    private final WishlistService wishSvc;

    public WishlistApi(WishlistService wishSvc) {
        this.wishSvc = wishSvc;
    }

    @GetMapping("/user/{userId}")
    public List<Wishlist> getByUser(@PathVariable int userId) {
        return wishSvc.getByUserId(userId);
    }

    @PostMapping("/add")
    public void add(@RequestParam int userId, @RequestParam int productId) {
        wishSvc.add(userId, productId);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable int id) {
        wishSvc.remove(id);
    }

}
