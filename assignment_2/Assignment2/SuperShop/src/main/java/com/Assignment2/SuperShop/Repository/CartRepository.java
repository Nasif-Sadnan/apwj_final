package com.Assignment2.SuperShop.Repository;

import com.Assignment2.SuperShop.Entity.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
@Repository
public class CartRepository {
    private final JdbcTemplate jdbcTemplate;

    public CartRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Cart> getByUserId(int userId) {
        String sql = """
            SELECT cart.*, u.username, p.*, c.name AS category_name
            FROM cart
            JOIN users u ON cart.user_id = u.id
            JOIN products p ON cart.product_id = p.id
            JOIN categories c ON p.category_id = c.id
            WHERE cart.user_id = ?
        """;

        return jdbcTemplate.query(sql, new Object[]{userId}, (rs, rowNum) -> {
            Cart cart = new Cart();
            cart.setId(rs.getInt("id"));
            cart.setQuantity(rs.getInt("quantity"));
            cart.setAddedAt(rs.getTimestamp("added_at").toLocalDateTime());

            User user = new User();
            user.setId(userId);
            user.setUsername(rs.getString("username"));
            cart.setUser(user);

            Product p = new Product();
            ProductCategory category = new ProductCategory();
            p.setId(rs.getInt("product_id"));
            p.setName(rs.getString("name"));
            p.setPrice(rs.getDouble("price"));
            p.setQuantity(rs.getInt("quantity"));
            p.setExpiryDate(rs.getDate("expiry_date").toLocalDate());
            p.setAvailable(rs.getBoolean("available"));
            category.setId(rs.getInt("category_id"));
            category.setName(rs.getString("category_name"));
            p.setCategory(category);

            cart.setProduct(p);
            return cart;
        });
    }

    public void add(int userId, int productId, int quantity) {
        jdbcTemplate.update("INSERT INTO cart (user_id, product_id, quantity) VALUES (?, ?, ?)", userId, productId, quantity);
    }

    public void updateQuantity(int cartId, int quantity) {
        jdbcTemplate.update("UPDATE cart SET quantity = ? WHERE id = ?", quantity, cartId);
    }

    public void remove(int id) {
        jdbcTemplate.update("DELETE FROM cart WHERE id = ?", id);
    }

    public void clearUserCart(int userId) {
        jdbcTemplate.update("DELETE FROM cart WHERE user_id = ?", userId);
    }
}
