/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.config;

import rcommon.process.logics.EmailUserID;
import rcommon.rdata.common.RY_User;

/**
 *
 * @author renhongxiang
 */
public class RM_EmailUserID extends EmailUserID{
    
    public static void initInstance(){
        RM_EmailUserID obj = new RM_EmailUserID();
        RM_EmailUserID.setEmailUserID(obj);
    }
    
    @Override
    protected String getWebSiteName(){
        return "EReadingLog";
    }
    
    @Override
    protected String getLoginPageURL(String host){
        String value = host + "/ReadingLog/userLogin";        
        return value;
    }
    
    
    
    
}
