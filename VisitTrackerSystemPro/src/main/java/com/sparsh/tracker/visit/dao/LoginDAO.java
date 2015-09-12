package com.sparsh.tracker.visit.dao;

import com.sparsh.tracker.visit.domain.Login;

/**
 *
 * @author Prashant Swamy
 * @created on 26/08/2012
 */
public interface LoginDAO {

    Login findById(final Integer id);

    void save(final Login department);

    Login findByUserName(final String userName);
}
