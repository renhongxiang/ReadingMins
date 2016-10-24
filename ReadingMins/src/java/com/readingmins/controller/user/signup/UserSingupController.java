/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.user.signup;

import com.readingmins.controller.user.UserControllerBase;
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

/**
 *
 * @author renhongxiang
 */
@Controller
@Scope("session")
public class UserSingupController extends UserControllerBase{
    
    @RequestMapping(value = "/userSignup", method = RequestMethod.GET)
    public String signUp(HttpServletRequest request, ModelMap model) {
        this.controllerPageIn(request);
        model.addAttribute("signOnForm", new UserAccountBean());
        return "userSignup"; // this is which page to use.
    }

    
    @RequestMapping(value = "/userSignup", method = RequestMethod.POST)
    public String signUpPost(HttpServletRequest request, @ModelAttribute("signOnForm") UserAccountBean bean, BindingResult result, ModelMap model) {
        this.controllerPageIn(request);
        if(bean != null){
            String userID = bean.getUserName();
            if(userID != null){
                if(this.verifyPasswordSame(bean)){
                    RY_User user = UserAccountBean.createUserFromBean(bean);
                    RegisterUserLogic logic = new RegisterUserLogic();
                    if(logic.doRegisterUser(user)){
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
