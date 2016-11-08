/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.base;

import com.readingmins.controller.LoginedControllerBase;

/**
 *
 * @author renhongxiang
 */
//@Controller
//@Scope("session")
public abstract class SettingController extends LoginedControllerBase{
    
    
//    @RequestMapping(value = "/setting", method = RequestMethod.GET)
//    public String settingGet(HttpServletRequest request, ModelMap model, HttpServletResponse response) {
//        
//        this.controllerPageIn(request, model);
//        
//        SettingBean bean = new SettingBean();
//        RY_User user = this.getLoginUser(request);
//        if(user != null){
//            if(user.isEmailCertified()){
//                bean.setEmailCertified(true);
//            }else{
//                bean.setEmailCertified(false);
//            }
//        }
//        
//        model.addAttribute("Setting", bean);
//        
//        return "setting";
//    }    
//    
//    
//    @RequestMapping(value = "/setting", method = RequestMethod.POST)
//    public String settingPost(HttpServletRequest request, ModelMap model) {
//        
//        this.controllerPageIn(request, model);
//        
//        String host = WebUtils.getWebSite(request);
//        
//        SettingBean bean = new SettingBean();
//        RY_User user = this.getLoginUser(request);
//        if(user != null){
//            if(user.isEmailCertified()){
//                bean.setEmailCertified(true);
//            }else{
//                bean.setEmailCertified(false);
//            }
//        }        
//        model.addAttribute("Setting", bean);
//        
//        CertifyEmailOperation op = new CertifyEmailOperation();
//        op.setAcctUser(user);
//        op.setUser(user);
//        op.setHostURL(host);
//        op.DoOperation();
//
//        
//        return "setting"; // this is which page to use.
//    }
        
}
