/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.setting;

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
public class SettingChangePasswordConfirmController {
    public static String PAGE_NAME = "settingPasswordConfirm";
    
    @RequestMapping(value = "/settingPasswordConfirm", method = RequestMethod.GET)
    public String settingPasswordConfirmGet(HttpServletRequest request,ModelMap model) {        
        
        return PAGE_NAME; // this is which page to use.
    }
    
    @RequestMapping(value = "/settingPasswordConfirm", method = RequestMethod.POST)
    public String settingPasswordConfirmPost(HttpServletRequest request,ModelMap model) {        
        
        return "redirect:" + SettingChangePasswordController.PAGE_NAME; // this is which page to use.
    }
}
