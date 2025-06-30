package com.Project.Inventory.and.Sales.Management.System.Service;

import com.Project.Inventory.and.Sales.Management.System.Entity.Discount;
import com.Project.Inventory.and.Sales.Management.System.Repository.DiscountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService {
    private DiscountRepository discountRepository;

    public List<Discount> getActiveDiscounts() {
        return discountRepository.getActiveDiscounts();
    }
}
