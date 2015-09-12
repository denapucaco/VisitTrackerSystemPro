package com.sparsh.tracker.visit.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sparsh.tracker.visit.dao.EmployeeDAO;
import com.sparsh.tracker.visit.domain.Employee;

/**
*
* @author Prashant Swamy
* @created on 26/08/2012
*/
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(final SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    /*
     * (non-Javadoc)
     * @see com.minda.dao.EmployeeDAO#findById(java.lang.Long)
     */
    @Override
    public Employee findById(final Integer id) {
        return (Employee) hibernateTemplate.get(Employee.class, id);
    }

    /*
     * (non-Javadoc)
     * @see com.minda.dao.EmployeeDAO#save(com.minda.domain.Department)
     */
    @Override
    public void save(final Employee employee) {
        hibernateTemplate.saveOrUpdate(employee);
    }

    /*
     * (non-Javadoc)
     * @see com.minda.dao.EmployeeDAO#findAll()
     */
    @Override
    public List findAll() {
        return hibernateTemplate.findByNamedQuery("findAll");
    }

    /*
     * (non-Javadoc)
     * @see com.sparsh.tracker.visit.dao.EmployeeDAO#findByEmployeeNumber(java.lang.Integer)
     */
    @Override
    public List findByEmployeeNumber(final Integer employeeNumber) {
        return hibernateTemplate.findByNamedQueryAndNamedParam("findEmployeeByNumber", "employeeNumber", employeeNumber);
    }

}
