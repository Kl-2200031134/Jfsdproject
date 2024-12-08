package com.klef.sdp.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.sdp.springboot.model.Borrower;
import com.klef.sdp.springboot.repository.BorrowerRepository;
@Service
public class BorrowerServiceImpl  implements BorrowerService{
	@Autowired
    private BorrowerRepository borrowerRepository;
	@Override
	public String borrowerRegistration(Borrower borrower) {

		borrowerRepository.save(borrower);
		return "Borrower Registered Successfully";
	}
	@Override
	public Borrower checkBorrowerLogin(String email, String Password) {
		return borrowerRepository.checkBorrowerLogin(email, Password);
	}
    

}
