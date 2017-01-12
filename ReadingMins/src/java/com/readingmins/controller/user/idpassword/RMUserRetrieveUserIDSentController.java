/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.user.idpassword;

import com.framework.controller.account.idpasswordreset.UserRetrieveUserIDSentController;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author renhongxiang
 */
@Controller
public class RMUserRetrieveUserIDSentController extends UserRetrieveUserIDSentController{

    @RequestMapping(value = "/userForgotIDSent")
    public String rmUserIDSent(HttpServletRequest request,ModelMap model) {
        return this.userIDSent(request, model);
    }
    
}
