package com.sparsh.tracker.visit.domain;

import java.io.Serializable;
import java.util.Date;

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
* @created on 02/09/2012
*/
@Entity
@Table(name = "visit")
@NamedQueries({
        @NamedQuery(name = "findAllVisits", query = "FROM Visit visit WHERE visit.outTime IS NULL"),
        @NamedQuery(name = "getVisitsForDate",
                query = "FROM Visit visit WHERE visit.scheduledOn = :scheduledDate and visit.outTime IS NULL"),
        @NamedQuery(name = "getVisitsForEmployeeAndDate", query = "FROM Visit visit WHERE "
                + "visit.employee.employeeNumber = :employeeNumber " + "AND visit.scheduledOn = :scheduledDate "
                + "AND visit.outTime IS NULL " + "AND visit.isConfirmed = false " + "AND visit.isCanceled = false"),
        @NamedQuery(name = "getNonConfirmedVisitsForEmployee", query = "FROM Visit visit WHERE "
                + "visit.employee.employeeNumber = :employeeNumber " + "AND visit.inTime IS NOT NULL " + "AND visit.outTime IS NULL "
                + "AND visit.isConfirmed = false " + "AND visit.isCanceled = false"),
        @NamedQuery(name = "getCancellableVisitsForEmployee", query = "FROM Visit visit WHERE "
                + "visit.employee.employeeNumber = :employeeNumber " + "AND visit.inTime IS NULL " + "AND visit.outTime IS NULL "
                + "AND visit.isConfirmed = false " + "AND visit.isCanceled = false"),
        @NamedQuery(name = "getVisitorNames",
                query = "SELECT DISTINCT visit.visitorName FROM Visit visit WHERE visit.visitorName like :visitorName"),
        @NamedQuery(name = "findVisitByInTime", query = "FROM Visit visit WHERE visit.inTime = :inTime and visit.isCanceled = :isCanceled"),
        @NamedQuery(name = "getVisitsAfterDate", query = "FROM Visit visit WHERE visit.inTime >= :fromDate ORDER BY visit.inTime"),
        @NamedQuery(name = "getVistsForDateRange",
                query = "FROM Visit visit WHERE visit.scheduledOn >= :fromDate AND visit.scheduledOn <= :toDate ORDER BY visit.scheduledOn") })
public class Visit implements Serializable {
    private static final long serialVersionUID = 2897965768557777433L;

    @Id
    @Basic(optional = false)
    @GeneratedValue
    @Column(name = "VISIT_ID")
    private Integer visitId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @Column(name = "VISITOR_NAME", length = 50, nullable = false)
    private String visitorName;

    @Column(name = "REPRESENTING", length = 100, nullable = false)
    private String representing;

    @Column(name = "MOBILE_NUMBER", length = 10, nullable = true)
    private String mobileNumber;

    @Column(name = "VEHICLE_NUMBER", length = 20, nullable = true)
    private String vehicleNumber;

    @Column(name = "MATERIAL", length = 50, nullable = true)
    private String material;

    @Column(name = "PURPOSE", length = 50, nullable = false)
    private String purpose;

    @Column(name = "IN_TIME", nullable = true)
    private Date inTime;

    @Column(name = "OUT_TIME", nullable = true)
    private Date outTime;

    @Column(name = "CREATED_ON", nullable = false)
    private Date createdOn;

    @Column(name = "SCHEDULED_ON", nullable = true)
    private Date scheduledOn;

    @Column(name = "IS_CONFIRMED", nullable = true)
    private Boolean isConfirmed;

    @Column(name = "IS_CANCELED", nullable = false)
    private Boolean isCanceled;

    @Column(name = "VISIT_DURATION", length = 30, nullable = true)
    private String visitDuration;

    /**
     * @return the visitorId
     */
    public Integer getVisitId() {
        return visitId;
    }

    /**
     * @param visitorId the visitorId to set
     */
    public void setVisitId(final Integer visitId) {
        this.visitId = visitId;
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
     * @return the visitorName
     */
    public String getVisitorName() {
        return visitorName;
    }

    /**
     * @param visitorName the visitorName to set
     */
    public void setVisitorName(final String visitorName) {
        this.visitorName = visitorName;
    }

    /**
     * @return the representing
     */
    public String getRepresenting() {
        return representing;
    }

    /**
     * @param representing the representing to set
     */
    public void setRepresenting(final String representing) {
        this.representing = representing;
    }

    /**
     * @return the mobileNumber
     */
    public String getMobileNumber() {
        return mobileNumber;
    }

    /**
     * @param mobileNumber the mobileNumber to set
     */
    public void setMobileNumber(final String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /**
     * @return the vehicleNumber
     */
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    /**
     * @param vehicleNumber the vehicleNumber to set
     */
    public void setVehicleNumber(final String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    /**
     * @return the material
     */
    public String getMaterial() {
        return material;
    }

    /**
     * @param material the material to set
     */
    public void setMaterial(final String material) {
        this.material = material;
    }

    /**
     * @return the purpose
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     * @param purpose the purpose to set
     */
    public void setPurpose(final String purpose) {
        this.purpose = purpose;
    }

    /**
     * @return the inTime
     */
    public Date getInTime() {
        return inTime;
    }

    /**
     * @param inTime the inTime to set
     */
    public void setInTime(final Date inTime) {
        this.inTime = inTime;
    }

    /**
     * @return the outTime
     */
    public Date getOutTime() {
        return outTime;
    }

    /**
     * @param outTime the outTime to set
     */
    public void setOutTime(final Date outTime) {
        this.outTime = outTime;
    }

    /**
     * @return the createdOn
     */
    public Date getCreatedOn() {
        return createdOn;
    }

    /**
     * @param createdOn the createdOn to set
     */
    public void setCreatedOn(final Date createdOn) {
        this.createdOn = createdOn;
    }

    /**
     * @return the isCanceled
     */
    public Boolean getIsCanceled() {
        return isCanceled;
    }

    /**
     * @param isCanceled the isCanceled to set
     */
    public void setIsCanceled(final Boolean isCanceled) {
        this.isCanceled = isCanceled;
    }

    /**
     * @return the visitDuration
     */
    public String getVisitDuration() {
        return visitDuration;
    }

    /**
     * @param visitDuration the visitDuration to set
     */
    public void setVisitDuration(final String visitDuration) {
        this.visitDuration = visitDuration;
    }

    /**
     * @return the scheduledOn
     */
    public Date getScheduledOn() {
        return scheduledOn;
    }

    /**
     * @param scheduledOn the scheduledOn to set
     */
    public void setScheduledOn(final Date scheduledOn) {
        this.scheduledOn = scheduledOn;
    }

    /**
     * @return the isConfirmed
     */
    public Boolean getIsConfirmed() {
        return isConfirmed;
    }

    /**
     * @param isConfirmed the isConfirmed to set
     */
    public void setIsConfirmed(final Boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }
}
