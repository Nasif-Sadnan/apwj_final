package com.Assignment2.SuperShop.Repository;

import com.Assignment2.SuperShop.Entity.OrderItem;
import com.Assignment2.SuperShop.Entity.Product;
import com.Assignment2.SuperShop.Entity.ProductCategory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class OrderItemRepository {
    private final JdbcTemplate jdbcTemplate;

    public OrderItemRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void save(OrderItem item) {
        String sql = """
            INSERT INTO order_items (order_id, product_id, quantity, price, discount)
            VALUES (?, ?, ?, ?, ?)
        """;
        jdbcTemplate.update(sql,
                item.getOrder().getId(),
                item.getProduct().getId(),
                item.getQuantity(),
                item.getPrice(),
                item.getDiscount()
        );
    }

    public List<OrderItem> getItemsByOrderId(int orderId) {
        String sql = """
            SELECT oi.*, p.*, c.name AS category_name
            FROM order_items oi
            JOIN products p ON oi.product_id = p.id
            JOIN categories c ON p.category_id = c.id
            WHERE oi.order_id = ?
        """;
        return jdbcTemplate.query(sql, new Object[]{orderId}, (rs, rowNum) -> {
            OrderItem item = new OrderItem();
            Product product = new Product();
            ProductCategory cat = new ProductCategory();

            item.setId(rs.getInt("id"));
            item.setQuantity(rs.getInt("quantity"));
            item.setPrice(rs.getDouble("price"));
            item.setDiscount(rs.getDouble("discount"));

            product.setId(rs.getInt("product_id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
            product.setQuantity(rs.getInt("quantity"));
            product.setExpiryDate(rs.getDate("expiry_date").toLocalDate());
            product.setAvailable(rs.getBoolean("available"));
            cat.setId(rs.getInt("category_id"));
            cat.setName(rs.getString("category_name"));
            product.setCategory(cat);

            item.setProduct(product);
            return item;
        });
    }
}
