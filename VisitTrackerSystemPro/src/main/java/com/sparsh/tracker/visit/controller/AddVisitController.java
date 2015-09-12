package com.sparsh.tracker.visit.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
public class AddVisitController {

    private static final Logger LOGGER = Logger.getLogger(AddVisitController.class);

    @Autowired
    private VisitService visitService;

    // @Autowired
    // private EmployeeService employeeService;

    @RequestMapping(value = "/addvisit", method = RequestMethod.GET)
    public String createVisit(final Map<String, Object> model, final HttpSession session) {
        try {
            LOGGER.info("/employee/addvisit");
            Login login = (Login) session.getAttribute("login");
            if (login == null || login.getUserName().equals("")) {
                return "redirect:/auth/login.do";
            }

            // Employee employee = employeeService.findByEmployeeNumber(empNumber);
            Employee employee = login.getEmployee();
            if (employee == null) {
                model.put("error_message", "Employee not found");
                return "error";
            }
            Visit visit = new Visit();
            visit.setEmployee(employee);

            visit.setCreatedOn(new Date());
            model.put("visit", visit);
            // model.put("userName", login.getUserName());
            return "create_visit";
        } catch (Exception e) {
            e.printStackTrace();
            model.put("error_message", "Service not available. Please try after some time.");
            return "error";
        }
    }

    @RequestMapping(value = "/confirmcreate", method = RequestMethod.POST)
    public String addVisit(@ModelAttribute("SpringWeb") final Visit visit, final Map<String, Object> model) {
        try {
            LOGGER.info("/employee/confirmcreate");

            model.put("visit", visit);
            return "confirm_create_visit";
        } catch (Exception e) {
            e.printStackTrace();
            model.put("error_message", "Service not available. Please try after some time.");
            return "error";
        }
    }

    @RequestMapping(value = "/addsuccess", method = RequestMethod.POST)
    @Transactional
    public String addSuccess(@ModelAttribute("SpringWeb") final Visit visit, final Map<String, Object> model) {
        try {
            LOGGER.info("/employee/addsuccess");

            visit.setIsCanceled(false);
            visit.setIsConfirmed(false);
            visit.setCreatedOn(new Date());
            visitService.create(visit);

            model.put("message", "Visit added successfully!");
            return "add_success";
        } catch (Exception e) {
            e.printStackTrace();
            model.put("error_message", "Service not available. Please try after some time.");
            return "error";
        }
    }

    @RequestMapping(value = "/get_visitor_name", method = RequestMethod.GET, headers = "Accept=*/*")
    public @ResponseBody List<String> getVisitorNameList(@RequestParam("term") final String query) {
        List<String> visitorNameList = visitService.getVisitorNames(query);
        return visitorNameList;
    }

    @InitBinder
    protected void initBinder(final WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
    }
}
