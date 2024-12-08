package com.klef.sdp.springboot.service;

import org.springframework.stereotype.Service;

import com.klef.sdp.springboot.model.FinancialAnalyst;

@Service
public interface FinancialAnalystService {
	public String analystRegistration(FinancialAnalyst analyst);
}
