/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.user.signup;

import com.framework.controller.account.register.UserAccountBean;
import com.framework.controller.account.register.UserSingupController;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author renhongxiang
 */
@Controller
@Scope("session")
public class RMUserSignupController extends UserSingupController{
    
    @RequestMapping(value = "/userSignup", method = RequestMethod.GET)
    public String rmSignUpGet(HttpServletRequest request, ModelMap model) {
        return this.signUpGet(request, model);
    }
    
    @RequestMapping(value = "/userSignup", method = RequestMethod.POST)
    public String rmSignUpPost(HttpServletRequest request, @ModelAttribute("signOnForm") UserAccountBean bean, BindingResult result, ModelMap model) {
        return this.signUpPost(request, bean, result, model);
    }
    
}
