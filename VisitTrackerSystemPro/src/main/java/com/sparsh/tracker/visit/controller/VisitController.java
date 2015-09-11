//package com.sparsh.tracker.visit.controller;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.propertyeditors.CustomDateEditor;
//import org.springframework.beans.propertyeditors.StringTrimmerEditor;
//import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.sparsh.tracker.visit.domain.Employee;
//import com.sparsh.tracker.visit.domain.Visit;
//import com.sparsh.tracker.visit.service.EmployeeService;
//import com.sparsh.tracker.visit.service.VisitService;
//
///**
// * 
// * @author Prashant Swamy
// * @created on 02/09/2012
// */
//@Controller
//public class VisitController {
//
//	private static final Logger LOGGER = Logger.getLogger(VisitController.class);
//	
//	@Autowired
//	private VisitService visitService;
//
//	@Autowired
//	private EmployeeService employeeService;
//
//	@RequestMapping("/index")
//	public String listVisitors(Map<String, Object> model) {
//
//		try {
//			model.put("visit", new Visit());
//			Date today = new com.sparsh.tracker.visit.util.Date().getBeginningOfDay().asUtilDate();
//			
//			List visitList = visitService.getVisits(today);
//			if(visitList==null || visitList.size() < 1){
//				model.put("message", "No Records found!");
//				return "add_success";
//			}
//			model.put("visitList", visitList);
//			return "list_visits";
//		} catch (Exception e) {
//			e.printStackTrace();
//			LOGGER.error(e.getMessage()+" "+e.getCause());
//			model.put("error_message", "Service not available. Please try after some time.");
//			return "error";
//		}
//	}
//
//	@RequestMapping("/employee")
//	public String searchEmployee(Map<String, Object> map) {
//		Employee employee = new Employee();
//		map.put("employee", employee);
//		return "search_employee";
//	}
//
//	@RequestMapping("/create")
//	public String createVisit(@ModelAttribute("SpringWeb")Employee emp, BindingResult result, Map<String, Object> model) {
//		try {
//			Integer empNumber = emp.getEmployeeNumber();
//			/*new EmployeeValidator().validate(emp, result);
//			if (result.hasErrors()) {
//				Employee employee = new Employee();
//				model.put("employee", employee);
//				return "search_employee";
//			}*/
//			
//			Employee employee = employeeService.findByEmployeeNumber(empNumber);
//			if(employee==null) {
//				model.put("error_message", "Employee not found for "+empNumber);
//				return "error";
//			}
//			Visit visit = new Visit();
//			visit.setEmployee(employee);
//
//			visit.setCreatedOn(new Date());
//			model.put("visit", visit);
//			return "create_visit";
//		} catch (Exception e) {
//			e.printStackTrace();
//			model.put("error_message", "Service not available. Please try after some time.");
//			return "error";
//		}
//	}
//
//	@RequestMapping(value = "/confirmcreate", method = RequestMethod.POST)
//	public String addVisit(@ModelAttribute("SpringWeb")Visit visit, Map<String, Object> model) {
//		try {
//			//		ApplicationContext context = new ClassPathXmlApplicationContext("visitstrackingsystem-servlet.xml"); 
//			//		PlatformTransactionManager transactionManager = (PlatformTransactionManager) context.getBean("transactionManager");
//			//		TransactionDefinition def = new DefaultTransactionDefinition(); 
//			//		TransactionStatus status = transactionManager.getTransaction(def);
//
//			//		try{
//			//		visitorService.create(visitor);
//			//			transactionManager.commit(status);
//			//		} catch (TransactionException e) {
//			//			e.printStackTrace();
//			//			transactionManager.rollback(status);
//			//		}
//			model.put("visit", visit);
//			return "confirm_create_visit";
//		} catch (Exception e) {
//			e.printStackTrace();
//			model.put("error_message", "Service not available. Please try after some time.");
//			return "error";
//		} 
//	}
//	
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	@RequestMapping(value = "/showvisitstomanage", method = RequestMethod.POST)
//	public String showVisitsToConfirm(@ModelAttribute("SpringWeb")Employee emp, Map<String, Object> model) {
//		try {
//			Integer employeeNumber = emp.getEmployeeNumber();
//			
//			Employee employee = employeeService.findByEmployeeNumber(employeeNumber);
//			if(employee==null) {
//				model.put("error_message", "Employee not found for "+employeeNumber);
//				return "error";
//			}
//			
//			//Date today = new com.sparsh.tracker.visit.util.Date().getBeginningOfDay().asUtilDate();			
//			List nonConfirmedVisitList = visitService.getNonConfirmedVisitsForEmployee(employeeNumber);
//			List cancellableVisitList = visitService.getCancellableVisitsForEmployee(employeeNumber);
//			
//			if( (nonConfirmedVisitList==null || nonConfirmedVisitList.size() < 1) 
//			 && (cancellableVisitList==null || cancellableVisitList.size() < 1) ){
//				model.put("message", "No Records found!");
//				return "add_success";
//			}
//			
//			if(nonConfirmedVisitList==null || nonConfirmedVisitList.size() < 1) {
//				model.put("visitList", cancellableVisitList);
//				return "list_visits_to_confirm";
//			}
//			
//			if(cancellableVisitList==null || cancellableVisitList.size() < 1) {
//				model.put("visitList", nonConfirmedVisitList);
//				return "list_visits_to_confirm";
//			}
//			
//			//Both List contain values
//			nonConfirmedVisitList.addAll(cancellableVisitList);
//			
//			model.put("visitList", nonConfirmedVisitList);
//			return "list_visits_to_confirm";
//		} catch (Exception e) {
//			e.printStackTrace();
//			model.put("error_message", "Service not available. Please try after some time.");
//			return "error";
//		}
//	}
//	
//	@RequestMapping(value="/visit_to_confirm", method = RequestMethod.GET)
//	public String visitToConfirm(@RequestParam(value="visitId") String visitId, Map<String, Object> model) {
//		try{
//			Integer visitOID = Integer.valueOf(visitId);
//			Visit visit = visitService.findById(visitOID);
//			visit.setIsConfirmed(true);
//			visitService.create(visit);
//			
//			model.put("message", "Visit Confirmed!");
//			return "add_success";
//		} catch (Exception e) {
//			e.printStackTrace();
//			model.put("error_message", "Service not available. Please try after some time.");
//			return "error";
//		}
//	}
//	
//	@RequestMapping(value="/visit_to_cancel", method = RequestMethod.GET)
//	public String visitToCancel(@RequestParam(value="visitId") String visitId, Map<String, Object> model) {
//		try{
//			Integer visitOID = Integer.valueOf(visitId);
//			Visit visit = visitService.findById(visitOID);
//			visit.setIsCanceled(true);
//			visitService.create(visit);
//			
//			model.put("message", "Visit Canceled!");
//			return "add_success";
//		} catch (Exception e) {
//			e.printStackTrace();
//			model.put("error_message", "Service not available. Please try after some time.");
//			return "error";
//		}
//	}
//	
//	
//	@RequestMapping(value = "/addsuccess", method = RequestMethod.POST)
//	@Transactional
//	public String addSuccess(@ModelAttribute("SpringWeb")Visit visit, Map<String, Object> model) {
//		try {
//			visit.setIsCanceled(false);
//			visit.setIsConfirmed(false);
//			visit.setCreatedOn(new Date());
//			visitService.create(visit);
//
//			model.put("message", "Visit added successfully!");
//			return "add_success";
//		} catch (Exception e) {
//			e.printStackTrace();
//			model.put("error_message", "Service not available. Please try after some time.");
//			return "error";
//		}
//	}
//
//	@RequestMapping(value = "/get_visitor_name", method = RequestMethod.GET, headers="Accept=*/*")
//	public @ResponseBody List<String> getVisitorNameList(@RequestParam("term") String query) {
//		List<String> visitorNameList = visitService.getVisitorNames(query);
//		return visitorNameList;
//	}
//
//	@RequestMapping(value="/select_visit", method = RequestMethod.GET)
//	public String selectVisit(@RequestParam(value="visitId") String visitId, Map<String, Object> model) {
//		try {
//			Integer visitOID = Integer.valueOf(visitId);
//			Visit visit = visitService.findById(visitOID);
//
//			model.put("visit", visit);
//
//			if(visit.getInTime()==null) {
//				return "in_visit";
//			}
//			else if(visit.getOutTime()==null) {
//				if(visit.getIsConfirmed()==null || !visit.getIsConfirmed()) {
//					model.put("warning", "Visit Not Confirmed!");
//				}
//				else {
//					model.put("warning", "");
//				}
//				
//				long seconds = (new Date().getTime() - visit.getInTime().getTime())/1000;
//				  long days = seconds / (24 * 60 * 60);
//				  long hours = ( seconds / (60 * 60) ) - (days * 24);
//				  long mins = ( seconds / (60 ) ) - (days * 24 * 60) - (hours * 60 );
//				  
//				String dayss = "Days";
//				String hourss = "Hours";
//				String minss = "Mins";
//				
//				boolean dayb = false;
//				boolean hourb = false;
//				boolean minb = false;
//				
//				
//				if(days>0) {
//					dayb = true;
//					if(days==1){
//						dayss = "Day";
//					}
//				}
//				
//				if(hours>0) {
//					hourb = true;
//					if(hours==1){
//						hourss = "Hour";
//					}
//				}
//				
//				if(mins>0) {
//					minb = true;
//					if(mins==1){
//						minss = "Min";
//					}
//				}
//				
//				StringBuffer sb = new StringBuffer();
//				if(dayb) {
//					sb.append(days+" "+dayss);
//				}
//				if(hourb) {
//					sb.append(" " + hours+" "+hourss);
//				}
//				if(minb) {
//					sb.append(" " + mins+" "+minss);
//				}
//				
//				if(sb.toString().equals("")) {
//					sb.append("few Seconds");
//				}
//				visit.setVisitDuration(sb.toString());
//				return "out_visit";
//			}
//			else{
//				model.put("message", "Visitor already out!");
//				return "add_success";
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			model.put("error_message", "Service not available. Please try after some time.");
//			return "error";
//		}
//	}
//
//	@RequestMapping(value = "/in_visit", method = RequestMethod.POST)
//	@Transactional
//	public String invisit(@ModelAttribute("SpringWeb")Visit visit, Map<String, Object> model) {
//		try {
//			Visit dbVisit = visitService.findById(visit.getVisitId());
//			dbVisit.setVehicleNumber(visit.getVehicleNumber());
//			dbVisit.setMaterial(visit.getMaterial());
//			dbVisit.setInTime(new Date());
//
//			visitService.create(dbVisit);
//
//			model.put("message", "In Visit successful!");
//			return "add_success";
//		} catch (Exception e) {
//			e.printStackTrace();
//			model.put("error_message", "Service not available. Please try after some time.");
//			return "error";
//		}
//	}
//
//
//	@RequestMapping(value = "/out_visit", method = RequestMethod.POST)
//	@Transactional
//	public String outvisit(@ModelAttribute("SpringWeb")Visit visit, Map<String, Object> model) {
//		try {
//			Visit dbVisit = visitService.findById(visit.getVisitId());
//
//			dbVisit.setOutTime(new Date());
//			dbVisit.setVisitDuration(visit.getVisitDuration());
//			visitService.create(dbVisit);
//
//			model.put("message", "Out Visit successful!");
//			return "add_success";
//		} catch (Exception e) {
//			e.printStackTrace();
//			model.put("error_message", "Service not available. Please try after some time.");
//			return "error";
//		}
//	}
//	
//	@InitBinder
//	protected void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        dateFormat.setLenient(false);
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
//        binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
//	}
//}