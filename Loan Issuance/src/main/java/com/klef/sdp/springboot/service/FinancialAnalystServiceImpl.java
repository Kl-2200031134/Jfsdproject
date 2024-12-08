package com.klef.sdp.springboot.service;

import org.springframework.stereotype.Service;

import com.klef.sdp.springboot.model.FinancialAnalyst;
import com.klef.sdp.springboot.repository.FinancialAnalystRepository;

@Service
public class FinancialAnalystServiceImpl implements FinancialAnalystService {
	private FinancialAnalystRepository analystRepository;
	@Override
	public String analystRegistration(FinancialAnalyst analyst) {
		analystRepository.save(analyst);
		return " Analyst Registered successfully"; 
	}

}
