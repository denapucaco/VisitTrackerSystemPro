package com.sparsh.tracker.visit.service;

import java.util.List;

import com.sparsh.tracker.visit.domain.Department;

/**
*
* @author Prashant Swamy
* @created on 26/08/2012
*/

public interface DepartmentService {

    void create(final Department department);

    Department findById(final Integer id);

    List findAll();

}
