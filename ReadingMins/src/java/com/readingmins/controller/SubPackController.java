/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller;

import com.readingmins.web.app.WebUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.ModelMap;
import rcommon.data.session.RSessionDataPackage;
import rcommon.data.session.RSessionDataSubPackage;
import rm_lib.sess.RM_SessionData;

/**
 *
 * @author renhongxiang
 */
public abstract class SubPackController extends SessionController{

    @Override
    public boolean controllerPageIn(HttpServletRequest request, ModelMap model){        
        RM_SessionData sess = WebUtils.getSessionData(request);
        if(sess != null){            
            RSessionDataSubPackage pageData = createPageData();            
            RSessionDataPackage curPackData = sess.getCurPackage();
            curPackData.setSubPackage(pageData);
        }
        return true;
    }
    
    protected RSessionDataSubPackage createPageData(){
        return null;
    }
    
}
