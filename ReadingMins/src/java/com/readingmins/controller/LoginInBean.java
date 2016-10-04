/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller;

/**
 *
 * @author renhongxiang
 */
public class LoginInBean {
    private String userID = null;
    private char[]  password = null;
    private char[]  passwordconfirm = null;
    
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public char[] getPasswordconfirm() {
        return passwordconfirm;
    }

    public void setPasswordconfirm(char[] passwordconfirm) {
        this.passwordconfirm = passwordconfirm;
    }

    
    
}
