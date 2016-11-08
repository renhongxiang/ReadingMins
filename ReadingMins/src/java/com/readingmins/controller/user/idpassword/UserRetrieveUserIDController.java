/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.user.idpassword;

import com.readingmins.controller.SessionController;
import com.readingmins.web.app.WebUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rcommon.process.logics.operation.RetrieveUserIDOperation;

/**
 *
 * @author renhongxiang
 */
@Controller
public class UserRetrieveUserIDController extends SessionController{
    
    public static String PAGE_NAME = "userRetrieveUserID";
    
    @RequestMapping(value = "/userRetrieveUserID", method = RequestMethod.GET)
    public String pwdInfoGet(HttpServletRequest request,ModelMap model) {
        
        this.controllerPageIn(request, model);
        
        UserResetPasswordBean idBean = new UserResetPasswordBean();
        model.addAttribute("retrieveUserID", idBean);
        
        return getControllerPageName(); // this is which page to use.
    }
    
    @RequestMapping(value = "/userRetrieveUserID",params = "sendUserID", method = RequestMethod.POST)
    public String resetPwdPost(HttpServletRequest request,
            @ModelAttribute("retrieveUserID") UserResetPasswordBean pwdBean,
            ModelMap model) {
        
        this.controllerPageIn(request, model);
        
        String email = pwdBean.getEmail();
        String host = WebUtils.getWebSite(request);
        
        RetrieveUserIDOperation op = new RetrieveUserIDOperation();
        op.setEmail(email);
        op.setHostURL(host);
        if(op.DoOperation()){
            return "redirect:userForgotIDSent";
        }
        
        return getControllerPageName(); // this is which page to use.
    }

    @RequestMapping(value = "/userRetrieveUserID",params = "cancel", method = RequestMethod.POST)
    public String cancelPost(HttpServletRequest request, ModelMap model) {
        this.controllerPageIn(request, model);
        return "redirect:userLogin"; // this is which page to use.
    }

    @Override
    public String getControllerPageName() {
        return PAGE_NAME;
    }
    
}
