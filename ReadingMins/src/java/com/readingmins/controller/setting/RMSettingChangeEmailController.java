/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.setting;

import com.framework.controller.account.setting.ChangeEmailBean;
import com.framework.controller.account.setting.UserSettingChangeEmailController;
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
public class RMSettingChangeEmailController extends UserSettingChangeEmailController{
        
    @RequestMapping(value = "/settingEmail", method = RequestMethod.GET)
    public String pageGet(HttpServletRequest request,ModelMap model) {        
        
        return this.changeEmailGet(request, model);

    }

    @RequestMapping(value = "/settingEmail",params = "saveEmail", method = RequestMethod.POST)
    public String pageSaveEmailPost(HttpServletRequest request,
            @ModelAttribute("changeEmail") ChangeEmailBean bean,
            BindingResult result,
            ModelMap model) {        
        
        return this.saveEmailPost(request, bean, result, model);
        
    }

    @RequestMapping(value = "/settingEmail",params = "certifyEmail", method = RequestMethod.POST)
    public String pageCertifyEmailPost(HttpServletRequest request,
            @ModelAttribute("changeEmail") ChangeEmailBean bean,
            BindingResult result,
            ModelMap model) {        
        
        return this.certifyEmailPost(request, bean, result, model);
        
    }

    @RequestMapping(value = "/settingEmail",params = "back", method = RequestMethod.POST)
    public String pageBack(HttpServletRequest request,
            @ModelAttribute("changeEmail") ChangeEmailBean bean,
            BindingResult result,
            ModelMap model) {        
                
        return this.settingEmailBack(request, model);
    }
    
}
