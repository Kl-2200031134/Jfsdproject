package com.klef.sdp.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.sdp.springboot.model.Borrower;
@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Integer>
{

  @Query("select b from Borrower b  where b.email=?1 and b.password=?2")
  public Borrower checkBorrowerLogin(String email,String Password);
  
}
 
