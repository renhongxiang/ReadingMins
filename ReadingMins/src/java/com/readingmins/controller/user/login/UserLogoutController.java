/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.user.login;

import com.readingmins.controller.user.UserControllerBase;
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
public class UserLogoutController extends UserControllerBase{
    
    
    @RequestMapping(value = "/userLogout")
    public String logout(HttpServletRequest request,ModelMap model) {        
        this.controllerPageIn(request, model);
        HttpSession session = request.getSession();
        if(session != null){
            session.invalidate();
        }
        return "redirect:userLogin"; // this is which page to use.
    }
    
}
