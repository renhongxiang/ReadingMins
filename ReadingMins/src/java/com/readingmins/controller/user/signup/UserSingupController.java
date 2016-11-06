/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.user.signup;

import com.readingmins.controller.user.UserControllerBase;
import com.readingmins.web.app.WebUtils;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Scope;
import rcommon.utils.datastructure.ArrayUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rcommon.process.logics.RegisterUserLogic;
import rcommon.rdata.common.RY_User;
import rcommon.rerror.RErrorItem;
import rcommon.rerror.RErrorManager;
import rcommon.rerror.RErrorPair;
import rm_lib.application.workflow.ApplicationFlow;
import rm_lib.sess.RM_SessionData;

/**
 *
 * @author renhongxiang
 */
@Controller
@Scope("session")
public class UserSingupController extends UserControllerBase{
    
    @RequestMapping(value = "/userSignup", method = RequestMethod.GET)
    public String signUp(HttpServletRequest request, ModelMap model) {
        this.controllerPageIn(request, model);

        model.addAttribute("signOnForm", new UserAccountBean());
        return "userSignup"; // this is which page to use.
    }

    
    @RequestMapping(value = "/userSignup", method = RequestMethod.POST)
    public String signUpPost(HttpServletRequest request, @ModelAttribute("signOnForm") UserAccountBean bean, BindingResult result, ModelMap model) {
        this.controllerPageIn(request, model);

        if(bean != null){
            String userID = bean.getUserName();
            if(userID != null){
                if(this.verifyPasswordSame(bean)){
                    String host = WebUtils.getWebSite(request);
                    RY_User user = UserAccountBean.createUserFromBean(bean);
                    RegisterUserLogic logic = new RegisterUserLogic();
                    if(logic.doRegisterUser(user, host)){
                        RM_SessionData sessData = WebUtils.getSessionData(request);
                        ApplicationFlow.UserRegistered(sessData, user);
                        return "redirect:userConfirm";
                    }else{
                        if(result != null){
                            RErrorManager errMan = logic.getErrorManager();
                            if(errMan != null){
                                List<RErrorItem> errList = errMan.getErrorItemList();
                                if(errList != null){
                                    for(RErrorItem err:errList){
                                        RErrorPair pair = err.getErrorPair();
                                        if(pair != null){
                                            result.rejectValue(pair.getType(),pair.getType(),pair.getMessage());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }else{
                    result.rejectValue("password","password","Password do not match");
                    result.rejectValue("passwordConfirm","passwordConfirm","Password do not match");
                }
            }
        }
        return "userSignup"; // this is which page to use.
    }
    
    private boolean verifyPasswordSame(UserAccountBean bean){
        if(bean != null){
            char[] password = bean.getPassword();
            char[] passwordConfirm = bean.getPasswordConfirm();
            if(ArrayUtils.isCharArraySame(password, passwordConfirm)){
                return true;
            }
        }
        return false;
    }
    
}
