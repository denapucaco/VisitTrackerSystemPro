package com.sparsh.tracker.visit.service;

import java.util.List;

import com.sparsh.tracker.visit.domain.Employee;

/**
*
* @author Prashant Swamy
* @created on 26/08/2012
*/
public interface EmployeeService {

    String STATUS_ACTIVE = "STS001";
    String STATUS_REGINED = "STS002";

    void create(final Employee employee);

    Employee findById(final Integer id);

    List findAll();

    Employee findByEmployeeNumber(final Integer employeeNumber);
}
