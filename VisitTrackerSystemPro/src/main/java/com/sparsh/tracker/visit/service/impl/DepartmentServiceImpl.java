package com.sparsh.tracker.visit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sparsh.tracker.visit.dao.DepartmentDAO;
import com.sparsh.tracker.visit.domain.Department;
import com.sparsh.tracker.visit.service.DepartmentService;

/**
* 
* @author Prashant Swamy
* @created on 26/08/2012
*/

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDAO departmentDAO;

    /**
     * @param departmentDAO the departmentDAO to set
     */
    public void setDepartmentDAO(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    /*
     * (non-Javadoc)
     * @see com.minda.service.DepartmentService#create(com.minda.domain.Department)
     */
    // @Override
    @Transactional
    public void create(Department department) {
        departmentDAO.save(department);

    }

    /*
     * (non-Javadoc)
     * @see com.minda.service.DepartmentService#findById(java.lang.Long)
     */
    // @Override
    @Transactional(readOnly = true)
    public Department findById(Integer id) {
        return (Department) departmentDAO.findById(id);
    }

    /*
     * (non-Javadoc)
     * @see com.minda.service.DepartmentService#findAll()
     */
    // @Override
    @Transactional(readOnly = true)
    public List findAll() {
        return departmentDAO.findAll();
    }

}
