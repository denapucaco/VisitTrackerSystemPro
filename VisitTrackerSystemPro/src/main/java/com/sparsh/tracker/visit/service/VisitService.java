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
	public void create(Visit visit);
	public Visit findById(Integer id);
	public List findAll();
	
	public List getVisits(Date date);
	
	/**
	 * Get all visits of a employee which are not yet confirmed for input day
	 * @param employeeNumber
	 * @param date
	 * @return List of Non Confirmed Visits
	 */
	public List getVisits(Integer employeeNumber, Date date);
	
	/**
	 * Get all visits of a employee which are not yet confirmed
	 * @param employeeNumber
	 * @return List of Non Confirmed Visits
	 */
	public List getNonConfirmedVisitsForEmployee(Integer employeeNumber);
	
	/**
	 * Get all visits of a employee which can be canceled
	 * @param Integer employeeNumber
	 * @return List of Cancel able Visits
	 */
	public List getCancellableVisitsForEmployee(Integer employeeNumber);
	
	/**
	 * Get all Visitor Names
	 * @param name
	 * @return List of Visits
	 */
	public List getVisitorNames(String name);
	
	/**
	 * Get Visits After a Date
	 * @param fromDate
	 * @return List of Visits
	 */
	public List getVisitsAfterDate(Date fromDate);
	
	/**
	 * Get Visits For Date Range
	 * @param fromDate
	 * @param toDate
	 * @return List of Visits
	 */
	public List getVisitsForDateRange(Date fromDate, Date toDate);
	
	/**
	 * Execute the generated HQL for Report
	 * @param String sql 
	 * @return List of Visits
	 */
	public List executeHQLQuery(String sql);
}
