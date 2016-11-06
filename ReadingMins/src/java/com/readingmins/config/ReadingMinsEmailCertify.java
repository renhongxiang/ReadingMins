/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.config;

import rcommon.process.logics.EmailCertify;

/**
 *
 * @author renhongxiang
 */
public class ReadingMinsEmailCertify extends EmailCertify{
    
    public static void InitReadingMinsEmailCertify(){
        ReadingMinsEmailCertify certify = new ReadingMinsEmailCertify();
        ReadingMinsEmailCertify.setEmailCertifyInstance(certify);
    }
    
    @Override
    protected String getCertifyPageURL(String host){
        return host + "/ReadingLog/CertifyEmail?";
    }
    
    @Override
    protected String getMailSubject(){
        return "Ceritify your email account for EReadingLog.com";
    }
    
}
