package com.Project.Inventory.and.Sales.Management.System.Service;

import com.Project.Inventory.and.Sales.Management.System.Entity.Sale;
import com.Project.Inventory.and.Sales.Management.System.Entity.SaleItem;
import com.Project.Inventory.and.Sales.Management.System.Repository.SaleItemRepository;
import com.Project.Inventory.and.Sales.Management.System.Repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {
    private SaleRepository saleRepository;
    private SaleItemRepository saleItemRepository;

    public void recordSale(Sale sale, List<SaleItem> items) {
        saleRepository.save(sale);
        for (SaleItem item : items) {
            item.setSaleId(sale.getId()); // you must retrieve the latest inserted ID or auto-increment
            saleItemRepository.save(item);
        }
    }

    public List<Sale> getSalesHistory() {
        return saleRepository.getAll();
    }

    public List<SaleItem> getItemsBySale(int saleId) {
        return saleItemRepository.getBySaleId(saleId);
    }
}
