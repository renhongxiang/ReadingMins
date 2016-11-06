/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller;

import javax.servlet.http.HttpServletRequest;
import rcommon.data.session.RSessionDataPackage;
import rcommon.rdata.common.RY_User;
import rm_lib.sess.RM_SessDataLoginGroup;
import rm_lib.sess.RM_SessionData;

/**
 *
 * @author renhongxiang
 */
public class LoginedControllerBase extends SessionController{
    
    @Override
    protected RSessionDataPackage createPageData(){
        return new RM_SessDataLoginGroup();
    }
    
    protected RY_User getLoginUser(HttpServletRequest request){
        RM_SessionData sessData = this.getSessionData(request);
        if(sessData != null){
            return sessData.getLoginUser();
        }
        return null;
        
    }
    
}
