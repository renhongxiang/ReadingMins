/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller;

import com.readingmins.web.app.WebUtils;
import javax.servlet.http.HttpServletRequest;
import rcommon.data.session.RSessionDataPackage;
import rcommon.rdata.common.RY_User;
import rm_lib.sess.RM_SessDataGroup;
import rm_lib.sess.RM_SessionData;

/**
 *
 * @author renhongxiang
 */
public abstract class SessionController {
    
    
    public boolean controllerPageIn(HttpServletRequest request){
        RM_SessionData sess = WebUtils.getSessionData(request);
        if(sess != null){
            RSessionDataPackage pageData = this.createPageData();
            sess.setCurPackage(pageData);
        }
        return true;
    }
    
    protected RSessionDataPackage createPageData(){
        return null;
    }
    
    protected boolean isSessionLogin(HttpServletRequest request){
        RY_User user = WebUtils.getLoginUser(request);
        if(user != null){
            return true;
        }
        return false;
    }
}
