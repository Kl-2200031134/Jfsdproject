package com.klef.sdp.springboot.service;

import org.springframework.stereotype.Service;

import com.klef.sdp.springboot.model.Borrower;
@Service
public interface BorrowerService 
{
	public String borrowerRegistration(Borrower borrower);
	public Borrower checkBorrowerLogin(String email,String Password);
}
