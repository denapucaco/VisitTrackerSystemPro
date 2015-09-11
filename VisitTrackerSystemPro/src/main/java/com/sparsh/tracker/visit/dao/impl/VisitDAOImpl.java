package com.sparsh.tracker.visit.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sparsh.tracker.visit.dao.VisitDAO;
import com.sparsh.tracker.visit.domain.Visit;

/**
*
* @author Prashant Swamy
* @created on 02/09/2012
*/
@Repository
public class VisitDAOImpl implements VisitDAO {

    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    // @Override
    public Visit findById(Integer id) {
        return (Visit) hibernateTemplate.get(Visit.class, id);
    }

    // @Override
    public void save(Visit visit) {
        hibernateTemplate.saveOrUpdate(visit);
    }

    // @Override
    public List findAll() {
        return hibernateTemplate.findByNamedQuery("findAllVisits");
    }

    /*
     * (non-Javadoc)
     * @see com.sparsh.tracker.visit.dao.VisitDAO#getVisits(java.util.Date)
     */
    // @Override
    public List getVisits(Date date) {
        return hibernateTemplate.findByNamedQueryAndNamedParam("getVisitsForDate", "scheduledDate", date);
    }

    /*
     * (non-Javadoc)
     * @see com.sparsh.tracker.visit.dao.VisitDAO#getVisits(java.lang.Integer, java.util.Date)
     */
    // @Override
    public List getVisits(Integer employeeNumber, Date date) {
        return hibernateTemplate.findByNamedQueryAndNamedParam("getVisitsForEmployeeAndDate", new String[] { "employeeNumber",
                "scheduledDate" }, new Object[] { employeeNumber, date });
    }

    /*
     * (non-Javadoc)
     * @see com.sparsh.tracker.visit.dao.VisitDAO#getNonConfirmedVisitsForEmployee(java.lang.Integer)
     */
    // @Override
    public List getNonConfirmedVisitsForEmployee(Integer employeeNumber) {
        return hibernateTemplate.findByNamedQueryAndNamedParam("getNonConfirmedVisitsForEmployee", "employeeNumber", employeeNumber);
    }

    /*
     * (non-Javadoc)
     * @see com.sparsh.tracker.visit.dao.VisitDAO#getCancellableVisitsForEmployee(java.lang.Integer)
     */
    // @Override
    public List getCancellableVisitsForEmployee(Integer employeeNumber) {
        return hibernateTemplate.findByNamedQueryAndNamedParam("getCancellableVisitsForEmployee", "employeeNumber", employeeNumber);
    }

    /*
     * (non-Javadoc)
     * @see com.sparsh.tracker.visit.dao.VisitDAO#getVisitorNames(java.lang.String)
     */
    // @Override
    public List getVisitorNames(String name) {
        return hibernateTemplate.findByNamedQueryAndNamedParam("getVisitorNames", "visitorName", "%" + name + "%");
    }

    /*
     * (non-Javadoc)
     * @see com.sparsh.tracker.visit.dao.VisitDAO#getVistsAfterDate(java.util.Date)
     */
    // @Override
    public List getVistsAfterDate(Date fromDate) {
        return hibernateTemplate.findByNamedQueryAndNamedParam("getVisitsAfterDate", "fromDate", fromDate);
    }

    /*
     * (non-Javadoc)
     * @see com.sparsh.tracker.visit.dao.VisitDAO#getVistsForDateRange(java.util.Date, java.util.Date)
     */
    // @Override
    public List getVistsForDateRange(Date fromDate, Date toDate) {
        return hibernateTemplate.findByNamedQueryAndNamedParam("getVistsForDateRange", new String[] { "fromDate", "toDate" }, new Object[] {
                fromDate, toDate });
    }

    /*
     * (non-Javadoc)
     * @see com.sparsh.tracker.visit.dao.VisitDAO#executeHQLQuery(java.lang.String)
     */
    // @Override
    public List executeHQLQuery(String sql) {
        SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
        Session session = sessionFactory.openSession();
        List list = null;
        try {
            list = session.createQuery(sql).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }
}
