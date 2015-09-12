package com.sparsh.tracker.visit.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sparsh.tracker.visit.domain.Employee;
import com.sparsh.tracker.visit.domain.Login;
import com.sparsh.tracker.visit.domain.Visit;
import com.sparsh.tracker.visit.service.VisitService;

/**
 * 
 * @author Prashant Swamy
 * @created on 11/12/2012
 */
@Controller
@RequestMapping(value = "/employee")
public class ManageVisitsController {

    private static final Logger LOGGER = Logger.getLogger(ManageVisitsController.class);

    @Autowired
    private VisitService visitService;

    // @Autowired
    // private EmployeeService employeeService;

    @RequestMapping(value = "/showvisitstomanage", method = RequestMethod.GET)
    public String showVisitsToConfirm(final Map<String, Object> model, final HttpSession session) {
        try {

            Login login = (Login) session.getAttribute("login");
            if (login == null || login.getUserName().equals("")) {
                return "redirect:/auth/login.do";
            }

            Employee employee = login.getEmployee();
            if (employee == null) {
                model.put("error_message", "Employee not found");
                return "error";
            }

            // Date today = new com.sparsh.tracker.visit.util.Date().getBeginningOfDay().asUtilDate();
            List nonConfirmedVisitList = visitService.getNonConfirmedVisitsForEmployee(employee.getEmployeeNumber());
            List cancellableVisitList = visitService.getCancellableVisitsForEmployee(employee.getEmployeeNumber());

            if ((nonConfirmedVisitList == null || nonConfirmedVisitList.size() < 1)
                    && (cancellableVisitList == null || cancellableVisitList.size() < 1)) {
                model.put("message", "No Records found!");
                return "add_success";
            }

            if (nonConfirmedVisitList == null || nonConfirmedVisitList.size() < 1) {
                model.put("visitList", cancellableVisitList);
                return "list_visits_to_confirm";
            }

            if (cancellableVisitList == null || cancellableVisitList.size() < 1) {
                model.put("visitList", nonConfirmedVisitList);
                model.put("userName", login.getUserName());
                return "list_visits_to_confirm";
            }

            // Both List contain values
            nonConfirmedVisitList.addAll(cancellableVisitList);

            model.put("visitList", nonConfirmedVisitList);
            // model.put("userName", login.getUserName());
            return "list_visits_to_confirm";
        } catch (Exception e) {
            e.printStackTrace();
            model.put("error_message", "Service not available. Please try after some time.");
            return "error";
        }
    }

    @RequestMapping(value = "/visit_to_confirm", method = RequestMethod.GET)
    public String visitToConfirm(@RequestParam(value = "visitId") final String visitId, final Map<String, Object> model) {
        try {
            Integer visitOID = Integer.valueOf(visitId);
            Visit visit = visitService.findById(visitOID);
            visit.setIsConfirmed(true);
            visitService.create(visit);

            model.put("message", "Visit Confirmed!");
            return "add_success";
        } catch (Exception e) {
            e.printStackTrace();
            model.put("error_message", "Service not available. Please try after some time.");
            return "error";
        }
    }

    @RequestMapping(value = "/visit_to_cancel", method = RequestMethod.GET)
    public String visitToCancel(@RequestParam(value = "visitId") final String visitId, final Map<String, Object> model,
            final HttpSession session) {
        try {
            Login login = (Login) session.getAttribute("login");
            if (login == null || login.getUserName().equals("")) {
                return "redirect:/auth/login.do";
            }

            Integer visitOID = Integer.valueOf(visitId);
            Visit visit = visitService.findById(visitOID);
            visit.setIsCanceled(true);
            visitService.create(visit);

            model.put("message", "Visit Canceled!");
            return "add_success";
        } catch (Exception e) {
            e.printStackTrace();
            model.put("error_message", "Service not available. Please try after some time.");
            return "error";
        }
    }
}
