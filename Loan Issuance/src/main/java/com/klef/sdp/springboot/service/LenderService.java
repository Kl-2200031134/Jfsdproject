package com.klef.sdp.springboot.service;

import com.klef.sdp.springboot.model.Lender;
import com.klef.sdp.springboot.model.Loan;

import java.util.List;

public interface LenderService {
    // Existing methods
    String lenderRegistration(Lender lender);
    Lender checkLenderLogin(String email, String password);

    // New methods
    String createLoanOffer(Loan loan);
    List<Loan> getLoansByLender(int lenderId);
    double calculateSimpleInterest(double principal, double rate, int time);
    double calculateCompoundInterest(double principal, double rate, int time);

    // Add this method for finding a lender by ID
    Lender findLenderById(Integer lenderId);
}
