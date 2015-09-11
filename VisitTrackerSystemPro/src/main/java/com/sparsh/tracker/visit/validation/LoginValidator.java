package com.sparsh.tracker.visit.validation;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sparsh.tracker.visit.domain.Login;

public class LoginValidator implements Validator {

    // @Override
    public boolean supports(Class<?> clazz) {
        return Login.class.isAssignableFrom(clazz);
    }

    // @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "userName.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");

        Login login = (Login) target;
        StringUtils.hasLength(login.getUserName());

    }
}
