package com.klef.sdp.springboot.repository;

import com.klef.sdp.springboot.model.Lender;
import com.klef.sdp.springboot.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LenderRepository extends JpaRepository<Lender, Integer> {

    // Existing query for checking lender login
    @Query("SELECT l FROM Lender l WHERE l.email = ?1 AND l.password = ?2")
    Lender checkLenderLogin(String email, String password);

    // Retrieve all loans by a specific lender ID
    @Query("SELECT loan FROM Loan loan WHERE loan.lender.id = ?1")
    List<Loan> findLoansByLenderId(int lenderId);
}
