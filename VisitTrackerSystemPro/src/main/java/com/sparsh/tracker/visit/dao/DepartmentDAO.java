package com.sparsh.tracker.visit.dao;

import java.util.List;

import com.sparsh.tracker.visit.domain.Department;

/**
 *
 * @author Prashant Swamy
 * @created on 26/08/2012
 */
public interface DepartmentDAO {

    Department findById(Integer id);

    void save(Department department);

    List findAll();
}
