/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author renhongxiang
 */
@Controller
public class UserLogoutController {
    
    @RequestMapping(value = "/Logout")
    public String logout(HttpServletRequest request,ModelMap model) {        
        HttpSession session = request.getSession();
        if(session != null){
            session.invalidate();
        }
        return "redirect:Login"; // this is which page to use.
    }
    
}
