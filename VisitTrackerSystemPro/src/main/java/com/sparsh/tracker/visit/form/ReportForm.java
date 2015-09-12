package com.sparsh.tracker.visit.form;

import org.springframework.beans.factory.annotation.Autowired;

import com.sparsh.tracker.visit.domain.Employee;
import com.sparsh.tracker.visit.domain.Report;
import com.sparsh.tracker.visit.domain.Visit;

/**
 * Report Form
 * @author Prashant Swamy
 * @created on 28/10/2012
 */
public class ReportForm {

    @Autowired
    Report report;

    @Autowired
    Employee employee;

    @Autowired
    Visit visit;

    /**
     * @return the report
     */
    public Report getReport() {
        return report;
    }

    /**
     * @param report the report to set
     */
    public void setReport(final Report report) {
        this.report = report;
    }

    /**
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(final Employee employee) {
        this.employee = employee;
    }

    /**
     * @return the visit
     */
    public Visit getVisit() {
        return visit;
    }

    /**
     * @param visit the visit to set
     */
    public void setVisit(final Visit visit) {
        this.visit = visit;
    }
}
