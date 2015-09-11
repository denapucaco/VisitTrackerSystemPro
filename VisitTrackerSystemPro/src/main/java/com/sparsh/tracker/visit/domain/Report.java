package com.sparsh.tracker.visit.domain;

import java.util.Date;

/**
 *
 * @author Prashant Swamy
 * @created on 20/09/2012
 */

public class Report {

	private Date fromDate;
	private Date toDate;
	
	private Integer employeeNumber;
	private String employeeFirstName;
	private String employeeLastName;
	private String departmentName;
	
	private String visitorName;
	private String visitorRepresenting;
	
	/**
	 * @return the fromDate
	 */
	public Date getFromDate() {
		return fromDate;
	}
	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	/**
	 * @return the toDate
	 */
	public Date getToDate() {
		return toDate;
	}
	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	/**
	 * @return the employeeNumber
	 */
	public Integer getEmployeeNumber() {
		return employeeNumber;
	}
	/**
	 * @param employeeNumber the employeeNumber to set
	 */
	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	/**
	 * @return the employeeFirstName
	 */
	public String getEmployeeFirstName() {
		return employeeFirstName;
	}
	/**
	 * @param employeeFirstName the employeeFirstName to set
	 */
	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}
	/**
	 * @return the employeeLastName
	 */
	public String getEmployeeLastName() {
		return employeeLastName;
	}
	/**
	 * @param employeeLastName the employeeLastName to set
	 */
	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}
	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}
	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	/**
	 * @return the visitorName
	 */
	public String getVisitorName() {
		return visitorName;
	}
	/**
	 * @param visitorName the visitorName to set
	 */
	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}
	/**
	 * @return the visitorRepresenting
	 */
	public String getVisitorRepresenting() {
		return visitorRepresenting;
	}
	/**
	 * @param visitorRepresenting the visitorRepresenting to set
	 */
	public void setVisitorRepresenting(String visitorRepresenting) {
		this.visitorRepresenting = visitorRepresenting;
	}
}