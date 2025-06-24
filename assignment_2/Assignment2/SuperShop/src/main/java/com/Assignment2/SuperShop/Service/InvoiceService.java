package com.Assignment2.SuperShop.Service;

import com.Assignment2.SuperShop.Entity.Invoice;
import com.Assignment2.SuperShop.Repository.InvoiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InvoiceService {
    private final InvoiceRepository invoiceRepo;

    public InvoiceService(InvoiceRepository invoiceRepo) {
        this.invoiceRepo = invoiceRepo;
    }

    public void generateInvoice(Invoice invoice) {
        invoiceRepo.save(invoice);
    }

    public List<Invoice> getByUserId(int userId) {
        return invoiceRepo.getByUserId(userId);
    }
}
