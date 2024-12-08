package com.klef.sdp.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.sdp.springboot.model.Lender;
import com.klef.sdp.springboot.model.Loan;
import com.klef.sdp.springboot.repository.LenderRepository;
import com.klef.sdp.springboot.repository.LoanRepository;

import java.util.List;

@Service
public class LenderServiceImpl implements LenderService {

    @Autowired
    private LenderRepository lenderRepository;

    @Autowired
    private LoanRepository loanRepository;

    // Existing functionality: Register a new lender
    @Override
    public String lenderRegistration(Lender lender) {
        lenderRepository.save(lender);  // Save the lender to the database
        return "Lender Registered Successfully";
    }

    // Existing functionality: Check lender login credentials
    @Override
    public Lender checkLenderLogin(String email, String password) {
        return lenderRepository.checkLenderLogin(email, password);  // Fetch lender by email and password
    }

    // New functionality: Create a loan offer
    public String createLoanOffer(Loan loan) {
        loanRepository.save(loan);  // Save the loan to the database
        return "Loan offer created successfully";
    }

    // New functionality: View all loans by lender
    public List<Loan> getLoansByLender(int lenderId) {
        return loanRepository.findByLenderId(lenderId);  // Fetch all loans associated with the lender
    }

    // New functionality: Calculate simple interest
    public double calculateSimpleInterest(double principal, double rate, int time) {
        return (principal * rate * time) / 100;  // Simple interest formula
    }

    // New functionality: Calculate compound interest
    public double calculateCompoundInterest(double principal, double rate, int time) {
        return principal * Math.pow((1 + rate / 100), time) - principal;  // Compound interest formula
    }

	@Override
	public Lender findLenderById(Integer lenderId) {
		// TODO Auto-generated method stub
		return null;
	}
}
