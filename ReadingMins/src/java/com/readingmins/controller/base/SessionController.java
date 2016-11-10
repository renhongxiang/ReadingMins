/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.base;

import com.readingmins.web.app.WebUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.ModelMap;
import rcommon.app.setting.RAppSetting;
import rcommon.data.session.RSessionDataBase;
import rcommon.data.session.RSessionDataPackage;
import rcommon.rdata.common.RY_User;

/**
 *
 * @author renhongxiang
 */
public abstract class SessionController {
    
    public abstract String getControllerPageName();
    
    public boolean controllerPageIn(HttpServletRequest request, ModelMap model){
        RSessionDataBase sess = this.getSessionData(request);
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
    
    protected RY_User getLoginUser(HttpServletRequest request){
        RSessionDataBase sess = this.getSessionData(request);
        if(sess != null){
            return sess.getLoginUser();
        }
        return null;
    }
    
    protected boolean isSessionLogin(HttpServletRequest request){
        RY_User user = getLoginUser(request);
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
    
    public RSessionDataBase getSessionData(HttpServletRequest request){
        WebUtils util = WebUtils.getInstance();
        if(util != null){
            RSessionDataBase sess = util.getSessionData(request);
            return sess;
        }
        return null;
    }

    public RSessionDataPackage getCurPackage(HttpServletRequest request){
        RSessionDataBase sessData = this.getSessionData(request);
        if(sessData != null){
            return sessData.getCurPackage();
        }
        return null;
    }
    
}
