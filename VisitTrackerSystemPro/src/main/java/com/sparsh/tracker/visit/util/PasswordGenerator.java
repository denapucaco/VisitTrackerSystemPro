package com.sparsh.tracker.visit.util;

import org.apache.commons.lang.RandomStringUtils;

/**
 * 
 * @author Prashant Swamy
 * @created on 19/12/2012
 */
public class PasswordGenerator {

	public static Integer LENGTH = 8;
	/**
	 * Generate Random Password
	 * @return String
	 */
	public static String generate(){
		return RandomStringUtils.randomAlphanumeric(LENGTH);
	}
}