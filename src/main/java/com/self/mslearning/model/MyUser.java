package com.self.mslearning.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;


public class MyUser {
    @NotEmpty(message = "First Name must not be empty")
    private String fName;
    @NotEmpty(message = "Last Name must not be empty")
    private String lName;
    @Email(message = "UserName should be a valid email")
    private String userName;
    @Min(value=18, message = "Age should be a minimum 18")
    private String age;

    public MyUser(String fName, String lName, String userName, String age) {
        this.fName = fName;
        this.lName = lName;
        this.userName = userName;
        this.age = age;
    }

    public MyUser(){}

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
