/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.user.idpassword;

import com.framework.controller.account.idpasswordreset.UserSaveResetPasswordBean;
import com.framework.controller.account.idpasswordreset.UserResetPasswordController;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author renhongxiang
 */
@Controller
@Scope("session")
public class RMUserResetPasswordController extends UserResetPasswordController{
    
    
    @RequestMapping(value = "/ResetPassword", method = RequestMethod.GET)
    public String pageGet(HttpServletRequest request,ModelMap model) {
        return this.resetPwdGet(request, model);
    }

    @RequestMapping(value = "/ResetPassword", method = RequestMethod.POST)
    public String pagePostResetPassword(HttpServletRequest request,
            @ModelAttribute("resetPassword") UserSaveResetPasswordBean pwdBean, ModelMap model) {

        return this.resetPwdPost(request, pwdBean, model);
        
////        this.controllerPageIn(request, model);
////
////        if(pwdBean != null){
////            String password1 = pwdBean.getPassword1();
////            String password2 = pwdBean.getPassword2();
////            
////            RSessionDataBase sessData = 
////                    this.getSessionData(request);
////            RY_User user = this.getSetPasswordUser(sessData);
////            if(StringUtils.equals(password1, password2)){
////                user.setPassword(password2);
////                SaveResetedPasswordOperation op = new SaveResetedPasswordOperation();
////                op.setUser(user);
////                if(op.DoOperation()){
////                    return "redirect:userResetPasswordConfirm";
////                }
////            }
////        }
//        
//        return getControllerPageName(); // this is which page to use.
    }
    
}
