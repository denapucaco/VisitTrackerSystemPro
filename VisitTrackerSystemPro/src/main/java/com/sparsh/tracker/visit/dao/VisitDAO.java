package com.sparsh.tracker.visit.dao;

import java.util.Date;
import java.util.List;

import com.sparsh.tracker.visit.domain.Visit;

/**
*
* @author Prashant Swamy
* @created on 02/09/2012
*/
public interface VisitDAO {

    Visit findById(final Integer id);

    void save(final Visit visit);

    List findAll();

    List getVisits(final Date date);

    /**
     * Get all visits of a employee which are not yet confirmed for input day
     * @param Integer employeeNumber
     * @param Date date
     * @return List of Non Confirmed Visits
     */
    List getVisits(final Integer employeeNumber, final Date date);

    /**
     * Get all visits of a employee which are not yet confirmed
     * @param Integer employeeNumber
     * @return List of Non Confirmed Visits
     */
    List getNonConfirmedVisitsForEmployee(final Integer employeeNumber);

    /**
     * Get all visits of a employee which can be canceled
     * @param Integer employeeNumber
     * @return List of Cancel able Visits
     */
    List getCancellableVisitsForEmployee(final Integer employeeNumber);

    List getVisitorNames(final String name);

    List getVistsAfterDate(final Date fromDate);

    List getVistsForDateRange(final Date fromDate, final Date toDate);

    /**
     * Execute the generated HQL for Report
     * @param String sql 
     * @return List of Visits
     */
    List executeHQLQuery(final String sql);
}
