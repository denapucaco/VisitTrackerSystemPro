package com.sparsh.tracker.visit.service;

import com.sparsh.tracker.visit.domain.Login;

/**
*
* @author Prashant Swamy
* @created on 15/12/2012
*/

public interface LoginService {

    public final static String ROLE_USER = "ROLE_USER";
    public final static String ROLE_SECURITY = "ROLE_SECURITY";
    public final static String ROLE_ADMIN = "ROLE_ADMIN";

    public final static Integer ACCESS_USER = 1;
    public final static Integer ACCESS_SECURITY = 2;
    public final static Integer ACCESS_ADMIN = 3;

    /**
     * Create the new Login
     * @param login
     */
    public void create(Login login);

    /**
     * Find the Login by login id
     * @param id
     * @return Login
     */
    public Login findById(Integer id);

    /**
     * Find the Login by User Name 
     * @param userName
     * @return Login
     */
    public Login findByUserName(String userName);
}
