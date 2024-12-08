package com.klef.sdp.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.sdp.springboot.model.Admin;
import com.klef.sdp.springboot.model.Borrower;
import com.klef.sdp.springboot.repository.AdminRepository;
import com.klef.sdp.springboot.repository.BorrowerRepository;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
   private BorrowerRepository borrowerRepository;
	@Override
	public List<Borrower> viewAllBorrowers() {
		
		return borrowerRepository.findAll();
	}
	@Override
	public Admin checkAdminLogin(String uname, String pwd) {
		return adminRepository.checkAdminLogin(uname, pwd);
	}
	@Override
	public long borrowercount() {
		return borrowerRepository.count();
	}


}
