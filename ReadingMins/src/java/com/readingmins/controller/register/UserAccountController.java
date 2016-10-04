/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.register;

import rcommon.utils.datastructure.ArrayUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rcommon.process.logics.RegisterUserLogic;
import rcommon.rdata.common.RY_ContactInfo;
import rcommon.rdata.common.RY_Email;
import rcommon.rdata.common.RY_User;
import rm_lib.application.init.RM_AppInit;

/**
 *
 * @author renhongxiang
 */
@Controller
public class UserAccountController {
    
    @RequestMapping(value = "/SignUp", method = RequestMethod.GET)
    public String signUp(ModelMap model) {
        RM_AppInit.initApp();
        model.addAttribute("signOnForm", new UserAccountBean());
        return "signonpage"; // this is which page to use.
    }

    
    @RequestMapping(value = "/SignUp", method = RequestMethod.POST)
    public String signUpPost(@ModelAttribute("signOnForm") UserAccountBean bean, BindingResult result, ModelMap model) {
        if(bean != null){
            String userID = bean.getUserName();
            if(userID != null){
                if(this.verifyPasswordSame(bean)){
                    RY_User user = this.createUserFromBean(bean);
                    RegisterUserLogic logic = new RegisterUserLogic();
                    if(logic.doRegisterUser(user)){
                        return "signonresultpage";
                    }
                }
            }
        }
        return "signonpage"; // this is which page to use.
    }
    
    private boolean verifyPasswordSame(UserAccountBean bean){
        if(bean != null){
            char[] password = bean.getPassword();
            char[] passwordConfirm = bean.getPasswordConfirm();
            if(ArrayUtils.isCharArraySame(password, passwordConfirm)){
                return true;
            }
        }
        return false;
    }
    
    private RY_User createUserFromBean(UserAccountBean bean){
        if(bean != null){
            RY_User user = new RY_User();
            user.setUserID(bean.getUserName());
            user.setPassword(bean.getPassword());
            user.setAcctEmail(bean.getRegisteremail());
            return user;
        }
        return null;
    }
}
