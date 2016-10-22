/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author renhongxiang
 */
@Controller
@Scope("session")
public class AppController {
    
    @RequestMapping(value = "/setting", method = RequestMethod.GET)
    public String settingGet(HttpServletRequest request, HttpServletResponse response) {
        return "setting";
    }    
    
    @RequestMapping(value = "/help", method = RequestMethod.GET)
    public String helpGet(HttpServletRequest request, HttpServletResponse response) {
        return "help";
    }    

}
