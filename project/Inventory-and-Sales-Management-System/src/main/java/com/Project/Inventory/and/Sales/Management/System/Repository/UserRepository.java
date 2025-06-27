package com.Project.Inventory.and.Sales.Management.System.Repository;

import com.Project.Inventory.and.Sales.Management.System.Entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<User> getAll() {
        return jdbcTemplate.query("SELECT * FROM users", new BeanPropertyRowMapper<>(User.class));
    }

    public User getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
    }

    public void save(User user) {
        jdbcTemplate.update("INSERT INTO users (username, email, password, role) VALUES (?, ?, ?, ?)",
                user.getUsername(), user.getEmail(), user.getPassword(), user.getRole());
    }

    public void update(User user) {
        jdbcTemplate.update("UPDATE users SET username = ?, email = ?, password = ?, role = ? WHERE id = ?",
                user.getUsername(), user.getEmail(), user.getPassword(), user.getRole(), user.getId());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
    }
}
