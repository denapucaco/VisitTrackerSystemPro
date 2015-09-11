package com.sparsh.tracker.visit.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sparsh.tracker.visit.domain.Department;
import com.sparsh.tracker.visit.domain.Employee;
import com.sparsh.tracker.visit.domain.Login;
import com.sparsh.tracker.visit.service.DepartmentService;
import com.sparsh.tracker.visit.service.EmployeeService;
import com.sparsh.tracker.visit.service.LoginService;
import com.sparsh.tracker.visit.util.Date;
import com.sparsh.tracker.visit.util.NotificationService;
import com.sparsh.tracker.visit.util.PasswordGenerator;
/**
 * 
 * @author Prashant Swamy
 * @created on 18/12/2012
 */
@Controller
@RequestMapping(value="/admin")
public class AddEmployeeController {

	private static final Logger LOGGER = Logger.getLogger(AddEmployeeController.class);
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private NotificationService notificationService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="addemployee",method=RequestMethod.GET)
	public String showAddEmployee(Map<String, Object> model) {
		
		LOGGER.info("/admin/addemployee");
		Employee employee = new Employee();
		model.put("employee", employee);
		return "create_employee";
	}
	
	@RequestMapping(value="addemployeeconfirm", method=RequestMethod.POST)
	public String confirmAddedEmployee(@ModelAttribute("SpringWeb")Employee employee, Map<String, Object> model, BindingResult result) {
		try {
			LOGGER.info("/employee/confirmcreate");

			employee.setStatus(EmployeeService.STATUS_ACTIVE);
			employee.setDepartment(new Department("Offshore Development Team India"));
			
			Login login = new Login();
			login.setEmployee(employee);
			
			String email = employee.getEmail();
			int index = email.indexOf("@gmail.com");

			String userName = email.substring(0, index);
			login.setUserName(userName);

			model.put("login", login);
			return "create_employee_confirm";
		} catch (Exception e) {
			e.printStackTrace();
			model.put("error_message", "Service not available. Please try after some time.");
			return "error";
		}
	}
	
	@RequestMapping(value = "/addemployeesuccess", method = RequestMethod.POST)
	@Transactional
	public String addSuccess(@ModelAttribute("SpringWeb")Login login, Map<String, Object> model) {
		try {
			
			Department department = departmentService.findById(1);
			
			Employee employee = login.getEmployee();
			employee.setStatus(EmployeeService.STATUS_ACTIVE);
			employee.setDepartment(department);
			
			LOGGER.info("/employee/addemployeesuccess");
			String randomPassword = PasswordGenerator.generate();
			String hashedPassword = passwordEncoder.encodePassword(randomPassword, null);
			
			login.setPassword(hashedPassword);
			login.setAccess(LoginService.ACCESS_USER);
			
			login.setAccountNonExpired(true);
			login.setAccountNotLocked(true);
			login.setCredentialsNonExpired(true);
			login.setEnabled(true);
			
			Map emailMap = new HashMap<String, String>();
			emailMap.put("userName", login.getUserName());
			emailMap.put("password", randomPassword);
			emailMap.put("email", employee.getEmail());
			emailMap.put("firstName", employee.getFirstName());
			emailMap.put("lastName", employee.getLastName());
			notificationService.sendConfirmationEmail(emailMap);
//			notificationService.sendConfirmationEmail(login);

			employeeService.create(employee);
			loginService.create(login);
			
			model.put("message", "Employee added successfully!");
			return "add_success";
		} catch (Exception e) {
			e.printStackTrace();
			model.put("error_message", "Service not available. Please try after some time.");
			return "error";
		}
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}