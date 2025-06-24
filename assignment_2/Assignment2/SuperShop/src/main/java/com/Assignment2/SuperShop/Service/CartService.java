package com.Assignment2.SuperShop.Service;

import com.Assignment2.SuperShop.Entity.Cart;
import com.Assignment2.SuperShop.Repository.CartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartService {
    private final CartRepository cartRepo;

    public CartService(CartRepository cartRepo) {
        this.cartRepo = cartRepo;
    }

    public List<Cart> getByUserId(int userId) {
        return cartRepo.getByUserId(userId);
    }

    public void add(int userId, int productId, int quantity) {
        cartRepo.add(userId, productId, quantity);
    }

    public void updateQuantity(int cartId, int quantity) {
        cartRepo.updateQuantity(cartId, quantity);
    }

    public void remove(int id) {
        cartRepo.remove(id);
    }

    public void clearUserCart(int userId) {
        cartRepo.clearUserCart(userId);
    }
}
