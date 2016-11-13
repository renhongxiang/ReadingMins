/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.user.emailcert;

import com.framework.controller.account.emailcert.UserEmailCertifyController;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author renhongxiang
 */
@Controller
public class RMEmailCertifyController extends UserEmailCertifyController{
    
    @RequestMapping(value = "/emailCertify")
    public String logout(HttpServletRequest request,ModelMap model) {
        return this.pageRequestHandle(request, model);
    }
    
}
