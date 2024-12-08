package com.klef.sdp.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.klef.sdp.springboot.service.AdminService;
import com.klef.sdp.springboot.model.Admin;
import com.klef.sdp.springboot.model.Borrower;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Admin Login Page
    @GetMapping("adminlogin")
    public ModelAndView adminlogin() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("adminlogin");
        return mv;
    }

    // Admin Home Page
    @GetMapping("adminhome")
    public ModelAndView adminhome() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("adminhome");
        return mv;
    }

    // Admin Login Authentication
    @PostMapping("checkadminlogin")
    public ModelAndView checkadminlogin(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String auname = request.getParameter("auname");
        String apwd = request.getParameter("apwd");

        Admin admin = adminService.checkAdminLogin(auname, apwd);

        if (admin != null) {
            mv.setViewName("adminhome");
            long count = adminService.borrowercount();
            mv.addObject("count", count);
        } else {
            mv.setViewName("adminloginfail");
            mv.addObject("message", "Login Failed");
        }

        return mv;
    }

    // View All Borrowers
    @GetMapping("viewallborrowers")
    public ModelAndView viewallborrowers() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("viewallborrowers");

        // Fetch total borrowers count
        long count = adminService.borrowercount();
        mv.addObject("count", count);

        // Fetch all borrower details from the database
        List<Borrower> borrowers = adminService.viewAllBorrowers();
        mv.addObject("borrowerlist", borrowers);

        return mv;
    }
}