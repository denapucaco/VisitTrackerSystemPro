package com.sparsh.tracker.visit.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
/**
 *
 * @author Prashant Swamy
 * @created on 23/07/2012
 */

@Entity
@Table(name = "employee")
@NamedQueries({
	@NamedQuery(
			name = "findAllEmployees",
			query = "FROM Employee employee"),
	@NamedQuery(
			name = "findEmployeeByNumber",
			query = "FROM Employee employee WHERE employee.employeeNumber = :employeeNumber")
//	@NamedQuery(
//			name = "findEmployeeByLoginPassword",
//			query = "FROM Employee employee WHERE employee.login = :login and employee.password = :password")
})
public class Employee implements Serializable {
	private static final long serialVersionUID = -1137658513454121311L;

	@Id
	@Basic(optional = false)
	@GeneratedValue
	@Column(name = "employee_id")
	private Integer employeeId;

	@Column(name = "employee_number", length=10, nullable=false)
	private Integer employeeNumber;

	@Column(name = "first_name", length=50, nullable=false)
	private String firstName;

	@Column(name = "last_name", length=50, nullable=false)
	private String lastName;

	@Column(name = "email", length=50, nullable=false)
	private String email;
	
	@Column(name = "mobile_number", length=11, nullable=false)
	private String mobileNumber;

	@Column(name = "status", length=10, nullable=false)
	private String status;

	@ManyToOne(optional = false)
	@JoinColumn(name="department_id")
	private Department department;
	
	/**
	 * 
	 */
	public Employee() {
		super();
	}

	/**
	 * @return the employeeId
	 */
	public Integer getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}
}
