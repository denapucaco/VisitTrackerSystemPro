package com.sparsh.tracker.visit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sparsh.tracker.visit.dao.EmployeeDAO;
import com.sparsh.tracker.visit.domain.Employee;
import com.sparsh.tracker.visit.service.EmployeeService;

/**
* @author Prashant Swamy
* @created on 26/08/2012
* 
*/

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDAO employeeDAO;

    /**
     * @param employeeDAO the employeeDAO to set
     */
    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    /*
     * (non-Javadoc)
     * @see com.minda.service.EmployeeService#create(com.minda.domain.Employee)
     */
    // @Override
    @Transactional
    public void create(final Employee employee) {
        employeeDAO.save(employee);
    }

    /*
     * (non-Javadoc)
     * @see com.minda.service.EmployeeService#findById(java.lang.Integer)
     */
    // @Override
    @Transactional(readOnly = true)
    public Employee findById(final Integer id) {
        return (Employee) employeeDAO.findById(id);
    }

    /*
     * (non-Javadoc)
     * @see com.minda.service.EmployeeService#findAll()
     */
    // @Override
    @Transactional(readOnly = true)
    public List findAll() {
        return employeeDAO.findAll();
    }

    /*
     * (non-Javadoc)
     * @see com.sparsh.tracker.visit.service.EmployeeService#findByEmployeeNumber(java.lang.Integer)
     */
    // @Override
    public Employee findByEmployeeNumber(final Integer employeeNumber) {
        List<Employee> employees = employeeDAO.findByEmployeeNumber(employeeNumber);
        if (employees != null && employees.size() > 0) {
            return (Employee) employees.get(0);
        }
        return null;
    }
}
