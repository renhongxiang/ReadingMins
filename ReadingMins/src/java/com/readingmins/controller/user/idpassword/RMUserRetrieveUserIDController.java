/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.user.idpassword;

import com.framework.controller.account.idpasswordreset.UserRetrieveIDPasswordBean;
import com.framework.controller.account.idpasswordreset.UserRetrieveUserIDController;
import javax.servlet.http.HttpServletRequest;
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
public class RMUserRetrieveUserIDController extends UserRetrieveUserIDController{
    
    
    @RequestMapping(value = "/userRetrieveUserID", method = RequestMethod.GET)
    public String rmRetrieveUserIDGet(HttpServletRequest request,ModelMap model) {
        return this.retrieveUserIDGet(request, model);
    }
    
    @RequestMapping(value = "/userRetrieveUserID",params = "sendUserID", method = RequestMethod.POST)
    public String rmResetPwdPost(HttpServletRequest request,
            @ModelAttribute("retrieveUserID") UserRetrieveIDPasswordBean pwdBean,
            ModelMap model) {
        
        return this.retrieveUserIDPost(request, pwdBean, model);
    }

    @RequestMapping(value = "/userRetrieveUserID",params = "cancel", method = RequestMethod.POST)
    public String rmCancelPost(HttpServletRequest request, ModelMap model) {
        return this.cancelPost(request, model);
    }
    
}
