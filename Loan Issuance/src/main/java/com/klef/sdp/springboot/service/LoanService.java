package com.klef.sdp.springboot.service;

import com.klef.sdp.springboot.model.Loan;
import java.util.List;

public interface LoanService {
    // Method to create a loan offer
    String createLoan(Loan loan);

    // Method to get loans by lender ID
    List<Loan> getLoansByLenderId(int lenderId);

    // Method to get a loan by its ID
    Loan getLoanById(int loanId);

    // Additional methods for interest calculation (Optional, if needed)
    double calculateSimpleInterest(double principal, double rate, int tenure);
    double calculateCompoundInterest(double principal, double rate, int tenure);

    // Method for applying for a loan
    String applyForLoan(Loan loan);

    // Method for saving a loan (when updating or adding a loan)
    void saveLoan(Loan loan);

    // New methods to be added
    List<Loan> getAllLoans(); // Method to fetch all loans
    long getLoanCountByStatus(String status); // Method to count loans by status
}
