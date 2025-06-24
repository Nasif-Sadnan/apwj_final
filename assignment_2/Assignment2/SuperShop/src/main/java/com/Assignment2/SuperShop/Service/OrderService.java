package com.Assignment2.SuperShop.Service;

import com.Assignment2.SuperShop.Entity.*;
import com.Assignment2.SuperShop.Repository.CartRepository;
import com.Assignment2.SuperShop.Repository.OrderItemRepository;
import com.Assignment2.SuperShop.Repository.OrderRepository;
import com.Assignment2.SuperShop.Repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepo;
    private final OrderItemRepository itemRepo;
    private final CartRepository cartRepo;
    private final ProductRepository productRepo;

    public OrderService(OrderRepository orderRepo, OrderItemRepository itemRepo, CartRepository cartRepo, ProductRepository productRepo) {
        this.orderRepo = orderRepo;
        this.itemRepo = itemRepo;
        this.cartRepo = cartRepo;
        this.productRepo = productRepo;
    }

    public int placeOrder(User user) {
        List<Cart> cartItems = cartRepo.getByUserId(user.getId());
        double total = 0;

        Order order = new Order();
        order.setUser(user);
        order.setTotalAmount(0);
        int orderId = orderRepo.save(order);
        order.setId(orderId);

        for (Cart c : cartItems) {
            Product p = productRepo.getById(c.getProduct().getId());

            double discount = 0;
            if (p.getExpiryDate().isBefore(LocalDate.now().plusDays(7))) {
                discount = p.getPrice() * 0.1; // 10% discount if expiring within 7 days
            }

            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setProduct(p);
            item.setQuantity(c.getQuantity());
            item.setPrice(p.getPrice());
            item.setDiscount(discount);
            itemRepo.save(item);

            total += (p.getPrice() - discount) * c.getQuantity();
        }


        order.setTotalAmount(total);
        orderRepo.save(order);


        cartRepo.clearUserCart(user.getId());

        return orderId;
    }

    public List<Order> getUserOrders(int userId) {
        return orderRepo.getUserOrders(userId);
    }

    public List<Order> getAllOrders() {
        return orderRepo.getAllOrders();
    }

    public List<OrderItem> getOrderItems(int orderId) {
        return itemRepo.getItemsByOrderId(orderId);
    }
}
