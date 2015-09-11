package com.sparsh.tracker.visit.dao;

import java.util.List;

import com.sparsh.tracker.visit.domain.Employee;

/**
*
* @author Prashant Swamy
* @created on 26/08/2012
*/
public interface EmployeeDAO {

    Employee findById(Integer id);

    void save(Employee employee);

    List findAll();

    List findByEmployeeNumber(Integer employeeNumber);
}
