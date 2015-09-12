package com.sparsh.tracker.visit.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sparsh.tracker.visit.dao.LoginDAO;
import com.sparsh.tracker.visit.domain.Login;

/**
 *
 * @author Prashant Swamy
 * @created on 26/08/2012
 */

@Repository
public class LoginDAOImpl implements LoginDAO {

    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    /*
     * (non-Javadoc)
     * @see com.sparsh.tracker.visit.dao.LoginDAO#findById(java.lang.Integer)
     */
    @Override
    public Login findById(final Integer id) {
        return (Login) hibernateTemplate.get(Login.class, id);
    }

    /*
     * (non-Javadoc)
     * @see com.sparsh.tracker.visit.dao.LoginDAO#save(com.sparsh.tracker.visit.domain.Login)
     */
    @Override
    public void save(final Login login) {
        hibernateTemplate.saveOrUpdate(login);
    }

    /*
     * (non-Javadoc)
     * @see com.sparsh.tracker.visit.dao.LoginDAO#findByUserName(com.sparsh.tracker.visit.domain.Login)
     */
    @Override
    public Login findByUserName(final String userName) {
        List<Login> logins = (List<Login>) hibernateTemplate.findByNamedQueryAndNamedParam("findLoginByUserName", "userName", userName);
        if (logins != null && logins.size() > 0) {
            return (Login) logins.get(0);
        }
        return null;

        /*
         * // Retrieve all users from the database List<Login> users = internalDatabase(); // Search user based on the parameters for(Login
         * Login:users) { if ( Login.getUserName().equals(username) == true ) { System.out.println("User found"); // return matching user
         * return Login; } } System.err.println("User does not exist!"); throw new RuntimeException("User does not exist!");
         */
    }

    /**
     * Our fake database. Here we populate an ArrayList with a dummy list of users.
     */
    private List<Login> internalDatabase() {
        // Dummy database

        // Create a dummy array list
        List<Login> users = new ArrayList<Login>();
        Login login = null;

        // Create a new dummy user
        login = new Login();
        login.setUserName("john");
        // Actual password: admin
        login.setPassword("21232f297a57a5a743894a0e4a801fc3");
        // Admin user
        login.setAccess(1);

        // Add to array list
        users.add(login);

        // Create a new dummy user
        login = new Login();
        login.setUserName("jane");
        // Actual password: user
        login.setPassword("ee11cbb19052e40b07aac0ca060c23ee");
        // Regular user
        login.setAccess(2);

        // Add to array list
        users.add(login);

        return users;
    }
}
