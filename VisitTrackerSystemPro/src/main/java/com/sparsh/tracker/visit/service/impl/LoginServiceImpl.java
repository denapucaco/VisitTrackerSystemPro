package com.sparsh.tracker.visit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sparsh.tracker.visit.dao.LoginDAO;
import com.sparsh.tracker.visit.domain.Login;
import com.sparsh.tracker.visit.service.LoginService;

/**
* 
* @author Prashant Swamy
* @created on 26/08/2012
*/

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDAO loginDAO;

    /**
     * @param departmentDAO the departmentDAO to set
     */
    public void setDepartmentDAO(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }

    /*
     * (non-Javadoc)
     * @see com.minda.service.DepartmentService#create(com.minda.domain.Department)
     */
    // @Override
    @Transactional
    public void create(Login login) {
        loginDAO.save(login);

    }

    /*
     * (non-Javadoc)
     * @see com.minda.service.DepartmentService#findById(java.lang.Long)
     */
    // @Override
    @Transactional(readOnly = true)
    public Login findById(Integer id) {
        return (Login) loginDAO.findById(id);
    }

    /*
     * (non-Javadoc)
     * @see com.sparsh.tracker.visit.service.LoginService#findByUserName(java.lang.String)
     */
    // @Override
    public Login findByUserName(String userName) {
        return loginDAO.findByUserName(userName);
    }
}
