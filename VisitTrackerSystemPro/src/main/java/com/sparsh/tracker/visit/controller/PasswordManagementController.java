package com.sparsh.tracker.visit.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sparsh.tracker.visit.domain.Employee;
import com.sparsh.tracker.visit.domain.Login;
import com.sparsh.tracker.visit.service.LoginService;
import com.sparsh.tracker.visit.util.NotificationService;
import com.sparsh.tracker.visit.util.PasswordGenerator;

/**
 * 
 * @author Prashant Swamy
 * @created on 10/12/2012
 */
@Controller
@RequestMapping("/auth")
public class PasswordManagementController {

	private static final Logger LOGGER = Logger.getLogger(PasswordManagementController.class);
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private NotificationService notificationService;
	
	@RequestMapping(value = "/changepassword", method=RequestMethod.GET)
	public String showChangePassword(Map<String, Object> model, HttpSession session) {
		LOGGER.info("/auth/changepassword");
		Login login = (Login) session.getAttribute("login");
		if(login==null) {
			return "redirect:/auth/login.do";
		}
		model.put("login", login);
		return "change_password";
	}
	
	@RequestMapping(value = "/changepasswordsuccess", method = RequestMethod.POST)
	@Transactional
	public String changePasswordSuccess(@ModelAttribute("SpringWeb")Login login, Map<String, Object> model, HttpSession session) {
		try {
			LOGGER.info("/employee/addemployeesuccess");

			Login sessionLogin = (Login) session.getAttribute("login");
			if(sessionLogin==null) {
				return "redirect:/auth/login.do";
			}
			
			String password = login.getPassword();
			int inddex = password.indexOf(",");
			String newPassword = password.substring(0,inddex);
			String confirmPassword = password.substring(inddex+1,password.length());
			
			if(!newPassword.equals(confirmPassword)) {
				model.put("error_message", "Passwords do not match. Please try again.");
				return "error";
			}
			
			String hashedPassword = passwordEncoder.encodePassword(newPassword, null);
			sessionLogin.setPassword(hashedPassword);
			loginService.create(sessionLogin);
			
			model.put("message", "Password Changed Successfully!");
			return "add_success";
		} catch (Exception e) {
			e.printStackTrace();
			model.put("error_message", "Service not available. Please try after some time.");
			return "error";
		}
	}


	@RequestMapping(value = "/forgotpassword", method=RequestMethod.GET)
	public String showForgotPassword(Map<String, Object> model, HttpSession session) {
		LOGGER.info("/auth/forgotpassword");
		model.put("login", new Login());
		return "forgot_password";
	}
	
	@RequestMapping(value = "/forgotpasswordsuccess", method = RequestMethod.POST)
	@Transactional
	public String forgotPasswordSuccess(@ModelAttribute("SpringWeb")Login login, Map<String, Object> model, HttpSession session) {
		try {
			LOGGER.info("/auth/forgotpasswordsuccess");

			Login dbLogin = loginService.findByUserName(login.getUserName());
			if(dbLogin == null) {
				model.put("error_message", "Can not reset the password for "+login.getUserName());
				return "error";
			}
			
			String randomPassword = PasswordGenerator.generate();
			String hashedPassword = passwordEncoder.encodePassword(randomPassword, null);
			
			dbLogin.setPassword(hashedPassword);
			
			Map emailMap = new HashMap<String, String>();
			emailMap.put("userName", login.getUserName());
			emailMap.put("password", randomPassword);
			emailMap.put("email", dbLogin.getEmployee().getEmail());
			emailMap.put("firstName", dbLogin.getEmployee().getFirstName());
			emailMap.put("lastName", dbLogin.getEmployee().getLastName());
			
			// First Save in DB.. then Send Notification
			loginService.create(dbLogin);
			
			notificationService.sendResetPasswordEmail(emailMap);
			
			model.put("message", "We've sent password reset instructions to your email address.<BR>If you don't receive instructions within a minute or two, check your email's spam and junk filters, or try resending your request.");
			return "add_success";

		} catch (Exception e) {
			e.printStackTrace();
			model.put("error_message", "Service not available. Please try after some time.");
			return "error";
		}
	}


}