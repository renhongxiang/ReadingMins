/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.base;

import com.framework.controller.LoginedControllerBase;
import javax.servlet.http.HttpServletRequest;
import rcommon.data.session.RSessionDataBase;
import rm_lib.sess.RM_SessionData;

/**
 *
 * @author renhongxiang
 */
public abstract class RM_LoginedControllerBase extends LoginedControllerBase{
    
    public RM_SessionData getRMSessionData(HttpServletRequest request){
        RSessionDataBase sessData = this.getSessionData(request);
        if(sessData != null){
            if(sessData instanceof RM_SessionData){
                return (RM_SessionData)sessData;
            }
        }
        return null;
    }
    
}
