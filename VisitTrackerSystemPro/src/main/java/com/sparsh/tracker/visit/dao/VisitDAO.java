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
	public Visit findById(Integer id);	
	public void save(Visit visit);
	public List findAll();
	
	public List getVisits(Date date);
	
	/**
	 * Get all visits of a employee which are not yet confirmed for input day
	 * @param Integer employeeNumber
	 * @param Date date
	 * @return List of Non Confirmed Visits
	 */
	public List getVisits(Integer employeeNumber, Date date);
	
	/**
	 * Get all visits of a employee which are not yet confirmed
	 * @param Integer employeeNumber
	 * @return List of Non Confirmed Visits
	 */
	public List getNonConfirmedVisitsForEmployee(Integer employeeNumber);

	/**
	 * Get all visits of a employee which can be canceled
	 * @param Integer employeeNumber
	 * @return List of Cancel able Visits
	 */
	public List getCancellableVisitsForEmployee(Integer employeeNumber);
	
	public List getVisitorNames(String name);
	public List getVistsAfterDate(Date fromDate);
	public List getVistsForDateRange(Date fromDate, Date toDate);
	
	/**
	 * Execute the generated HQL for Report
	 * @param String sql 
	 * @return List of Visits
	 */
	public List executeHQLQuery(String sql);
}
