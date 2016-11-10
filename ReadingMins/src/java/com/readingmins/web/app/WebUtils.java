/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.web.app;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import rcommon.data.session.RSessionDataBase;
import rcommon.rdata.common.RY_User;
import rcommon.utils.datatype.RStringUtils;

/**
 *
 * @author renhongxiang
 */
public class WebUtils {
    
    private static WebUtils instance = null;

    public static WebUtils getInstance() {
        return instance;
    }

    public static void setInstance(WebUtils instance) {
        WebUtils.instance = instance;
    }
    
    protected RSessionDataBase createSessionData(){
        return new RSessionDataBase();
    }
    
    public RSessionDataBase getSessionData(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        if(session != null){
            RSessionDataBase sessData = (RSessionDataBase)session.getAttribute("sessdata");
            if(sessData == null){
                sessData = createSessionData();
                session.setAttribute("sessdata", sessData);
            }
            return sessData;
        }
        return null;
    }
    
    public RY_User getLoginUser(HttpServletRequest request){
        RSessionDataBase sessData = getSessionData(request);
        if(sessData != null){
            return sessData.getLoginUser();
        }
        return null;
    }
    
    public RY_User getRegisteredUser(HttpServletRequest request){
        RSessionDataBase sessData = getSessionData(request);
        if(sessData != null){
            return sessData.getRegisteredUser();
        }
        return null;
    }
    
    public static String getServerRealPath(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        if(session != null){
            ServletContext context = session.getServletContext();
            if(context != null){
                return context.getRealPath("");
            }
        }
        return null;
    }
    
    public boolean isInSession(HttpServletRequest request){
        RY_User user = this.getLoginUser(request);
        if(user != null){
            return true;
        }
        return false;
    }
    
    public static String getWebSite(HttpServletRequest request){
        String url = request.getRequestURI();
        String urLStr = null;
        StringBuffer urL = request.getRequestURL();
        if(urL != null){
            urLStr = urL.toString();
        }
        int index = RStringUtils.indexOf(urLStr, url, 0);
        return RStringUtils.substring(urLStr, 0, index);
    }
    
}
