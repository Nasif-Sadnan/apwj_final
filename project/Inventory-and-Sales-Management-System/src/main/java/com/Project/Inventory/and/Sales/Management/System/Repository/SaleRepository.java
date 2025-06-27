package com.Project.Inventory.and.Sales.Management.System.Repository;

import com.Project.Inventory.and.Sales.Management.System.Entity.Sale;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class SaleRepository {
    private final JdbcTemplate jdbcTemplate;

    public SaleRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Sale> getAll() {
        return jdbcTemplate.query("SELECT * FROM sales", new BeanPropertyRowMapper<>(Sale.class));
    }

    public void save(Sale sale) {
        jdbcTemplate.update("INSERT INTO sales (user_id, total_amount, sale_date) VALUES (?, ?, ?)",
                sale.getUserId(), sale.getTotalAmount(), sale.getSaleDate());
    }

}
