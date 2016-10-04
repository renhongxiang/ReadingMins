/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rm_lib.application.init.RM_AppInit;

/**
 *
 * @author renhongxiang
 */
@Controller
@RequestMapping("/")
public class HelloWorldController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
        model.addAttribute("greeting", "Hello World from Spring 4 MVC");
        return "test"; // this is which page to use.
    }

    @RequestMapping(value = "/helloagain", method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap model) {
        model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
        return "welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
        model.addAttribute("userForm", new LoginInBean());
        RM_AppInit.initApp();
        return "login"; // this is which page to use.
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(@ModelAttribute("userForm") LoginInBean login, BindingResult result, ModelMap model) {
        if(login != null){
            String userID = login.getUserID();
            char[] password = login.getPassword();
            if(userID != null){
                
            }
        }
        return "login"; // this is which page to use.
    }
}
