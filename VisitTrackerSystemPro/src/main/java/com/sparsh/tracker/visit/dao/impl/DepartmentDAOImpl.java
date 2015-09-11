package com.sparsh.tracker.visit.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sparsh.tracker.visit.dao.DepartmentDAO;
import com.sparsh.tracker.visit.domain.Department;

/**
 *
 * @author Prashant Swamy
 * @created on 26/08/2012
 */

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    /*
     * (non-Javadoc)
     * @see com.minda.dao.DepartmentDAO#findById(java.lang.Long)
     */
    // @Override
    public Department findById(Integer id) {
        // return (Department)hibernateTemplate.findByNamedQueryAndNamedParam("findById", "departmentId", id);
        return (Department) hibernateTemplate.get(Department.class, id);
    }

    /*
     * (non-Javadoc)
     * @see com.minda.dao.DepartmentDAO#save(com.minda.domain.Department)
     */
    // @Override
    public void save(Department department) {
        hibernateTemplate.saveOrUpdate(department);
    }

    /*
     * (non-Javadoc)
     * @see com.minda.dao.DepartmentDAO#findAll()
     */
    // @Override
    public List findAll() {
        return hibernateTemplate.findByNamedQuery("findAllDepartments");
    }

}
