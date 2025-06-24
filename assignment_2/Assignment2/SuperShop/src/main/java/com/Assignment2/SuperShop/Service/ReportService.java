package com.Assignment2.SuperShop.Service;

import com.Assignment2.SuperShop.Repository.ReportRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ReportService {
    private final ReportRepository reportRepo;

    public ReportService(ReportRepository reportRepo) {
        this.reportRepo = reportRepo;
    }

    public List<Map<String, Object>> getSalesPerCategory(String month) {
        return reportRepo.getTotalSalesPerCategory(month);
    }

    public double getTotalRevenue(String month) {
        return reportRepo.getTotalRevenue(month);
    }

    public int getOrderCount(String month) {
        return reportRepo.getOrderCount(month);
    }

    public List<Map<String, Object>> getBestSellers(String month) {
        return reportRepo.getBestSellers(month);
    }
}

