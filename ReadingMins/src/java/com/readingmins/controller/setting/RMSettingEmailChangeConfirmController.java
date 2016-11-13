/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.setting;

import com.framework.controller.account.setting.UserSettingChangeEmailConfirmController;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author renhongxiang
 */
@Controller
public class RMSettingEmailChangeConfirmController extends UserSettingChangeEmailConfirmController{
    
    @RequestMapping(value = "/settingEmailConfirm", method = RequestMethod.GET)
    public String pageGet(HttpServletRequest request,ModelMap model) {        
        
        return this.pageConfirmGet(request, model);
    }
    
    @RequestMapping(value = "/settingEmailConfirm", method = RequestMethod.POST)
    public String pageBasePost(HttpServletRequest request,ModelMap model) {        
        
        return this.pageConfirmBack(request, model);
    }

}
