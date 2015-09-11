package com.sparsh.tracker.visit.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sparsh.tracker.visit.dao.VisitDAO;
import com.sparsh.tracker.visit.domain.Visit;
import com.sparsh.tracker.visit.service.VisitService;

/**
* Implementation of Visit Service
* @author Prashant Swamy
* @created on 02/09/2012
* @modified on 09/12/2012
*/
@Service
public class VisitServiceImpl implements VisitService {

    @Autowired
    private VisitDAO visitDAO;

    /**
     * @param visitDAO the visitorDAO to set
     */
    public void setVisitDAO(VisitDAO visitDAO) {
        this.visitDAO = visitDAO;
    }

    /*
     * (non-Javadoc)
     * @see com.sparsh.tracker.visit.service.VisitorService#create(com.sparsh.tracker.visit.domain.Visitor)
     */
    // @Override
    @Transactional
    public void create(Visit visit) {
        visitDAO.save(visit);
    }

    /*
     * (non-Javadoc)
     * @see com.sparsh.tracker.visit.service.VisitorService#findById(java.lang.Integer)
     */
    // @Override
    @Transactional(readOnly = true)
    public Visit findById(Integer id) {
        return visitDAO.findById(id);
    }

    /*
     * (non-Javadoc)
     * @see com.sparsh.tracker.visit.service.VisitorService#findAll()
     */
    // @Override
    // @Transactional(readOnly=true)
    public List findAll() {
        return visitDAO.findAll();
    }

    /*
     * (non-Javadoc)
     * @see com.sparsh.tracker.visit.service.VisitService#getVisits(java.util.Date)
     */
    // @Override
    public List getVisits(Date date) {
        return visitDAO.getVisits(date);
    }

    /*
     * (non-Javadoc)
     * @see com.sparsh.tracker.visit.service.VisitService#getVisits(java.lang.Integer, java.util.Date)
     */
    // @Override
    public List getVisits(Integer employeeNumber, Date date) {
        return visitDAO.getVisits(employeeNumber, date);
    }

    /*
     * (non-Javadoc)
     * @see com.sparsh.tracker.visit.service.VisitService#getNonConfirmedVisitsForEmployee(java.lang.Integer)
     */
    // @Override
    public List getNonConfirmedVisitsForEmployee(Integer employeeNumber) {
        return visitDAO.getNonConfirmedVisitsForEmployee(employeeNumber);
    }

    /*
     * (non-Javadoc)
     * @see com.sparsh.tracker.visit.service.VisitService#getCancellableVisitsForEmployee(java.lang.Integer)
     */
    // @Override
    public List getCancellableVisitsForEmployee(Integer employeeNumber) {
        return visitDAO.getCancellableVisitsForEmployee(employeeNumber);
    }

    /*
     * (non-Javadoc)
     * @see com.sparsh.tracker.visit.service.VisitService#getVisitorNames(java.lang.String)
     */
    // @Override
    public List getVisitorNames(String name) {
        return visitDAO.getVisitorNames(name);
    }

    /*
     * (non-Javadoc)
     * @see com.sparsh.tracker.visit.service.VisitService#getVistsAfterDate(java.util.Date)
     */
    // @Override
    public List getVisitsAfterDate(Date fromDate) {
        return visitDAO.getVistsAfterDate(fromDate);
    }

    /*
     * (non-Javadoc)
     * @see com.sparsh.tracker.visit.service.VisitService#getVistsForDateRange(java.util.Date, java.util.Date)
     */
    // @Override
    public List getVisitsForDateRange(Date fromDate, Date toDate) {
        return visitDAO.getVistsForDateRange(fromDate, toDate);
    }

    /*
     * (non-Javadoc)
     * @see com.sparsh.tracker.visit.service.VisitService#executeHQLQuery(java.lang.String)
     */
    // @Override
    public List executeHQLQuery(String sql) {
        return visitDAO.executeHQLQuery(sql);
    }
}
