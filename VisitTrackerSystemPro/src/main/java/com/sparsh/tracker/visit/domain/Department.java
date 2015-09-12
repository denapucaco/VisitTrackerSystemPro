package com.sparsh.tracker.visit.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Prashant Swamy
 * @created on 23/07/2012
 */

@Entity
@Table(name = "department")
@NamedQueries({ @NamedQuery(name = "findAllDepartments", query = "FROM Department dept") })
public class Department implements Serializable {

    private static final long serialVersionUID = 101978444975264882L;

    @Id
    @Basic(optional = false)
    @GeneratedValue
    @Column(name = "department_id")
    private Integer departmentId;

    @Column(name = "name", unique = true, nullable = false, length = 50)
    private String name;

    @OneToMany(mappedBy = "department")
    // fetch=FetchType.LAZY By default
    private Set<Employee> employees;

    /**
     * Default Constructor.
     */
    public Department() {
        super();
    }

    /**
     * Constructor accepts Department name.
     * @param name as String
     */
    public Department(final String name) {
        super();
        this.name = name;
    }

    /**
     * Constructor accepts Department id and name.
     * @param departmentId
     * @param name
     */
    public Department(final Integer departmentId, final String name) {
        super();
        this.departmentId = departmentId;
        this.name = name;
    }

    /**
     * @return the departmentId
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * @param departmentId the departmentId to set
     */
    public void setDepartmentId(final Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the employees
     */
    public Set<Employee> getEmployees() {
        return employees;
    }

    /**
     * @param employees the employees to set
     */
    public void setEmployees(final Set<Employee> employees) {
        this.employees = employees;
    }
}
