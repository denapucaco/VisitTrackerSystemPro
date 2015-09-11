package com.sparsh.tracker.visit.dao;

import com.sparsh.tracker.visit.domain.Login;

/**
 *
 * @author Prashant Swamy
 * @created on 26/08/2012
 */
public interface LoginDAO {
	
	public Login findById(Integer id);	
	public void save(Login department);
	
	public Login findByUserName(String userName);
}
