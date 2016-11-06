/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.config;

import rcommon.process.logics.ResetPassword;

/**
 *
 * @author renhongxiang
 */
public class ReadingMinsResetPassword extends ResetPassword{
    
    public static void InitReadingMinsResetPassword(){
        ReadingMinsResetPassword setting = new ReadingMinsResetPassword();
        ReadingMinsResetPassword.setResetPasswordInstance(setting);
    }
    
    @Override
    protected String getCertifyPageURL(String host){
        return host + "/ReadingLog/ResetPassword?";
    }
    
    @Override
    protected String getMailSubject(){
        return "Reset Password";
    }
    
}
