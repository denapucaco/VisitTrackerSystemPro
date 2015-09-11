package com.sparsh.tracker.visit.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.csvreader.CsvReader;
import com.sparsh.tracker.visit.domain.FileUploadForm;
import com.sparsh.tracker.visit.service.DepartmentService;
import com.sparsh.tracker.visit.service.EmployeeService;
import com.sparsh.tracker.visit.service.LoginService;
import com.sparsh.tracker.visit.util.Date;
import com.sparsh.tracker.visit.util.NotificationService;
/**
 * 
 * @author Prashant Swamy
 * @created on 13/1/2013
 */
@Controller
@RequestMapping(value="/admin")
public class FileUploadController {

	private static final Logger LOGGER = Logger.getLogger(FileUploadController.class);

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

	@RequestMapping(value="showupload",method=RequestMethod.GET)
	public String showUploadCSVFile(Map<String, Object> model) {

		LOGGER.info("/admin/showupload");
		FileUploadForm fileUploadForm = new FileUploadForm();
		model.put("FileUploadForm", fileUploadForm);
		return "show_upload";
	}

	@RequestMapping(value = "/saveupload", method = RequestMethod.POST)
	public String saveUploadedCSVFile(@ModelAttribute("uploadForm") FileUploadForm uploadForm, Map<String, Object> model) {

		MultipartFile multipartFile = uploadForm.getFile();

		String fileName = "";
		if(null != multipartFile) {
			fileName = multipartFile.getOriginalFilename();
			try {
				StringBuffer sb = new StringBuffer("C:\\VTS\\in\\");
				sb.append(new Date().asLong());
				sb.append(fileName);

				File destinationFile = new File(sb.toString());
				multipartFile.transferTo(destinationFile);

				CsvReader employees = new CsvReader(sb.toString());
				// employees.readHeaders();

				while (employees.readRecord()) {
					String firstName = employees.get("FirstName");
					String lastName = employees.get("LastName");
					String department = employees.get("Department");
					String mobileNumber = employees.get("MobileNumber");
					String email = employees.get("Email");

					System.out.println(firstName+" "+lastName+" "+department+" "+mobileNumber+" "+email);
				}
				employees.close();
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		model.put("message", fileName +" uploaded successfully!");
		return "add_success";
	}
}