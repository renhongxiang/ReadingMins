/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.setting;

/**
 *
 * @author renhongxiang
 */
public class ChangeEmailBean {
    private String curEmail = null;
    private String newEmail = null;
    private boolean emailCertified = false;
    private boolean emailSent = false;
    public String getCurEmail() {
        return curEmail;
    }

    public void setCurEmail(String curEmail) {
        this.curEmail = curEmail;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public boolean isEmailCertified() {
        return emailCertified;
    }

    public void setEmailCertified(boolean emailCertified) {
        this.emailCertified = emailCertified;
    }

    public boolean isEmailSent() {
        return emailSent;
    }

    public void setEmailSent(boolean emailSent) {
        this.emailSent = emailSent;
    }
    
    
}
