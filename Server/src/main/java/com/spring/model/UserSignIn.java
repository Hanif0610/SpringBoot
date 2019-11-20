package com.spring.model;

public class UserSignIn {
    private String userID;
    private String userPassword;

    public UserSignIn(String userID, String userPw) {
        this.userID = userID;
        this.userPassword = userPw;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserID() {
        return userID;
    }
}
