package com.Project.Inventory.and.Sales.Management.System.Repository;

import com.Project.Inventory.and.Sales.Management.System.Entity.Discount;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class DiscountRepository {
    private final JdbcTemplate jdbcTemplate;

    public DiscountRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Discount> getActiveDiscounts() {
        return jdbcTemplate.query("SELECT * FROM discounts WHERE CURDATE() BETWEEN start_date AND end_date", new BeanPropertyRowMapper<>(Discount.class));
    }
}
