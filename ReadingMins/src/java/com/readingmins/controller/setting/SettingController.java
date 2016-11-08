/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.setting;

import com.readingmins.controller.SubPackController;
import com.readingmins.web.app.WebUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.ModelMap;
import rcommon.data.session.RSessionDataPackage;
import rcommon.rdata.common.RY_User;
import rm_lib.sess.RM_SessionData;

/**
 *
 * @author renhongxiang
 */
public abstract class SettingController extends SubPackController{
    
    
    @Override
    public boolean controllerPageIn(HttpServletRequest request, ModelMap model){
        boolean res = super.controllerPageIn(request, model);
        if(res){
            this.initBuildTType(model);
            return true;
        }
        return false;
    }
    
    public RY_User getLoginUser(HttpServletRequest request){
        RM_SessionData sessData = WebUtils.getSessionData(request);
        if(sessData != null){
            return sessData.getLoginUser();
        }
        return null;
    }
    
    public String doBack(HttpServletRequest request){
        RM_SessionData sessData = WebUtils.getSessionData(request);
        if(sessData != null){
            RSessionDataPackage packageData = sessData.getCurPackage();
            if(packageData != null){
                String pageName = packageData.getPageName();
                return "redirect:" + pageName;
            }
        }
        return null;
    }
}
