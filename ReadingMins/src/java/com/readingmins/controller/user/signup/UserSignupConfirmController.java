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
    
    @RequestMapping(value = "/userConfirm")
    public String signUp(HttpServletRequest request, ModelMap model) {
        this.controllerPageIn(request);
        
        RY_User user = WebUtils.getRegisteredUser(request);
        if(user != null){
            String userName = user.getUserID();
            model.addAttribute("userName", userName);
        }
        
        return "userConfirm"; // this is which page to use.
    }
    
}
