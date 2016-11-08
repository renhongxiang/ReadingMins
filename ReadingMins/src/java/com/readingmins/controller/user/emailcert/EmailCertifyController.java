/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.user.emailcert;

import com.readingmins.controller.user.UserControllerBase;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import rcommon.process.logics.operation.VerifyCertifyEmailOperation;
import rcommon.rdata.common.RY_User;

/**
 *
 * @author renhongxiang
 */
@Controller
public class EmailCertifyController extends UserControllerBase{
    
    public static String PAGE_NAME = "CertifyEmail";
    
    @RequestMapping(value = "/CertifyEmail")
    public String logout(HttpServletRequest request,ModelMap model) {        
        this.controllerPageIn(request, model);
        
        EmailCertifyBean bean = new EmailCertifyBean();
        
        String code = (String)request.getParameter("Code");
        
        VerifyCertifyEmailOperation op = new VerifyCertifyEmailOperation();
        op.setCertiryCode(code);
        if(op.DoOperation()){
            bean.setCertified(true);
            RY_User user = op.getUser();
            if(user != null){
                bean.setUserName(user.getUserID());
                bean.setEmail(user.getAcctEmail());
            }
        }else{
            bean.setCertified(false);
        }
        
        model.addAttribute("certifyBean", bean);

        return getControllerPageName(); // this is which page to use.
    }

    @Override
    public String getControllerPageName() {
        return PAGE_NAME;
    }
    
}
