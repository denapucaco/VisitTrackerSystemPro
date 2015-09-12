package com.sparsh.tracker.visit.service;

import com.sparsh.tracker.visit.domain.Login;

/**
*
* @author Prashant Swamy
* @created on 15/12/2012
*/

public interface LoginService {

    String ROLE_USER = "ROLE_USER";
    String ROLE_SECURITY = "ROLE_SECURITY";
    String ROLE_ADMIN = "ROLE_ADMIN";

    Integer ACCESS_USER = 1;
    Integer ACCESS_SECURITY = 2;
    Integer ACCESS_ADMIN = 3;

    /**
     * Create the new Login
     * @param login
     */
    void create(final Login login);

    /**
     * Find the Login by login id
     * @param id
     * @return Login
     */
    Login findById(final Integer id);

    /**
     * Find the Login by User Name 
     * @param userName
     * @return Login
     */
    Login findByUserName(final String userName);
}
