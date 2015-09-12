package com.sparsh.tracker.visit.controller;

import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sparsh.tracker.visit.domain.Employee;
import com.sparsh.tracker.visit.domain.Login;
import com.sparsh.tracker.visit.service.LoginService;

/**
 * 
 * @author Prashant Swamy
 * @created on 11/12/2012 
 */
@Controller
@RequestMapping(value = "/home")
public class HomePageController {

    private static final Logger LOGGER = Logger.getLogger(HomePageController.class);

    @Autowired
    private LoginService loginService;

    // @RequestMapping(value="/user", method=RequestMethod.GET)
    // public String showUserHome(Map<String, Object> model, HttpServletRequest request, Principal principal) {
    //
    // /*HttpSession session = request.getSession();
    //
    // Login login = (Login) session.getAttribute("login");
    // if(login==null || login.getUserName().equals("")) {
    // return "redirect:/auth/login.do";
    // }*/
    //
    // final String userName = principal.getName();
    // model.put("userName", userName);
    // return "show_home_user";
    // }
    // @RequestMapping(value="/security", method=RequestMethod.GET)
    // public String showSecurityHome(Map<String, Object> model, HttpServletRequest request, Principal principal) {
    // return "redirect:/security/index.do";
    // }
    // @RequestMapping(value="/admin", method=RequestMethod.GET)
    // public String showAdminHome(Map<String, Object> model, HttpServletRequest request, Principal principal) {
    //
    // return "show_home_admin";
    // return "redirect:/admin/report.do";
    // }

    /*
     * @RequestMapping(method=RequestMethod.GET) public String showHomePage(Map<String, Object> model, HttpSession session) { Login login =
     * (Login) session.getAttribute("login"); if(login==null || login.getUserName().equals("")) { return "redirect:/auth/login.do"; } if
     * (login.getAccess().equals(LoginService.ACCESS_ADMIN)) { return "redirect:/home/admin.do"; } else if
     * (login.getAccess().equals(LoginService.ACCESS_SECURITY)) { return "redirect:/home/security.do"; } else if
     * (login.getAccess().equals(LoginService.ACCESS_USER)) { return "redirect:/home/user.do"; } // Call should never reach here return
     * null; }
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showHomePage(final Map<String, Object> model, final HttpSession session, final Principal principal) {

        Login login = (Login) session.getAttribute("login");
        if (login == null || login.getUserName().equals("")) {
            login = loginService.findByUserName(principal.getName());
            // // Set the Login into Session
            session.setAttribute("login", login);
            Employee employee = login.getEmployee();
            session.setAttribute("user_name", employee.getFirstName() + " " + employee.getLastName());

            if (login == null || login.getUserName().equals("")) {
                return "redirect:/auth/login.do";
            }
        }

        if (login.getAccess().equals(LoginService.ACCESS_ADMIN)) {
            return "show_home_admin";
        } else if (login.getAccess().equals(LoginService.ACCESS_SECURITY)) {
            return "redirect:/security/index.do";
        } else if (login.getAccess().equals(LoginService.ACCESS_USER)) {
            return "show_home_user";
        }

        // Call should never reach here
        return null;
    }
}
