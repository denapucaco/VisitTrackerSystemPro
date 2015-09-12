package com.sparsh.tracker.visit.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
*
* @author Prashant Swamy
* @created on 23/07/2012
* @Modified on 15/12/2012
*/
@Entity
@Table(name = "login")
@NamedQueries({ @NamedQuery(name = "findLoginByUserName", query = "FROM Login login WHERE login.userName = :userName") })
public class Login implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @GeneratedValue
    @Column(name = "login_id")
    private Integer loginId;

    @Column(name = "user_name", length = 15, nullable = false)
    private String userName;

    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

    @Column(name = "access", length = 4, nullable = false)
    private Integer access;

    @Column(name = "account_not_expired", nullable = false)
    private Boolean accountNonExpired;

    @Column(name = "credentials_non_expired", nullable = false)
    private Boolean credentialsNonExpired;

    @Column(name = "account_not_locked", nullable = false)
    private Boolean accountNotLocked;

    @ManyToOne(optional = false)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    /**
     * @return the loginId
     */
    public Integer getLoginId() {
        return loginId;
    }

    /**
     * @param loginId the loginId to set
     */
    public void setLoginId(final Integer loginId) {
        this.loginId = loginId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(final String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * @return the enabled
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * @param enabled the enabled to set
     */
    public void setEnabled(final Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @return the access
     */
    public Integer getAccess() {
        return access;
    }

    /**
     * @param access the access to set
     */
    public void setAccess(final Integer access) {
        this.access = access;
    }

    /**
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(final Employee employee) {
        this.employee = employee;
    }

    /**
     * @return the accountNonExpired
     */
    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    /**
     * @param accountNonExpired the accountNonExpired to set
     */
    public void setAccountNonExpired(final Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    /**
     * @return the credentialsNonExpired
     */
    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    /**
     * @param credentialsNonExpired the credentialsNonExpired to set
     */
    public void setCredentialsNonExpired(final Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    /**
     * @return the accountNotLocked
     */
    public Boolean getAccountNotLocked() {
        return accountNotLocked;
    }

    /**
     * @param accountNotLocked the accountNotLocked to set
     */
    public void setAccountNotLocked(final Boolean accountNotLocked) {
        this.accountNotLocked = accountNotLocked;
    }
}
