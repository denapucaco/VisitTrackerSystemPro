package com.sparsh.tracker.visit.service;

import java.util.Date;
import java.util.List;

import com.sparsh.tracker.visit.domain.Visit;

/**
* Visit Service
* @author Prashant Swamy
* @created on 02/09/2012
* @modified on 09/12/2012
*/
public interface VisitService {

    void create(final Visit visit);

    Visit findById(final Integer id);

    List findAll();

    List getVisits(final Date date);

    /**
     * Get all visits of a employee which are not yet confirmed for input day
     * @param employeeNumber
     * @param date
     * @return List of Non Confirmed Visits
     */
    List getVisits(final Integer employeeNumber, final Date date);

    /**
     * Get all visits of a employee which are not yet confirmed
     * @param employeeNumber
     * @return List of Non Confirmed Visits
     */
    List getNonConfirmedVisitsForEmployee(final Integer employeeNumber);

    /**
     * Get all visits of a employee which can be canceled
     * @param Integer employeeNumber
     * @return List of Cancel able Visits
     */
    List getCancellableVisitsForEmployee(final Integer employeeNumber);

    /**
     * Get all Visitor Names
     * @param name
     * @return List of Visits
     */
    List getVisitorNames(final String name);

    /**
     * Get Visits After a Date
     * @param fromDate
     * @return List of Visits
     */
    List getVisitsAfterDate(final Date fromDate);

    /**
     * Get Visits For Date Range
     * @param fromDate
     * @param toDate
     * @return List of Visits
     */
    List getVisitsForDateRange(final Date fromDate, final Date toDate);

    /**
     * Execute the generated HQL for Report
     * @param String sql 
     * @return List of Visits
     */
    List executeHQLQuery(final String sql);
}
