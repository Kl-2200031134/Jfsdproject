package com.klef.sdp.springboot.controller;

import com.klef.sdp.springboot.model.Lender;
import com.klef.sdp.springboot.model.Loan;
import com.klef.sdp.springboot.service.LenderService;
import com.klef.sdp.springboot.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LenderController {

    @Autowired
    private LenderService lenderService;

    @Autowired
    private LoanService loanService;

    // Home page
    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        return mv;
    }

    // Lender Registration Page
    @RequestMapping("lenderregister")
    public ModelAndView lenderreg() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("lenderregister");
        return mv;
    }

    // Lender Login Page
    @RequestMapping("lenderlogin")
    public ModelAndView lenderlogin() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("lenderlogin");
        return mv;
    }

    // Lender Profile Page
    @RequestMapping("lenderprofile")
    public ModelAndView lenderprofile() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("lenderprofile");
        return mv;
    }

    // Lender Home Page
    @RequestMapping("lender")
    public ModelAndView lenderhome() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("lenderhome");
        return mv;
    }

    // Lender Logout
    @RequestMapping("lenderlogout")
    public ModelAndView lenderlogout() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("lenderlogin");
        return mv;
    }

    // Lender Registration Process
    @RequestMapping(value = "insertlender", method = RequestMethod.POST)
    public ModelAndView insertlender(HttpServletRequest request) {
        // Capturing the form fields
        String name = request.getParameter("lname");
        String gender = request.getParameter("lgender");
        String dob = request.getParameter("ldob");
        String email = request.getParameter("lemail");
        String password = request.getParameter("lpwd");
        String location = request.getParameter("llocation");
        String contact = request.getParameter("lcontact");
        String interestRate = request.getParameter("default_interest_rate");
        String loanType = request.getParameter("loanType");

        // Create a new Lender object and set the captured data
        Lender lender = new Lender();
        lender.setName(name);
        lender.setGender(gender);
        lender.setDateOfBirth(dob);
        lender.setEmail(email);
        lender.setPassword(password);
        lender.setLocation(location);
        lender.setContact(contact);
        lender.setInterestRate(Double.parseDouble(interestRate));
        lender.setLoanType(loanType);

        // Calling the service to register the lender
        String message = lenderService.lenderRegistration(lender);

        // Preparing the response view
        ModelAndView mv = new ModelAndView();
        mv.setViewName("regsuccess");
        mv.addObject("message", message);
        return mv;
    }

    // Check Lender Login
    @RequestMapping(value = "checklenderlogin", method = RequestMethod.POST)
    public ModelAndView checklenderlogin(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String lemail = request.getParameter("lemail");
        String lpwd = request.getParameter("lpwd");

        Lender lender = lenderService.checkLenderLogin(lemail, lpwd);

        if (lender != null) {
            HttpSession session = request.getSession();
            session.setAttribute("lender", lender);
            mv.setViewName("lenderdashboard");
        } else {
            mv.setViewName("lenderlogin");
            mv.addObject("message", "Login Failed");
        }

        return mv;
    }

    // Lender Offers Loan
    @RequestMapping(value = "offerloan", method = RequestMethod.GET)
    public ModelAndView offerLoanPage(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        Lender lender = (Lender) session.getAttribute("lender");

        if (lender == null) {
            mv.setViewName("lenderlogin");
            mv.addObject("message", "Please login first.");
        } else {
            mv.setViewName("offerloan");
        }
        return mv;
    }

    // Lender Offers Loan Process
    @RequestMapping(value = "offerloan", method = RequestMethod.POST)
    public ModelAndView offerLoan(HttpServletRequest request, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        Lender lender = (Lender) session.getAttribute("lender");

        if (lender == null) {
            mv.setViewName("lenderlogin");
            mv.addObject("message", "Please login first.");
            return mv;
        }

        double loanAmount = Double.parseDouble(request.getParameter("amount"));
        double interestRate = Double.parseDouble(request.getParameter("rate"));
        int tenure = Integer.parseInt(request.getParameter("tenure"));
        String interestType = request.getParameter("interestType");

        Loan loan = new Loan();
        loan.setLoanAmount(loanAmount);
        loan.setInterestRate(interestRate);
        loan.setLoanTerm(tenure);
        loan.setInterestType(interestType);
        loan.setLender(lender);

        loanService.createLoan(loan);

        mv.setViewName("loansuccess");
        mv.addObject("message", "Loan offered successfully!");
        return mv;
    }

    // View All Loans by Lender (including Borrower Name, Loan Status, and Action)
    @RequestMapping(value = "viewloans", method = RequestMethod.GET)
    public ModelAndView viewBorrowerLoans(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        Lender lender = (Lender) session.getAttribute("lender");

        if (lender == null) {
            mv.setViewName("lenderlogin");
            mv.addObject("message", "Please login first.");
            return mv;
        }

        // Fetch all loans related to the lender
        List<Loan> loans = loanService.getLoansByLenderId(lender.getId());
        mv.setViewName("viewloans");
        mv.addObject("loans", loans);

        return mv;
    }

    // Approve Loan
    @RequestMapping(value = "/approveLoan", method = RequestMethod.POST)
    public String approveLoan(@RequestParam("loanId") int loanId) {
        Loan loan = loanService.getLoanById(loanId);
        if (loan != null) {
            loan.setLoanStatus("Approved");
            loanService.saveLoan(loan);
        }
        return "redirect:viewloans";
    }

    // Reject Loan
    @RequestMapping(value = "/rejectLoan", method = RequestMethod.POST)
    public String rejectLoan(@RequestParam("loanId") int loanId) {
        Loan loan = loanService.getLoanById(loanId);
        if (loan != null) {
            loan.setLoanStatus("Rejected");
            loanService.saveLoan(loan);
        }
        return "redirect:viewloans";
    }

    // Lender Dashboard
    @RequestMapping(value = "lenderdashboard", method = RequestMethod.GET)
    public ModelAndView lenderDashboard(HttpSession session) {
        ModelAndView mv = new ModelAndView();

        Lender lender = (Lender) session.getAttribute("lender");

        if (lender == null) {
            mv.setViewName("lenderlogin");
            mv.addObject("message", "Please login first.");
            return mv;
        }

        List<Loan> loans = loanService.getLoansByLenderId(lender.getId());

        mv.setViewName("lenderdashboard");
        mv.addObject("lender", lender);
        mv.addObject("loans", loans);

        return mv;
    }
}
