package com.sparsh.tracker.visit.controller;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sparsh.tracker.visit.domain.Report;
import com.sparsh.tracker.visit.domain.Visit;
import com.sparsh.tracker.visit.service.VisitService;
import com.sparsh.tracker.visit.util.Date;
import com.sparsh.tracker.visit.validation.ReportValidator;

/**
 * 
 * @author Prashant Swamy
 * @created on 20/09/2012
 * @Modified on 12/12/2012
 */
@Controller
@RequestMapping(value="/admin/report")
public class ReportController {

	private static final Logger LOGGER = Logger.getLogger(ReportController.class);
	
	@Autowired
	private VisitService visitService;
	
	private ReportValidator reportValidator;

	/**
	 * @param reportValidator the reportValidator to set
	 */
	public void setReportValidator(ReportValidator reportValidator) {
		this.reportValidator = reportValidator;
	}

	@RequestMapping(method=RequestMethod.GET)
	public String showReport(Map<String, Object> model) {
		
		LOGGER.info("report/select");
//		ReportForm reportForm = new ReportForm();
//		model.put("reportForm", reportForm);
		Report report = new Report();
		model.put("report", report);
		return "select_report";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String generateReport(@ModelAttribute("SpringWeb")Report report, Map<String, Object> model, BindingResult result) {
		
		reportValidator.validate(report, result);
		if (result.hasErrors()) {
			return "select_report";
		}
		
		try {
			LOGGER.info("report/display");
//			java.util.Date fromDate = new Date(report.getFromDate()).getBeginningOfDay().asUtilDate();
			Date toDate = new Date(report.getToDate()).getEndOfDay();
			
			if(LOGGER.isDebugEnabled()){
				LOGGER.debug("FromDate: "+report.getFromDate()+" To Date: "+toDate);
			}
			Integer employeeNumber = report.getEmployeeNumber();
			String employeeFirstName = report.getEmployeeFirstName();
			String employeeLastName = report.getEmployeeLastName();
			String departmentName = report.getDepartmentName();
			String visitorName = report.getVisitorName();
			String visitorRepresenting = report.getVisitorRepresenting();
			
			String strFromDate = new Date(report.getFromDate()).format(Date.FORMAT_DB);
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT visit FROM Visit visit WHERE ");
			sql.append(" visit.scheduledOn >= '"+ strFromDate +"' AND visit.scheduledOn <= '"+ toDate.format(Date.FORMAT_DB)+"'");
			if(employeeNumber!=null && employeeNumber>0){
				sql.append(" AND visit.employee.employeeNumber = " + employeeNumber);
			}
			if(employeeFirstName!=null && !employeeFirstName.equals("")){
				sql.append(" AND visit.employee.firstName = '" + employeeFirstName +"' ");
			}
			if(employeeLastName!=null && !employeeLastName.equals("")){
				sql.append(" AND visit.employee.lastName = '" + employeeLastName +"' ");
			}
			if(departmentName!=null && !departmentName.equals("")){
				sql.append(" AND visit.employee.department.name = '" + departmentName +"' ");
			}
			if(visitorName!=null && !visitorName.equals("")){
				sql.append(" AND visit.visitorName = '" + visitorName +"' ");
			}
			if(visitorRepresenting!=null && !visitorRepresenting.equals("")){
				sql.append(" AND visit.representing = '" + visitorRepresenting +"' ");
			}
			sql.append(" ORDER BY visit.scheduledOn");
			
			if(LOGGER.isDebugEnabled()){
				LOGGER.debug(sql);
			}
			
			model.put("visit", new Visit());
			List visits = visitService.executeHQLQuery(sql.toString()); 
//			model.put("visitList", visitService.getVistsForDateRange(report.getFromDate(), toDate));
			model.put("visitList", visits);
			
			return "show_report";
			
		}catch (Exception e) {
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