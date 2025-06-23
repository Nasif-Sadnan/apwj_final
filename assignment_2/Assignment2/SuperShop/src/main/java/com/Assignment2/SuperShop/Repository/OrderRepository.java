package com.Assignment2.SuperShop.Repository;

import com.Assignment2.SuperShop.Entity.Order;
import com.Assignment2.SuperShop.Entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

@Repository
public class OrderRepository {
    private final JdbcTemplate jdbcTemplate;

    public OrderRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private Order mapOrder(ResultSet rs) throws Exception {
        Order o = new Order();
        User user = new User();
        o.setId(rs.getInt("id"));
        o.setTotalAmount(rs.getDouble("total_amount"));
        o.setOrderDate(rs.getTimestamp("order_date").toLocalDateTime());
        user.setId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        o.setUser(user);
        return o;
    }

    public List<Order> getAllOrders() {
        String sql = """
            SELECT o.*, u.username
            FROM orders o
            JOIN users u ON o.user_id = u.id
        """;
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            try {
                return mapOrder(rs);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    public List<Order> getUserOrders(int userId) {
        String sql = """
            SELECT o.*, u.username
            FROM orders o
            JOIN users u ON o.user_id = u.id
            WHERE o.user_id = ?
        """;
        return jdbcTemplate.query(sql, new Object[]{userId}, (rs, rowNum) -> {
            try {
                return mapOrder(rs);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    public int save(Order order) {
        String sql = "INSERT INTO orders (user_id, total_amount) VALUES (?, ?)";
        jdbcTemplate.update(sql, order.getUser().getId(), order.getTotalAmount());
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
    }
}
