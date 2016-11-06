/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.user.emailcert;

/**
 *
 * @author renhongxiang
 */
public class EmailCertifyBean {
    
    private boolean certified = false;
    
    private String userName = null;
    
    private String email = null;

    public boolean isCertified() {
        return certified;
    }

    public void setCertified(boolean Certified) {
        this.certified = Certified;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
