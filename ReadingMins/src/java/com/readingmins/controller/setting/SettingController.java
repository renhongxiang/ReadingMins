/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.setting;

import com.framework.controller.SubPackController;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.ModelMap;
import rcommon.data.session.RSessionDataBase;
import rcommon.data.session.RSessionDataPackage;
import rcommon.data.session.RSessionDataSubPackage;
import rcommon.rdata.common.RY_User;

/**
 *
 * @author renhongxiang
 */
public class SettingController extends SubPackController{
        
    @Override
    public boolean controllerPageIn(HttpServletRequest request, ModelMap model){
        boolean res = super.controllerPageIn(request, model);
        if(res){
            this.initBuildTType(model);
            return true;
        }
        return false;
    }
    
    @Override
    public RY_User getLoginUser(HttpServletRequest request){
        return super.getLoginUser(request);
    }
    
    public String doBack(HttpServletRequest request){
        RSessionDataBase sessData = this.getSessionData(request);
        if(sessData != null){
            RSessionDataPackage packageData = sessData.getCurPackage();
            if(packageData != null){
                String pageName = packageData.getPageName();
                return "redirect:" + pageName;
            }
        }
        return null;
    }

    @Override
    protected RSessionDataSubPackage createPageData() {
        return null;
    }

    @Override
    public String getControllerPageName() {
        return null;
    }
}
