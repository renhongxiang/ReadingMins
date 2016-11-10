/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.user.idpassword;

import com.readingmins.controller.base.SessionController;
import com.readingmins.web.app.WebUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rcommon.process.logics.operation.ResetPasswordEmailOperation;

/**
 *
 * @author renhongxiang
 */
@Controller
public class UserSendResetPasswordController extends SessionController{
    
    public static String PAGE_NAME = "userRetrievePassword";
    
    @RequestMapping(value = "/userRetrievePassword", method = RequestMethod.GET)
    public String pwdInfoGet(HttpServletRequest request,ModelMap model) {
        
        this.controllerPageIn(request, model);
        
        UserResetPasswordBean pwdBean = new UserResetPasswordBean();
        model.addAttribute("resetPwdReq", pwdBean);
        
        return getControllerPageName(); // this is which page to use.
    }
    
    @RequestMapping(value = "/userRetrievePassword",params = "resetPwd", method = RequestMethod.POST)
    public String resetPwdPost(HttpServletRequest request,
            @ModelAttribute("resetPwdReq") UserResetPasswordBean pwdBean,
            ModelMap model) {
        
        this.controllerPageIn(request, model);
        
        String email = pwdBean.getEmail();
        String host = WebUtils.getWebSite(request);
        
        ResetPasswordEmailOperation op = new ResetPasswordEmailOperation();
        op.setEmail(email);
        op.setHostURL(host);
        if(op.DoOperation()){
            return "redirect:userForgotPwdSent";
        }
        
        return getControllerPageName(); // this is which page to use.
    }
    
    @RequestMapping(value = "/userRetrievePassword",params = "cancel", method = RequestMethod.POST)
    public String cancelPost(HttpServletRequest request, ModelMap model) {
        this.controllerPageIn(request, model);
        return "redirect:userLogin"; // this is which page to use.
    }

    @Override
    public String getControllerPageName() {
        return PAGE_NAME;
    }
    
    
}
