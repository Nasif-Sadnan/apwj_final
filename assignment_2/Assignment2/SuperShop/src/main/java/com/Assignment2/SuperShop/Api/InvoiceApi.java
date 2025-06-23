package com.Assignment2.SuperShop.Api;

import com.Assignment2.SuperShop.Entity.Invoice;
import com.Assignment2.SuperShop.Service.InvoiceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceApi {
    private final InvoiceService invoiceSvc;

    public InvoiceApi(InvoiceService invoiceSvc) {
        this.invoiceSvc = invoiceSvc;
    }

    @GetMapping("/user/{userId}")
    public List<Invoice> getByUser(@PathVariable int userId) {
        return invoiceSvc.getByUserId(userId);
    }

}
