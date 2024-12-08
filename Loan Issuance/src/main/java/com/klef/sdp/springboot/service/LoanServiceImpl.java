package com.klef.sdp.springboot.service;

import com.klef.sdp.springboot.model.Loan;
import com.klef.sdp.springboot.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public String createLoan(Loan loan) {
        // Save loan data to the database (Create operation)
        loanRepository.save(loan);
        return "Loan offer created successfully!";
    }

    @Override
    public List<Loan> getLoansByLenderId(int lenderId) {
        // Fetch loans associated with a particular lender ID
        return loanRepository.findByLenderId(lenderId);
    }

    @Override
    public Loan getLoanById(int loanId) {
        // Retrieve a specific loan by its ID
        return loanRepository.findById(loanId).orElse(null);
    }

    @Override
    public double calculateSimpleInterest(double principal, double rate, int tenure) {
        // Simple Interest formula: (Principal * Rate * Time) / 100
        return (principal * rate * tenure) / 100.0;
    }

    @Override
    public double calculateCompoundInterest(double principal, double rate, int tenure) {
        // Compound Interest formula: Principal * (1 + Rate/100) ^ Time
        return principal * Math.pow((1 + rate / 100), tenure) - principal;
    }

    @Override
    public String applyForLoan(Loan loan) {
        // Here, you can add the logic for loan application, such as validation or any business rules
        loan.setLoanStatus("Pending");  // Set the loan status to Pending when applying
        loanRepository.save(loan);
        return "Loan application submitted successfully!";
    }

    @Override
    public void saveLoan(Loan loan) {
        // Save or update the loan data (depending on the presence of the loan ID)
        loanRepository.save(loan);
    }

    // New method to fetch all loans
    @Override
    public List<Loan> getAllLoans() {
        // Retrieve all loans from the database
        return loanRepository.findAll();
    }

    // New method to count loans by their status
    @Override
    public long getLoanCountByStatus(String status) {
        // Count the number of loans with a given status
        return loanRepository.countByLoanStatus(status);
    }
}
