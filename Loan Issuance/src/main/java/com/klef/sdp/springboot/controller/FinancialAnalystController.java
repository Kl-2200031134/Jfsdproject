package com.klef.sdp.springboot.controller;

import com.klef.sdp.springboot.service.LoanService;
import com.klef.sdp.springboot.model.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FinancialAnalystController {

    @Autowired
    private LoanService loanService;

    @GetMapping("/financialanalysis")
    public String getLoanData(Model model) {
        // Fetch all loan data
        List<Loan> loans = loanService.getAllLoans();

        // Count the loans by their status
        long pendingCount = loanService.getLoanCountByStatus("Pending");
        long approvedCount = loanService.getLoanCountByStatus("Approved");
        long rejectedCount = loanService.getLoanCountByStatus("Rejected");

        // Pass data to the JSP
        model.addAttribute("pendingCount", pendingCount);
        model.addAttribute("approvedCount", approvedCount);
        model.addAttribute("rejectedCount", rejectedCount);

        // Return the view to render
        return "financialanalysis";
    }
}
