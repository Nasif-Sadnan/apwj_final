package com.Assignment2.SuperShop.Repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class ReportRepository {
    private final JdbcTemplate jdbcTemplate;

    public ReportRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Map<String, Object>> getTotalSalesPerCategory(String month) {
        String sql = """
            SELECT c.name AS category, SUM(oi.quantity * (oi.price - oi.discount)) AS revenue
            FROM order_items oi
            JOIN products p ON oi.product_id = p.id
            JOIN categories c ON p.category_id = c.id
            JOIN orders o ON oi.order_id = o.id
            WHERE DATE_FORMAT(o.order_date, '%Y-%m') = ?
            GROUP BY c.name
        """;
        return jdbcTemplate.queryForList(sql, month);
    }

    public double getTotalRevenue(String month) {
        String sql = """
            SELECT SUM(oi.quantity * (oi.price - oi.discount)) AS total
            FROM order_items oi
            JOIN orders o ON oi.order_id = o.id
            WHERE DATE_FORMAT(o.order_date, '%Y-%m') = ?
        """;
        return jdbcTemplate.queryForObject(sql, new Object[]{month}, Double.class);
    }

    public int getOrderCount(String month) {
        String sql = """
            SELECT COUNT(*) FROM orders
            WHERE DATE_FORMAT(order_date, '%Y-%m') = ?
        """;
        return jdbcTemplate.queryForObject(sql, new Object[]{month}, Integer.class);
    }

    public List<Map<String, Object>> getBestSellers(String month) {
        String sql = """
            SELECT p.name AS product, SUM(oi.quantity) AS total_sold
            FROM order_items oi
            JOIN products p ON oi.product_id = p.id
            JOIN orders o ON oi.order_id = o.id
            WHERE DATE_FORMAT(o.order_date, '%Y-%m') = ?
            GROUP BY p.name
            ORDER BY total_sold DESC
            LIMIT 5
        """;
        return jdbcTemplate.queryForList(sql, month);
    }
}
