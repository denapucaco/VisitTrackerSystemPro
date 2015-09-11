package com.sparsh.tracker.visit.util;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Creation date: (24/09/12 22:56:43)
 * @author: Prashant Swamy
 */
public class Date implements Cloneable{
	
	private java.util.Calendar date;
	
	public final static java.lang.String FORMAT_SHORT = "dd/MM/yyyy";
	public final static java.lang.String FORMAT_LONG = "dd/MM/yyyy HH:mm:ss";
	public final static java.lang.String FORMAT_DB = "yyyy-MM-dd HH:mm:ss";
	public final static java.lang.String FORMAT_MMyy = "MMyy";	
	public final static java.lang.String FORMAT_ddMMMHHmm = "dd MMM HH:mm";	
	/**
	 * Insert the method's description here.
	 * Creation date: (24/09/12 22:56:43)
	 */
	public Date() {
		super();
		this.date = new GregorianCalendar();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24/09/12 22:56:43)
	 * @param timestamp long
	 */
	public Date(long timestamp) {
		this(new java.util.Date(timestamp));
	}
	
	/**
	 * Insert the method's description here.
	 * Creation date: (24/09/12 22:56:43)
	 * @param date java.util.Date
	 */
	public Date(java.sql.Date date) {
		super();
		this.date = new GregorianCalendar();
		this.date.setTime(date);
		this.date.set(Calendar.HOUR_OF_DAY, 0);
		this.date.set(Calendar.MINUTE, 0);
		this.date.set(Calendar.SECOND, 0);
		this.date.set(Calendar.MILLISECOND, 0);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24/09/12 22:56:43)
	 * @param date java.util.Date
	 */
	public Date(java.sql.Timestamp timestamp) {
		super();
		this.date = new GregorianCalendar();
		this.date.setTimeInMillis(timestamp.getTime());
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01/03/00 15:45:39)
	 * @param param java.util.Calendar
	 */
	public Date(Calendar calendar) {
		super();
		this.date = calendar;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24/09/12 22:56:43)
	 * @param date java.util.Date
	 */
	public Date(java.util.Date date) {
		super();
		this.date = new GregorianCalendar();
		this.date.setTime(date);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24/09/12 22:56:43)
	 * @param numberOfDays int
	 */
	public void addDay(int numberOfDays) {
		date.add(Calendar.DAY_OF_MONTH, numberOfDays);
	}
	/**
	 * Adds the number of units of type specified the type is on Calendar
	 * @param type
	 * @param number
	 */
	public void add(int number, int type) {
		date.add(type, number);
	}
	/**
	 * Adds the specified number of minutes to the date
	 * @param numberOfMinutes int
	 */
	public void addMinutes(int numberOfMinutes) {
		date.add(Calendar.MINUTE, numberOfMinutes);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24/09/12 22:56:43)
	 * @param numberOfMonths int
	 */
	public void addMonth(int numberOfMonths) {
		date.add(Calendar.MONTH, numberOfMonths);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24/09/12 22:56:43)
	 * @param numberOfDays int
	 */
	public Date addSecond(int numberOfSeconds) {
		date.add(Calendar.SECOND, numberOfSeconds);
		return this;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24/09/12 22:56:43)
	 * @return boolean
	 * @param param com.kariba.infrastructure.Date
	 */
	public boolean after(Date param) {
		return date.after(param.date);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01/03/00 15:55:07)
	 * @return com.kariba.infrastructure.Date
	 */
	public Calendar asCalendar() {
		return (Calendar)date.clone();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01/03/00 15:55:07)
	 * @return com.kariba.infrastructure.Date
	 */
	public long asLong() {
		return date.getTime().getTime();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01/03/00 15:55:07)
	 * @return com.kariba.infrastructure.Date
	 */
	public java.sql.Date asSqlDate() {
		return (new java.sql.Date(date.getTime().getTime()));
	}
	/**
	 * Returns a sql Timestamp
	 * @return java.sql.Timestamp
	 */
	public java.sql.Timestamp asTimestamp() {
		return new java.sql.Timestamp(asLong());
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01/03/00 15:55:07)
	 * @return com.kariba.infrastructure.Date
	 */
	public java.util.Date asUtilDate() {
		return date.getTime();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24/09/12 22:56:43)
	 * @return boolean
	 * @param param com.kariba.infrastructure.Date
	 */
	public boolean before(Date param) {
		return date.before(param.date);
	}
	/**
	 * Compares two Dates for ordering
	 * @return boolean
	 * @param param com.kariba.infrastructure.Date
	 */
	public int compareTo(Date param) {
		return date.getTime().compareTo(param.asUtilDate());
	}
	/**
	 * Returns the number of days between the two specified dates
	 * @return int
	 * @param startDate com.kariba.infrastructure.Date
	 * @param endDate com.kariba.infrastructure.Date
	 */
	public int dayDiff(Date endDate) {
		Date fromDate;
		Date toDate;
		boolean negative;	

		if(this.before(endDate)){
			fromDate = this.getBeginningOfDay();
			toDate = endDate.getBeginningOfDay();
			negative = false;
		}else{
			fromDate = endDate.getBeginningOfDay();
			toDate = this.getBeginningOfDay();
			negative = true;
		}

		long fromDateInMilliseconds = fromDate.asLong();
		long toDateInMilliseconds = toDate.asLong();

		long diffInMilliseconds = toDateInMilliseconds - fromDateInMilliseconds;

		int dayCount = (int)Math.abs(diffInMilliseconds / (24 * 60 * 60 * 1000));

		return dayCount;
	}
	/**
	 * Returns true if the two dates are equal
	 * @return boolean
	 * @param param com.kariba.infrastructure.Date
	 */
	public boolean equals(Date param) {
		if(param == null){
			return false;
		}
		return date.equals(param.date);
	}
	/**
	 * Returns true if the two dates are equal ignoring the time element of the to dates
	 * @return boolean
	 * @param param com.kariba.infrastructure.Date
	 */
	public boolean equalsIgnoreTime(Date param) {
		if(param == null){
			return false;
		}
		return getBeginningOfDay().equals( param.getBeginningOfDay() );
	}
	/**
	 * Formats the date to a string inthe given format
	 * @return java.lang.String
	 * @param format java.lang.String
	 */
	public String format(String format) {
		java.text.SimpleDateFormat dateFormatter = new java.text.SimpleDateFormat(format);
		return dateFormatter.format(date.getTime());
	}
	/**
	 * Returns a new Date with the hours, minutes, seconds and milliseconds set to 0.
	 * @return com.kariba.infrastructure.Date
	 */
	public Date getBeginningOfDay() {
		Calendar dt = asCalendar();
		dt.set(Calendar.HOUR_OF_DAY, 0);
		dt.set(Calendar.MINUTE, 0);
		dt.set(Calendar.SECOND, 0);
		dt.set(Calendar.MILLISECOND, 0);
		return (new Date(dt));
	}
	/**
	 * Returns the first day of the month for the current dat on system. 
	 * To use and helper methods please first call this function and then
	 * call the helper method. -- Malvern & Clint 
	 * @return com.kariba.infrastructure.Date
	 */
	public static Date getBeginningOfMonth() {
		Calendar dt = Calendar.getInstance();
		dt.set(Calendar.DAY_OF_MONTH, 1);
		return new Date(dt).getBeginningOfDay();
	}
	/**
	 * Returns a new Date with the milliseconds set to 0.
	 * @return com.kariba.infrastructure.Date
	 */
	public Date getBeginningOfSecond() {
		Calendar dt = asCalendar();
		dt.set(Calendar.MILLISECOND, 0);
		return (new Date(dt));
	}
	/**
	 * Returns a new Date with the hours, minutes, seconds and milliseconds set to max.
	 * @return com.kariba.infrastructure.Date
	 */
	public Date getEndOfDay() {
		Calendar dt = asCalendar();
		dt.set(Calendar.HOUR_OF_DAY, dt.getMaximum(Calendar.HOUR_OF_DAY));
		dt.set(Calendar.MINUTE, dt.getMaximum(Calendar.MINUTE));
		dt.set(Calendar.SECOND, dt.getMaximum(Calendar.SECOND));
		dt.set(Calendar.MILLISECOND, dt.getMaximum(Calendar.MILLISECOND));
		return (new Date(dt));
	}

