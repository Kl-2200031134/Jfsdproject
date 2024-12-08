package com.klef.sdp.springboot.repository;

import com.klef.sdp.springboot.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {

    // Query to retrieve loans by lender ID
    @Query("SELECT l FROM Loan l WHERE l.lender.id = ?1")
    List<Loan> findByLenderId(int lenderId);

    // New query to count loans by their status
    @Query("SELECT COUNT(l) FROM Loan l WHERE l.loanStatus = ?1")
    long countByLoanStatus(String status);

    // Fetch all loans
    List<Loan> findAll();  // JpaRepository already provides this method
}
