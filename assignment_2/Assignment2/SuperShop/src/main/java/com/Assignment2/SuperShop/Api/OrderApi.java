package com.Assignment2.SuperShop.Api;

import com.Assignment2.SuperShop.Entity.Invoice;
import com.Assignment2.SuperShop.Entity.Order;
import com.Assignment2.SuperShop.Entity.OrderItem;
import com.Assignment2.SuperShop.Entity.User;
import com.Assignment2.SuperShop.Service.InvoiceService;
import com.Assignment2.SuperShop.Service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderApi {
    private final OrderService orderSvc;
    private final InvoiceService invoiceSvc;

    public OrderApi(OrderService orderSvc, InvoiceService invoiceSvc) {
        this.orderSvc = orderSvc;
        this.invoiceSvc = invoiceSvc;
    }

    @PostMapping("/checkout")
    public int checkout(@RequestBody User user) {
        int orderId = orderSvc.placeOrder(user);

        Invoice invoice = new Invoice();
        Order orderStub = new Order();
        orderStub.setId(orderId);
        invoice.setOrder(orderStub);
        invoice.setTotalAmount(orderSvc.getOrderItems(orderId)
                .stream()
                .mapToDouble(item -> (item.getPrice() - item.getDiscount()) * item.getQuantity())
                .sum());
        invoiceSvc.generateInvoice(invoice);

        return orderId;
    }

    @GetMapping("/user/{userId}")
    public List<Order> getByUser(@PathVariable int userId) {
        return orderSvc.getUserOrders(userId);
    }

    @GetMapping("/all")
    public List<Order> getAll() {
        return orderSvc.getAllOrders();
    }

    @GetMapping("/{orderId}/items")
    public List<OrderItem> getItems(@PathVariable int orderId) {
        return orderSvc.getOrderItems(orderId);
    }

}

