/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.setting;

import com.framework.controller.account.setting.ChangePasswordBean;
import com.framework.controller.account.setting.UserSettingChangePasswordController;
import javax.servlet.http.HttpServletRequest;
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
public class RMSettingChangePasswordController extends UserSettingChangePasswordController{
    
    
    @RequestMapping(value = "/settingPassword", method = RequestMethod.GET)
    public String pageRequestGet(HttpServletRequest request,ModelMap model) {        
        
        return this.settingPasswordGet(request, model);
    }
    
    @RequestMapping(value = "/settingPassword",params = "chnagePwd", method = RequestMethod.POST)
    public String pagePostChangePassword(HttpServletRequest request,
            @ModelAttribute("changePassword") ChangePasswordBean bean,
            BindingResult result,
            ModelMap model) {        

        return this.settingPasswordPost(request, bean, result, model);
    }
    
    @RequestMapping(value = "/settingPassword",params = "back", method = RequestMethod.POST)
    public String pagePostBack(HttpServletRequest request,
            ModelMap model) {        
        return this.settingPasswordBack(request, model);
    }
    
    
}
