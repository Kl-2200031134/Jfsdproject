package com.klef.sdp.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.klef.sdp.springboot.model.Admin;
import com.klef.sdp.springboot.model.Borrower;

@Service
public interface AdminService {
	public List<Borrower> viewAllBorrowers();
	public Admin checkAdminLogin(String uname,String pwd);
	public long borrowercount();
}
