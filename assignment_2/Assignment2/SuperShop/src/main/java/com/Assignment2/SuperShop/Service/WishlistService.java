package com.Assignment2.SuperShop.Service;

import com.Assignment2.SuperShop.Entity.Wishlist;
import com.Assignment2.SuperShop.Repository.WishlistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {
    private final WishlistRepository wishlistRepo;

    public WishlistService(WishlistRepository wishlistRepo) {
        this.wishlistRepo = wishlistRepo;
    }

    public List<Wishlist> getByUserId(int userId) {
        return wishlistRepo.getByUserId(userId);
    }

    public void add(int userId, int productId) {
        wishlistRepo.add(userId, productId);
    }

    public void remove(int id) {
        wishlistRepo.remove(id);
    }
}
