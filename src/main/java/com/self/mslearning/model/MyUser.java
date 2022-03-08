package com.self.mslearning.model;

public class MyUser {
    private String fName;
    private String lName;
    private String userName;
    private String age;

    public MyUser(String fName, String lName, String userName, String age) {
        this.fName = fName;
        this.lName = lName;
        this.userName = userName;
        this.age = age;
    }

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
