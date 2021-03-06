package com.sparsh.tracker.visit.validation;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class CreateVisitForm {

    @NotEmpty
    @Size(min = 1, max = 50)
    private String userName;

    @NotEmpty
    @Size(min = 1, max = 20)
    private String password;

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
