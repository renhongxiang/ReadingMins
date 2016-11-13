/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.user.signup;

import com.framework.controller.account.register.UserSignupConfirmController;
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
public class RMUserSignupConfirmController extends UserSignupConfirmController{
    
    @RequestMapping(value = "/userConfirm")
    public String confirm(HttpServletRequest request, ModelMap model) {
        return this.signUpConfirm(request, model);
    }
    
}
