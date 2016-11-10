/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.ui.ModelMap;
import rcommon.app.setting.RAppSetting;
import rcommon.data.session.RSessionDataPackage;
import rcommon.rdata.common.RY_User;
import rm_lib.sess.RM_SessionData;

/**
 *
 * @author renhongxiang
 */
public abstract class SessionController {
    
    public abstract String getControllerPageName();
    
    public boolean controllerPageIn(HttpServletRequest request, ModelMap model){        
        RM_SessionData sess = this.getSessionData(request);
        if(sess != null){
            RSessionDataPackage pageData = this.createPageData();
            if(pageData != null){
                pageData.setPageName(this.getControllerPageName());
            }
            sess.setCurPackage(pageData);
        }
        this.initBuildTType(model);
        
        return true;
    }
    
    protected RSessionDataPackage createPageData(){
        return null;
    }
    
    protected boolean isSessionLogin(HttpServletRequest request){
        RY_User user = this.getLoginUser(request);
        if(user != null){
            return true;
        }
        return false;
    }
    
    protected void initBuildTType(ModelMap model){
        RAppSetting setting = RAppSetting.getAppSetting();
        if(setting != null){
            if(setting.isDebug()){
                model.addAttribute("buildType", "Debug");
            }else{
                model.addAttribute("buildType", "");
            }
        }
    }
    
    public RM_SessionData getSessionData(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        if(session != null){
            RM_SessionData sessData = (RM_SessionData)session.getAttribute("sessdata");
            if(sessData == null){
                sessData = new RM_SessionData();
                session.setAttribute("sessdata", sessData);
            }
            return sessData;
        }
        return null;
    }
        
    protected RY_User getLoginUser(HttpServletRequest request){
        RM_SessionData sessData = this.getSessionData(request);
        if(sessData != null){
            return sessData.getLoginUser();
        }
        return null;
        
    }
    
}