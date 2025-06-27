package com.Project.Inventory.and.Sales.Management.System.Repository;

import com.Project.Inventory.and.Sales.Management.System.Entity.Category;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CategoryRepository {
    private final JdbcTemplate jdbcTemplate;

    public CategoryRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Category> getAll() {
        return jdbcTemplate.query("SELECT * FROM categories", new BeanPropertyRowMapper<>(Category.class));
    }

    public Category getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM categories WHERE id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Category.class));
    }

    public void save(Category category) {
        jdbcTemplate.update("INSERT INTO categories (name, description) VALUES (?, ?)", category.getName(), category.getDescription());
    }

    public void update(Category category) {
        jdbcTemplate.update("UPDATE categories SET name = ?, description = ? WHERE id = ?",
                category.getName(), category.getDescription(), category.getId());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM categories WHERE id = ?", id);
    }
}
