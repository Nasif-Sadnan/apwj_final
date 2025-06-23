package com.Assignment2.SuperShop.Repository;

import com.Assignment2.SuperShop.Entity.User;
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

    public User getByUsername(String username) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE username = ?", new Object[]{username}, new BeanPropertyRowMapper<>(User.class));
    }

    public void save(User user) {
        jdbcTemplate.update("INSERT INTO users (username, password, role) VALUES (?, ?, ?)", user.getUsername(), user.getPassword(), user.getRole());
    }
}
