package com.Assignment2.SuperShop.Api;

import com.Assignment2.SuperShop.Service.ReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reports")
public class ReportApi {
    private final ReportService reportSvc;

    public ReportApi(ReportService reportSvc) {
        this.reportSvc = reportSvc;
    }

    @GetMapping("/category-sales")
    public List<Map<String, Object>> getCategorySales(@RequestParam String month) {
        return reportSvc.getSalesPerCategory(month);
    }

    @GetMapping("/revenue")
    public double getRevenue(@RequestParam String month) {
        return reportSvc.getTotalRevenue(month);
    }

    @GetMapping("/order-count")
    public int getOrderCount(@RequestParam String month) {
        return reportSvc.getOrderCount(month);
    }

    @GetMapping("/best-sellers")
    public List<Map<String, Object>> getBestSellers(@RequestParam String month) {
        return reportSvc.getBestSellers(month);
    }

}
