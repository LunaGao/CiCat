package com.cicat.entity;

import com.cicat.utils.CommonString;

/**
 * Created by lunagao on 16/7/26.
 */
public class User {

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toStringForCookie() {
        return userName + CommonString.COOKIE_BREAK_CHAR + password;
    }
}
