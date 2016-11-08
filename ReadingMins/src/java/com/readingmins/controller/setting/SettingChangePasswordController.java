/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.setting;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rcommon.process.logics.LoginUserLogic;
import rcommon.process.logics.operation.SaveResetedPasswordOperation;
import rcommon.rdata.common.RY_User;
import rcommon.utils.datatype.RStringUtils;

/**
 *
 * @author renhongxiang
 */
@Controller
public class SettingChangePasswordController extends SettingController{
    
    public static String PAGE_NAME = "settingPassword";
    
    @RequestMapping(value = "/settingPassword", method = RequestMethod.GET)
    public String settingPasswordGet(HttpServletRequest request,ModelMap model) {        

        this.controllerPageIn(request, model);

        model.addAttribute("changePassword", new ChangePasswordBean());
        
        return getControllerPageName(); // this is which page to use.
    }
    
    @RequestMapping(value = "/settingPassword",params = "chnagePwd", method = RequestMethod.POST)
    public String settingPasswordPost(HttpServletRequest request,
            @ModelAttribute("changePassword") ChangePasswordBean bean,
            BindingResult result,
            ModelMap model) {        

        this.controllerPageIn(request, model);

        String newPassword = bean.getNewPassword();
        String newPassword2 = bean.getNewPassword2();
        if(RStringUtils.isNotBlank(newPassword) &&
                RStringUtils.equals(newPassword, newPassword2)){
            RY_User user = this.getLoginUser(request);
            RY_User testUser = new RY_User();
            testUser.setUserID(user.getUserID());
            testUser.setPassword(bean.getOldPassword());
            if(this.loginVerify(testUser)){
                user.setPassword(newPassword);
                SaveResetedPasswordOperation op = new SaveResetedPasswordOperation();
                op.setUser(user);
                if(op.DoOperation()){
                    return "redirect:" + getControllerPageName();
                }
                
            }
        }else{
            result.rejectValue("newPassword","newPassword","Password do not match");
            result.rejectValue("passwordConfirm","newPassword2","Password do not match");
        }
        return getControllerPageName(); // this is which page to use.
    }
    
    @RequestMapping(value = "/settingPassword",params = "back", method = RequestMethod.POST)
    public String settingPasswordBack(HttpServletRequest request,
            ModelMap model) {        
        return this.doBack(request);
    }


    private boolean loginVerify(RY_User user){
        LoginUserLogic logic = new LoginUserLogic();
        return logic.doLoginUser(user);
    }

    @Override
    public String getControllerPageName() {
        return PAGE_NAME;
    }
    
}
