package com.klef.sdp.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.sdp.springboot.model.FinancialAnalyst;
@Repository
public interface FinancialAnalystRepository extends JpaRepository<FinancialAnalyst, Integer> {

}
