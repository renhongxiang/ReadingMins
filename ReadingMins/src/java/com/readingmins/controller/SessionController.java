/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller;

import com.readingmins.web.app.WebUtils;
import javax.servlet.http.HttpServletRequest;
import rcommon.rdata.common.RY_User;

/**
 *
 * @author renhongxiang
 */
public class SessionController {
    protected boolean isSessionLogin(HttpServletRequest request){
        RY_User user = WebUtils.getLoginUser(request);
        if(user != null){
            return true;
        }
        return false;
    }
}
