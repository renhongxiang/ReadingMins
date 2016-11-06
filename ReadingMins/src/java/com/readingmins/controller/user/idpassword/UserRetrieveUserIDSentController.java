/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.user.idpassword;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author renhongxiang
 */
@Controller
public class UserRetrieveUserIDSentController {
    
    @RequestMapping(value = "/userForgotIDSent")
    public String userIDSent(HttpServletRequest request,ModelMap model) {
        
        return "userForgotIDSent"; // this is which page to use.
    }
    
}
