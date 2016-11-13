/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.user.idpassword;

import com.framework.controller.account.idpasswordreset.UserRetrieveIDPasswordBean;
import com.framework.controller.account.idpasswordreset.UserResetPasswordSentEmailController;
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
public class RMUserResetPasswordSentEmailController extends UserResetPasswordSentEmailController{
    
    
    @RequestMapping(value = "/userRetrievePassword", method = RequestMethod.GET)
    public String pwdInfoGet(HttpServletRequest request,ModelMap model) {
        return this.pageGet(request, model);
    }
    
    @RequestMapping(value = "/userRetrievePassword",params = "resetPwd", method = RequestMethod.POST)
    public String resetPwdPost(HttpServletRequest request,
            @ModelAttribute("resetPwdReq") UserRetrieveIDPasswordBean pwdBean,
            ModelMap model) {
        
        return this.pageSentPost(request, pwdBean, model);
        
    }
    
    @RequestMapping(value = "/userRetrievePassword",params = "cancel", method = RequestMethod.POST)
    public String cancelPost(HttpServletRequest request, ModelMap model) {
        return this.pageCancelPost(request, model);
    }

    
}
