package com.Assignment2.SuperShop.Repository;

import com.Assignment2.SuperShop.Entity.ProductCategory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ProductCategoryRepository {
    private final JdbcTemplate jdbcTemplate;

    public ProductCategoryRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<ProductCategory> getAll() {
        return jdbcTemplate.query("SELECT * FROM categories", new BeanPropertyRowMapper<>(ProductCategory.class));
    }

    public ProductCategory getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM categories WHERE id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(ProductCategory.class));
    }
}
