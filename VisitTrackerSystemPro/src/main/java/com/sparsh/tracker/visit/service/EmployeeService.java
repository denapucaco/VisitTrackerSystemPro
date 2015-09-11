package com.sparsh.tracker.visit.service;

import java.util.List;

import com.sparsh.tracker.visit.domain.Employee;

/**
*
* @author Prashant Swamy
* @created on 26/08/2012
*/
public interface EmployeeService {
	public static String STATUS_ACTIVE = "STS001";
	public static String STATUS_REGINED = "STS002";
	
	public void create(Employee employee);
	public Employee findById(Integer id);
	public List findAll();
	public Employee findByEmployeeNumber(Integer employeeNumber);
}
