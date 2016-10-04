/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.register;

/**
 *
 * @author renhongxiang
 */
public class UserAccountBean {
    
    private String firstName;
    
    private String lastName;
    
    private String userName;
    
    private char[] password;
    
    private char[] passwordConfirm;
        
    private String registerEmail;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public char[] getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(char[] passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getRegisteremail() {
        return registerEmail;
    }

    public void setRegisteremail(String registeremail) {
        this.registerEmail = registeremail;
    }

    
    
}
