package com.klef.sdp.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam; // Fix for @RequestParam
import org.springframework.ui.Model;                      // Fix for Model
import java.time.LocalDate;                               // Fix for LocalDate
import java.time.format.DateTimeFormatter;

import com.klef.sdp.springboot.model.Borrower;
import com.klef.sdp.springboot.model.Lender;
import com.klef.sdp.springboot.model.Loan;
import com.klef.sdp.springboot.service.LoanService;  // Ensure this import
import com.klef.sdp.springboot.service.BorrowerService;
import com.klef.sdp.springboot.service.LenderService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class BorrowerController {

    @Autowired
    private BorrowerService borrowerService;
    
    @Autowired
    private LoanService loanService;  // Autowire LoanService
    @Autowired
    private LenderService lenderService; // Ensure this is declared correctly


    @GetMapping("/borrower")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        return mv;
    }

    @GetMapping("borrowerreg")
    public ModelAndView borrowerreg() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("borrowerreg");
        return mv;
    }

    @GetMapping("borrowerlogin")
    public ModelAndView borrowerlogin() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("borrowerlogin");
        return mv;
    }

    @GetMapping("borrowerprofile")
    public ModelAndView borrowerprofile() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("borrowerprofile");
        return mv;
    }

    @GetMapping("borrowerhome")
    public ModelAndView borrowerhome() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("borrowerhome");
        return mv;
    }

    @GetMapping("borrowerlogout")
    public ModelAndView borrowerlogout() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("borrowerlogin");
        return mv;
    }

    @PostMapping("insertborrower")
    public ModelAndView insertborrower(HttpServletRequest request) {
        String name = request.getParameter("bname");
        String gender = request.getParameter("bgender");
        String dob = request.getParameter("bdob");
        String email = request.getParameter("bemail");
        String password = request.getParameter("bpwd");
        String location = request.getParameter("blocation");
        String contact = request.getParameter("bcontact");

        // Retrieve annualIncome and monthlyExpenses as optional fields
        String annualIncomeStr = request.getParameter("annual_income");
        String monthlyExpensesStr = request.getParameter("monthly_expenses");

        Borrower borrower = new Borrower();
        borrower.setName(name);
        borrower.setGender(gender);
        borrower.setDateofbirth(dob);
        borrower.setEmail(email);
        borrower.setPassword(password);
        borrower.setLocation(location);
        borrower.setContact(contact);

        // Set annualIncome and monthlyExpenses if they are provided
        if (annualIncomeStr != null && !annualIncomeStr.isEmpty()) {
            borrower.setAnnualIncome(Double.parseDouble(annualIncomeStr));
        }
        if (monthlyExpensesStr != null && !monthlyExpensesStr.isEmpty()) {
            borrower.setMonthlyExpenses(Double.parseDouble(monthlyExpensesStr));
        }

        String message = borrowerService.borrowerRegistration(borrower);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("regsuccess");
        mv.addObject("message", message);
        return mv;
    }

    @PostMapping("checkborrowerlogin")
    public ModelAndView checkborrowerlogin(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String bemail = request.getParameter("bemail");
        String bpwd = request.getParameter("bpwd");

        Borrower borrower = borrowerService.checkBorrowerLogin(bemail, bpwd);

        if (borrower != null) {
            HttpSession session = request.getSession();
            session.setAttribute("borrower", borrower);
            mv.setViewName("borrowerhome");
        } else {
            mv.setViewName("borrowerlogin");
            mv.addObject("message", "Login Failed");
        }
        return mv;
    }

    @RequestMapping(value = "/applyloan", method = { RequestMethod.GET, RequestMethod.POST })
    public String applyLoanForm(
            @RequestParam(value = "loanAmount", required = false) Double loanAmount,
            @RequestParam(value = "interestRate", required = false) Double interestRate,
            @RequestParam(value = "loanTerm", required = false) Integer loanTerm,
            @RequestParam(value = "interestType", required = false) String interestType,
            @RequestParam(value = "startDate", required = false) String startDateStr,
            @RequestParam(value = "endDate", required = false) String endDateStr,
            HttpSession session,
            Model model) {

        if (loanAmount == null || interestRate == null || loanTerm == null || interestType == null || startDateStr == null || endDateStr == null) {
            // If it's a GET request, show the application form
            return "applyloan"; // Return the loan application form (applyloan.jsp)
        }

        try {
            // Retrieve the borrower from the session
            Borrower borrower = (Borrower) session.getAttribute("borrower");
            if (borrower == null) {
                model.addAttribute("error", "You must be logged in to apply for a loan.");
                return "borrowerlogin"; // Redirect to login page if no borrower session found
            }

            // Retrieve a Lender object (replace with your logic to fetch the lender)
            Lender lender = lenderService.checkLenderLogin("Sri@gmail.com", "Sri@123"); // Replace with valid credentials
            if (lender == null) {
                model.addAttribute("error", "No lender is available to process the loan.");
                return "applyloan"; // Redirect back if no lender is found
            }

            // Parse the startDate and endDate
         // Parse the startDate and endDate using the correct date format
            LocalDate startDate = LocalDate.parse(startDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate endDate = LocalDate.parse(endDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));


            // Create the Loan object and set its properties
            Loan loan = new Loan();
            loan.setLoanAmount(loanAmount);
            loan.setInterestRate(interestRate);
            loan.setLoanTerm(loanTerm);
            loan.setInterestType(interestType);
            loan.setStartDate(startDate);
            loan.setEndDate(endDate);
            loan.setLoanStatus("Pending"); // Default loan status
            //loan.setBorrower(borrower); // Associate the loan with the logged-in borrower
            loan.setLender(lender); // Associate the loan with the lender

            // Save the loan using the LoanService
            loanService.saveLoan(loan);

            // Add success message to the model
            model.addAttribute("message", "Loan application submitted successfully!");
            return "successPage"; // Redirect to success page after submission

        } catch (Exception e) {
            // If there is any error, return to the form with an error message
            model.addAttribute("error", "Error: " + e.getMessage());
            return "applyloan"; // Return to the loan application form if error occurs
        }
    }
}