	/**
	 * Returns the last day of the year
	 * @return com.kariba.infrastructure.Date
	 */
	public Date getLastDayOfYear() {
		Calendar gc = asCalendar();
		int year = gc.get(Calendar.YEAR);
		gc.set(Calendar.YEAR, year);
		gc.set(Calendar.DAY_OF_YEAR, gc.getActualMaximum(Calendar.DAY_OF_YEAR));
		return new Date(gc).getBeginningOfDay();
	}

	/**
	 * Returns the last day of the month
	 * @return com.kariba.infrastructure.Date
	 */
	public Date getLastDayOfMonth() {
		Calendar gc = asCalendar();
		int month = gc.get(Calendar.MONTH);
		gc.set(Calendar.MONTH, month);
		gc.set(Calendar.DAY_OF_MONTH, gc.getActualMaximum(Calendar.DAY_OF_MONTH));
		return new Date(gc).getBeginningOfDay();
	}
	/**
	 * Returns the last day of the month
	 * @param month int
	 * @return com.kariba.infrastructure.Date
	 */
	public static Date getLastDayOfMonth(int month) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(Calendar.MONTH, month);
		gc.set(Calendar.DAY_OF_MONTH, gc.getActualMaximum(Calendar.DAY_OF_MONTH));
		return new Date(gc).getBeginningOfDay();
	}
	/**
	 * Returns the hasCode
	 * @return int
	 */
	public int hashCode(Date param) {
		return date.hashCode();
	}
	/**
	 * Parses a date from a string
	 * @return com.kariba.infrastructure.Date
	 * @param dateString java.lang.String
	 * @param format java.lang.String
	 */
	public static Date parse(String dateString, String format) throws ParseException{
		java.text.SimpleDateFormat dateFormatter = new java.text.SimpleDateFormat(format);
		return new Date(dateFormatter.parse(dateString));
	}
	/**
	 * Sets this Date's time (hours, minutes, seconds and milliseconds) set to 0.
	 */
	public void setBeginningOfDay() {
		this.date.set(Calendar.HOUR_OF_DAY, 0);
		this.date.set(Calendar.MINUTE, 0);
		this.date.set(Calendar.SECOND, 0);
		this.date.set(Calendar.MILLISECOND, 0);
	}
	/**
	 * Sets this Date's time (hours, minutes, seconds and milliseconds) set to the maximum.
	 */
	public void setEndOfDay() {
		this.date.set(Calendar.HOUR_OF_DAY, date.getActualMaximum(Calendar.HOUR_OF_DAY));
		this.date.set(Calendar.MINUTE, date.getActualMaximum(Calendar.MINUTE));
		this.date.set(Calendar.SECOND, date.getActualMaximum(Calendar.SECOND));
		this.date.set(Calendar.MILLISECOND, date.getActualMaximum(Calendar.MILLISECOND));
	}

	/**
	 * Sets the year, month and day of the date keeping the time the same
	 * @param year
	 * @param month
	 * @param day
	 */
	public void setYearMonthDay(int year, int month, int day){
		this.date.set(Calendar.YEAR, year);
		this.date.set(Calendar.MONTH, month);
		this.date.set(Calendar.DAY_OF_MONTH, day);
	}

	/**
	 * Returns the value of the field.  The field is as per Calendar class
	 * @param field
	 * @return
	 */
	public int getField(int field){
		return this.date.get(field);
	}

	/**
	 * Returns the string representation
	 */
	public String toString() {
		return format(FORMAT_LONG);	
	}
}

