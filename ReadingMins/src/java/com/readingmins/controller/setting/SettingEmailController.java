/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.setting;

import com.framework.utils.WebUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rcommon.process.logics.operation.CertifyEmailOperation;
import rcommon.process.logics.operation.SaveResetedPasswordOperation;
import rcommon.rdata.common.RY_User;

/**
 *
 * @author renhongxiang
 */
@Controller
public class SettingEmailController extends SettingController{
    
    public static String PAGE_NAME = "settingEmail";
    
    @RequestMapping(value = "/settingEmail", method = RequestMethod.GET)
    public String changeEmailGet(HttpServletRequest request,ModelMap model) {        
        
        this.controllerPageIn(request, model);
        
        ChangeEmailBean bean = new ChangeEmailBean();
        RY_User user = this.getLoginUser(request);
        if(user != null){
            bean.setCurEmail(user.getAcctEmail());
            if(user.isEmailCertified()){
                bean.setEmailCertified(true);
            }else{
                bean.setEmailCertified(false);
            }
        }
        model.addAttribute("changeEmail", bean);
        
        return getControllerPageName(); // this is which page to use.
    }

    @RequestMapping(value = "/settingEmail",params = "saveEmail", method = RequestMethod.POST)
    public String changeEmailPost(HttpServletRequest request,
            @ModelAttribute("changeEmail") ChangeEmailBean bean,
            BindingResult result,
            ModelMap model) {        
        
        this.controllerPageIn(request, model);
        
        bean.setEmailSent(false);

        String newEmail = bean.getNewEmail();
        if(validateEmail(newEmail)){
            RY_User user = this.getLoginUser(request);
            RY_User testUser = new RY_User();
            testUser.setUserIOID(user.getUserIOID());
            testUser.setAcctEmail(newEmail);
            testUser.setEmailCertified(false);
            SaveResetedPasswordOperation op = new SaveResetedPasswordOperation();
            op.setUser(testUser);
            if(op.DoOperation()){
                user.setAcctEmail(testUser.getAcctEmail());
                user.setEmailCertified(false);
                return "redirect:" + getControllerPageName();
            }
        }else{
            result.rejectValue("newEmail","newEmail","Email format is not valid.");
        }
        
        return getControllerPageName(); // this is which page to use.
    }

    @RequestMapping(value = "/settingEmail",params = "certifyEmail", method = RequestMethod.POST)
    public String certifyEmailPost(HttpServletRequest request,
            @ModelAttribute("changeEmail") ChangeEmailBean bean,
            BindingResult result,
            ModelMap model) {        
        
        this.controllerPageIn(request, model);
        
        String host = WebUtils.getWebSite(request);
        
        RY_User user = this.getLoginUser(request);
        
        CertifyEmailOperation op = new CertifyEmailOperation();
        op.setAcctUser(user);
        op.setUser(user);
        op.setHostURL(host);
        if(op.DoOperation()){
            bean.setEmailSent(true);
            bean.setCurEmail(user.getAcctEmail());
        }
        return getControllerPageName(); // this is which page to use.
    }

    @RequestMapping(value = "/settingEmail",params = "back", method = RequestMethod.POST)
    public String settingEmailBack(HttpServletRequest request,
            @ModelAttribute("changeEmail") ChangeEmailBean bean,
            BindingResult result,
            ModelMap model) {        
                
        return this.doBack(request);
    }
    
    private boolean validateEmail(String email){
        return true;
    }

    @Override
    public String getControllerPageName() {
        return PAGE_NAME;
    }
    
}
