package com.Assignment2.SuperShop.Repository;

import com.Assignment2.SuperShop.Entity.Product;
import com.Assignment2.SuperShop.Entity.ProductCategory;
import com.Assignment2.SuperShop.Entity.User;
import com.Assignment2.SuperShop.Entity.Wishlist;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
@Repository
public class WishlistRepository {
    private final JdbcTemplate jdbcTemplate;

    public WishlistRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Wishlist> getByUserId(int userId) {
        String sql = """
            SELECT w.id AS wid, w.added_at, u.id AS uid, u.username, p.*, c.name AS category_name
            FROM wishlist w
            JOIN users u ON w.user_id = u.id
            JOIN products p ON w.product_id = p.id
            JOIN categories c ON p.category_id = c.id
            WHERE w.user_id = ?
        """;
        return jdbcTemplate.query(sql, new Object[]{userId}, (rs, rowNum) -> {
            Wishlist w = new Wishlist();
            w.setId(rs.getInt("wid"));
            w.setAddedAt(rs.getTimestamp("added_at").toLocalDateTime());

            User u = new User();
            u.setId(rs.getInt("uid"));
            u.setUsername(rs.getString("username"));
            w.setUser(u);

            Product p = new Product();
            ProductCategory cat = new ProductCategory();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setPrice(rs.getDouble("price"));
            p.setQuantity(rs.getInt("quantity"));
            p.setExpiryDate(rs.getDate("expiry_date").toLocalDate());
            p.setAvailable(rs.getBoolean("available"));
            cat.setId(rs.getInt("category_id"));
            cat.setName(rs.getString("category_name"));
            p.setCategory(cat);

            w.setProduct(p);
            return w;
        });
    }

    public void add(int userId, int productId) {
        jdbcTemplate.update("INSERT INTO wishlist (user_id, product_id) VALUES (?, ?)", userId, productId);
    }

    public void remove(int id) {
        jdbcTemplate.update("DELETE FROM wishlist WHERE id = ?", id);
    }
}
