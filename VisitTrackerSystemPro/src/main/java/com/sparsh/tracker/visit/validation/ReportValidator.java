package com.sparsh.tracker.visit.validation;

import javax.annotation.Resource;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sparsh.tracker.visit.domain.Report;

@Resource(description = "")
public class ReportValidator implements Validator {

    // @Override
    public boolean supports(Class<?> clazz) {
        return Report.class.isAssignableFrom(clazz);
    }

    // @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fromDate", "name.required", "From Date is Mandatory.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "toDate", "password.required", "To Date is Mandatory.");
    }
}
