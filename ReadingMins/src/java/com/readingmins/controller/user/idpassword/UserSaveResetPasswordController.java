/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.user.idpassword;

import com.readingmins.controller.base.SessionController;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rcommon.data.session.RSessionDataBase;
import rcommon.data.session.RSessionDataPackage;
import rcommon.data.session.RSessionDataPasswordResetPackage;
import rcommon.process.logics.operation.SaveResetedPasswordOperation;
import rcommon.process.logics.operation.VerifyResetPasswordOperation;
import rcommon.rdata.common.RY_User;
import rm_lib.sess.RM_SessionData;

/**
 *
 * @author renhongxiang
 */
@Controller
@Scope("session")
public class UserSaveResetPasswordController extends SessionController{
    
    public static String PAGE_NAME = "userResetPassword";
    
    @Override
    protected RSessionDataPackage createPageData(){
        return new RSessionDataPasswordResetPackage();
    }
    
    @RequestMapping(value = "/ResetPassword", method = RequestMethod.GET)
    public String resetPwd(HttpServletRequest request,ModelMap model) {
        
        this.controllerPageIn(request, model);

        String code = (String)request.getParameter("Code");
        
        VerifyResetPasswordOperation op = new VerifyResetPasswordOperation();
        op.setCertiryCode(code);
        if(op.DoOperation()){
            RSessionDataBase sessData = this.getSessionData(request);
            RY_User user = op.getUser();
            this.setSetPasswordUser(sessData, user);
//            bean.setCertified(true);
//            RY_User user = op.getUser();
//            if(user != null){
//                bean.setUserName(user.getUserID());
//                bean.setEmail(user.getAcctEmail());
//            }
        }else{
//            bean.setCertified(false);
        }
        
        UserSaveResetPasswordBean bean = new UserSaveResetPasswordBean();
        model.addAttribute("resetPassword", bean);

        return this.getControllerPageName(); // this is which page to use.
    }

    @RequestMapping(value = "/ResetPassword", method = RequestMethod.POST)
    public String resetPwdPost(HttpServletRequest request,
            @ModelAttribute("resetPassword") UserSaveResetPasswordBean pwdBean, ModelMap model) {

        this.controllerPageIn(request, model);

        if(pwdBean != null){
            String password1 = pwdBean.getPassword1();
            String password2 = pwdBean.getPassword2();
            
            RSessionDataBase sessData = 
                    this.getSessionData(request);
            RY_User user = this.getSetPasswordUser(sessData);
            if(StringUtils.equals(password1, password2)){
                user.setPassword(password2);
                SaveResetedPasswordOperation op = new SaveResetedPasswordOperation();
                op.setUser(user);
                if(op.DoOperation()){
                    return "redirect:userResetPasswordConfirm";
                }
            }
        }
        
        return getControllerPageName(); // this is which page to use.
    }
    
    public RY_User getSetPasswordUser(RSessionDataBase sessData){
        RSessionDataPackage curPackage = sessData.getCurPackage();
        if(curPackage != null){
            if(curPackage instanceof RSessionDataPasswordResetPackage){
                return ((RSessionDataPasswordResetPackage) curPackage).getResetPasswordUser();
            }
        }
        return null;
    }

    public void setSetPasswordUser(RSessionDataBase sessData, RY_User user){
        RSessionDataPackage curPackage = sessData.getCurPackage();
        if(curPackage != null){
            if(curPackage instanceof RSessionDataPasswordResetPackage){
                ((RSessionDataPasswordResetPackage) curPackage).setResetPasswordUser(user);
            }
        }
    }

    @Override
    public String getControllerPageName() {
        return PAGE_NAME;
    }
    
}
