/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.base;

import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.ModelMap;
import rcommon.data.session.RSessionDataBase;
import rcommon.data.session.RSessionDataPackage;
import rcommon.data.session.RSessionDataSubPackage;

/**
 *
 * @author renhongxiang
 */
public abstract class SubPackController extends SessionController{

    @Override
    public boolean controllerPageIn(HttpServletRequest request, ModelMap model){
        RSessionDataBase sessData = this.getSessionData(request);
        if(sessData != null){            
            RSessionDataSubPackage pageData = createPageData();            
            RSessionDataPackage curPackData = sessData.getCurPackage();
            curPackData.setSubPackage(pageData);
        }
        return true;
    }
    
    protected abstract RSessionDataSubPackage createPageData();
    
}
