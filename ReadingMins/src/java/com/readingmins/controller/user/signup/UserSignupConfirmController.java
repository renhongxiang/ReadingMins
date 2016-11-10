/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.user.signup;

import com.readingmins.controller.user.UserControllerBase;
import com.readingmins.web.app.WebUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import rcommon.rdata.common.RY_User;

/**
 *
 * @author renhongxiang
 */
@Controller
@Scope("session")
public class UserSignupConfirmController extends UserControllerBase{
    
    public static String PAGE_NAME = "userConfirm";
    
    @RequestMapping(value = "/userConfirm")
    public String signUp(HttpServletRequest request, ModelMap model) {
        this.controllerPageIn(request, model);
        
        WebUtils util = WebUtils.getInstance();
        
        RY_User user = util.getRegisteredUser(request);
        if(user != null){
            String userName = user.getUserID();
            model.addAttribute("userName", userName);
        }
        
        return getControllerPageName(); // this is which page to use.
    }

    @Override
    public String getControllerPageName() {
        return PAGE_NAME;
    }
    
}
