package com.Assignment2.SuperShop.Repository;

import com.Assignment2.SuperShop.Entity.Invoice;
import com.Assignment2.SuperShop.Entity.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class InvoiceRepository {
    private final JdbcTemplate jdbcTemplate;

    public InvoiceRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void save(Invoice invoice) {
        jdbcTemplate.update("""
            INSERT INTO invoice (order_id, total_amount)
            VALUES (?, ?)
        """, invoice.getOrder().getId(), invoice.getTotalAmount());
    }

    public List<Invoice> getByUserId(int userId) {
        String sql = """
            SELECT i.*, o.order_date
            FROM invoice i
            JOIN orders o ON i.order_id = o.id
            WHERE o.user_id = ?
        """;
        return jdbcTemplate.query(sql, new Object[]{userId}, (rs, rowNum) -> {
            Invoice invoice = new Invoice();
            Order o = new Order();
            invoice.setId(rs.getInt("id"));
            invoice.setGeneratedAt(rs.getTimestamp("generated_at").toLocalDateTime());
            invoice.setTotalAmount(rs.getDouble("total_amount"));
            o.setId(rs.getInt("order_id"));
            o.setOrderDate(rs.getTimestamp("order_date").toLocalDateTime());
            invoice.setOrder(o);
            return invoice;
        });
    }
}

