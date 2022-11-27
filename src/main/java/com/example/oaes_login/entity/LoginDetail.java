package com.example.oaes_login.entity;

public class LoginDetail {
    private long userID;
    private String password;

    @Override
    public String toString() {
        return "LoginDetail{" +
                "userID=" + userID +
                ", password='" + password + '\'' +
                '}';
    }

    public LoginDetail() {
    }

    public LoginDetail(long userID, String password) {
        this.userID = userID;
        this.password = password;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
