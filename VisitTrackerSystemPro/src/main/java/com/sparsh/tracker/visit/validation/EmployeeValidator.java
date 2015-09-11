/**
 * 
 */
package com.sparsh.tracker.visit.validation;

import org.springframework.validation.Errors;

import com.sparsh.tracker.visit.domain.Employee;

/**
 * @author Prashant Swamy
 *
 */
public class EmployeeValidator {

	public void validate(Employee employee, Errors errors) {
		Integer empId = employee.getEmployeeNumber();
		if(empId==null || empId==0){
			errors.rejectValue("employeeNumber", "required", "required");
		}
		
		/*if (!StringUtils.hasLength(name)) {
			errors.rejectValue("name", "required", "required");
		}
		else if (pet.isNew() && pet.getOwner().getPet(name, true) != null) {
			errors.rejectValue("name", "duplicate", "already exists");
		}*/
	}
	
}
