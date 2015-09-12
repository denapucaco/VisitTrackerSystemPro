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

import com.sparsh.tracker.visit.domain.Visit;
import com.sparsh.tracker.visit.service.VisitService;

/**
 * 
 * @author Prashant Swamy
 * @created on 12/12/2012
 */
@Controller
@RequestMapping(value = "/security")
public class InOutManagementController {

    private static final Logger LOGGER = Logger.getLogger(InOutManagementController.class);

    @Autowired
    private VisitService visitService;

    @RequestMapping("/index")
    public String listVisitors(final Map<String, Object> model, final HttpSession session) {

        try {

            /*
             * Login login = (Login) session.getAttribute("login"); if(login==null || login.getUserName().equals("")) { return
             * "redirect:/login.do"; }
             */

            model.put("visit", new Visit());
            Date today = new com.sparsh.tracker.visit.util.Date().getBeginningOfDay().asUtilDate();

            List visitList = visitService.getVisits(today);
            if (visitList == null || visitList.size() < 1) {
                model.put("message", "No Records found!");
                // model.put("userName", login.getUserName());
                return "add_success";
            }
            model.put("visitList", visitList);
            // model.put("userName", login.getUserName());
            return "list_visits";
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage() + " " + e.getCause());
            model.put("error_message", "Service not available. Please try after some time.");
            return "error";
        }
    }

    @RequestMapping(value = "/select_visit", method = RequestMethod.GET)
    public String selectVisit(@RequestParam(value = "visitId") final String visitId, Map<String, Object> model, final HttpSession session) {
        try {

            /*
             * Login login = (Login) session.getAttribute("login"); if(login==null || login.getUserName().equals("")) { return
             * "redirect:/login.do"; }
             */

            Integer visitOID = Integer.valueOf(visitId);
            Visit visit = visitService.findById(visitOID);

            model.put("visit", visit);

            if (visit.getInTime() == null) {
                // model.put("userName", login.getUserName());
                return "in_visit";
            } else if (visit.getOutTime() == null) {
                if (visit.getIsConfirmed() == null || !visit.getIsConfirmed()) {
                    model.put("warning", "Visit Not Confirmed!");
                    // model.put("userName", login.getUserName());
                } else {
                    model.put("warning", "");
                }

                long seconds = (new Date().getTime() - visit.getInTime().getTime()) / 1000;
                long days = seconds / (24 * 60 * 60);
                long hours = (seconds / (60 * 60)) - (days * 24);
                long mins = (seconds / (60)) - (days * 24 * 60) - (hours * 60);

                String dayss = "Days";
                String hourss = "Hours";
                String minss = "Mins";

                boolean dayb = false;
                boolean hourb = false;
                boolean minb = false;

                if (days > 0) {
                    dayb = true;
                    if (days == 1) {
                        dayss = "Day";
                    }
                }

                if (hours > 0) {
                    hourb = true;
                    if (hours == 1) {
                        hourss = "Hour";
                    }
                }

                if (mins > 0) {
                    minb = true;
                    if (mins == 1) {
                        minss = "Min";
                    }
                }

                StringBuffer sb = new StringBuffer();
                if (dayb) {
                    sb.append(days + " " + dayss);
                }
                if (hourb) {
                    sb.append(" " + hours + " " + hourss);
                }
                if (minb) {
                    sb.append(" " + mins + " " + minss);
                }

                if (sb.toString().equals("")) {
                    sb.append("few Seconds");
                }
                visit.setVisitDuration(sb.toString());
                // model.put("userName", login.getUserName());
                return "out_visit";
            } else {
                model.put("message", "Visitor already out!");
                // model.put("userName", login.getUserName());
                return "add_success";
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.put("error_message", "Service not available. Please try after some time.");
            return "error";
        }
    }

    @RequestMapping(value = "/in_visit", method = RequestMethod.POST)
    @Transactional
    public String invisit(@ModelAttribute("SpringWeb") final Visit visit, final Map<String, Object> model, final HttpSession session) {
        try {

            /*
             * Login login = (Login) session.getAttribute("login"); if(login==null || login.getUserName().equals("")) { return
             * "redirect:/login.do"; }
             */

            Visit dbVisit = visitService.findById(visit.getVisitId());
            dbVisit.setVehicleNumber(visit.getVehicleNumber());
            dbVisit.setMaterial(visit.getMaterial());
            dbVisit.setInTime(new Date());

            visitService.create(dbVisit);

            model.put("message", "In Visit successful!");
            // model.put("userName", login.getUserName());
            return "add_success";
        } catch (Exception e) {
            e.printStackTrace();
            model.put("error_message", "Service not available. Please try after some time.");
            return "error";
        }
    }

    @RequestMapping(value = "/out_visit", method = RequestMethod.POST)
    @Transactional
    public String outvisit(@ModelAttribute("SpringWeb") final Visit visit, final Map<String, Object> model, final HttpSession session) {
        try {

            /*
             * Login login = (Login) session.getAttribute("login"); if(login==null || login.getUserName().equals("")) { return
             * "redirect:/login.do"; }
             */

            Visit dbVisit = visitService.findById(visit.getVisitId());

            dbVisit.setOutTime(new Date());
            dbVisit.setVisitDuration(visit.getVisitDuration());
            visitService.create(dbVisit);

            model.put("message", "Out Visit successful!");
            // model.put("userName", login.getUserName());
            return "add_success";
        } catch (Exception e) {
            e.printStackTrace();
            model.put("error_message", "Service not available. Please try after some time.");
            return "error";
        }
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
    }
}
