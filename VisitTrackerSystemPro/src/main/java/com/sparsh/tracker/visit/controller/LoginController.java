package com.sparsh.tracker.visit.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @author Prashant Swamy
 * @created on 14/11/2012
 * @Modified on 14/12/2012
 */
@Controller
@RequestMapping("/auth")
public class LoginController {

	private static final Logger LOGGER = Logger.getLogger(LoginController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage(@RequestParam(value="error", required=false) boolean error, ModelMap model) {
		LOGGER.debug("Received request to show login page");

		// Add an error message to the model if login is unsuccessful
		// The 'error' parameter is set to true based on the when the authentication has failed. 
		// We declared this under the authentication-failure-url attribute inside the spring-security.xml
		if (error == true) {
			// Assign an error message
			model.put("error", "You have entered an invalid username or password!");
		} else {
			model.put("error", "");
		}
		return "show_login";
	}
	
	/**
	 * Handles and retrieves the denied JSP page. This is shown whenever a regular user
	 * tries to access an admin only page.
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/denied", method = RequestMethod.GET)
 	public String getDeniedPage() {
		LOGGER.debug("Received request to show denied page");
		return "denied_page";
	}	
	
//	@Autowired
//	private LoginValidator loginValidator;
//	
//	@Autowired
//	private Validator validator;
//	
//	public void setValidator(Validator validator) {
//		this.validator = validator;
//	}
//
//	/**
//	 * @param loginValidator the reportValidator to set
//	 */
//	public void setLoginValidator(LoginValidator loginValidator) {
//		this.loginValidator = loginValidator;
//	}
//	
//	@RequestMapping(method=RequestMethod.GET)
//	public String showLogin(Map<String, Object> model) {
//		try {
////			model.put("warning", "");
//			model.put("login", new Login());
//			return "show_login";
//		} catch (Exception e) {
//			e.printStackTrace();
//			LOGGER.error(e.getMessage()+" "+e.getCause());
//			model.put("error_message", "Service not available. Please try after some time.");
//			return "error";
//		}
//	}
//
//	@RequestMapping(method=RequestMethod.POST)
//	public String doLogin(@Valid Login login, BindingResult result, Map<String, Object> model, HttpServletRequest request) {
//		try {
//			HttpSession session = request.getSession();
//			validator.validate(login, result);
////			loginValidator.validate(login, result);
//			if (result.hasErrors()) {
//				return "show_login";
//			}
//			
//			if(login.getUserName().equals("prash") && login.getPassword().equals("prash")) {
//				session.setAttribute("login", login);
//				return "redirect:/index.do";
//			}
//			model.put("warning", "UserName or Password invalid!");
//			return "show_login";
//		} catch (Exception e) {
//			e.printStackTrace();
//			model.put("error_message", "Service not available. Please try after some time.");
//			return "error";
//		}
//	}
}