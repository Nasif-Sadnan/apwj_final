package com.Assignment2.SuperShop.Repository;

import com.Assignment2.SuperShop.Entity.Product;
import com.Assignment2.SuperShop.Entity.ProductCategory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductRepository {
    private final JdbcTemplate jdbcTemplate;

    public ProductRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private Product mapProduct(ResultSet rs) throws SQLException {
        Product product = new Product();
        ProductCategory category = new ProductCategory();
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getDouble("price"));
        product.setQuantity(rs.getInt("quantity"));
        product.setExpiryDate(rs.getDate("expiry_date").toLocalDate());
        product.setAvailable(rs.getBoolean("available"));
        category.setId(rs.getInt("category_id"));
        category.setName(rs.getString("category_name"));
        product.setCategory(category);
        return product;
    }

    public List<Product> getAll() {
        String sql = """
            SELECT p.*, c.name AS category_name
            FROM products p
            JOIN categories c ON p.category_id = c.id
        """;
        return jdbcTemplate.query(sql, (rs, rowNum) -> mapProduct(rs));
    }

    public Product getById(int id) {
        String sql = """
            SELECT p.*, c.name AS category_name
            FROM products p
            JOIN categories c ON p.category_id = c.id
            WHERE p.id = ?
        """;
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> mapProduct(rs));
    }

    public void save(Product p) {
        jdbcTemplate.update("""
            INSERT INTO products (name, price, quantity, expiry_date, category_id, available)
            VALUES (?, ?, ?, ?, ?, ?)
        """, p.getName(), p.getPrice(), p.getQuantity(), p.getExpiryDate(), p.getCategory().getId(), p.isAvailable());
    }

    public void update(Product p) {
        jdbcTemplate.update("""
            UPDATE products SET name=?, price=?, quantity=?, expiry_date=?, category_id=?, available=?
            WHERE id=?
        """, p.getName(), p.getPrice(), p.getQuantity(), p.getExpiryDate(), p.getCategory().getId(), p.isAvailable(), p.getId());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM products WHERE id = ?", id);
    }
}
