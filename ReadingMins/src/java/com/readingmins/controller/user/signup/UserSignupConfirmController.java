/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.user.signup;

import com.readingmins.controller.user.UserControllerBase;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
        
        model.addAttribute("signOnForm", new UserAccountBean());
        return "userConfirm"; // this is which page to use.
    }
    
}
