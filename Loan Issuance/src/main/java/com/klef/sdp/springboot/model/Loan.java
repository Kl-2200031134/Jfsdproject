package com.klef.sdp.springboot.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY) // Maps loan to lender
    @JoinColumn(name = "lender_id", nullable = false)
    private Lender lender;

    @ManyToOne(fetch = FetchType.LAZY) // Maps loan to borrower
    @JoinColumn(name = "borrower_id", nullable = false)
    private Borrower borrower;

    @Column(name = "loan_amount", nullable = false)
    private double loanAmount;

    @Column(name = "interest_rate", nullable = false)
    private double interestRate;

    @Column(name = "loan_term", nullable = false) // Duration in months
    private int loanTerm;

    @Column(name = "loan_status", nullable = false) // e.g., Pending, Approved, Rejected
    private String loanStatus;

    @Column(name = "interest_type", nullable = false) // e.g., Simple, Compound
    private String interestType;

    @Column(name = "start_date", nullable = false) // The loan start date for analysis
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false) // The loan end date for analysis
    private LocalDate endDate;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Lender getLender() {
        return lender;
    }

    public void setLender(Lender lender) {
        this.lender = lender;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }

    public String getInterestType() {
        return interestType;
    }

    public void setInterestType(String interestType) {
        this.interestType = interestType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    // Optionally, add utility methods (like for calculating interest) if required by financial analysis
}
