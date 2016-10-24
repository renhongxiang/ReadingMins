/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.user.login;

import com.readingmins.controller.user.UserControllerBase;
import com.readingmins.controller.user.signup.UserAccountBean;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rcommon.process.logics.LoginUserLogic;
import rcommon.rdata.common.RY_User;
import rcommon.rerror.RErrorItem;
import rcommon.rerror.RErrorManager;
import rcommon.rerror.RErrorPair;
import rm_lib.application.workflow.ApplicationFlow;
import rm_lib.data.RM_Student;
import rm_lib.process.loader.LoaderStudentsByUser;
import rm_lib.sess.RM_SessionData;

/**
 *
 * @author renhongxiang
 */
@Controller
@Scope("session")
public class UserLoginController extends UserControllerBase{
    
    @RequestMapping(value = "/userLogin", method = RequestMethod.GET)
    public String login(HttpServletRequest request, ModelMap model) {
        this.controllerPageIn(request);
        model.addAttribute("userForm", new UserAccountBean());
        return "userLogin"; // this is which page to use.
    }
    
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public String loginPost(HttpServletRequest request, @ModelAttribute("userForm") UserAccountBean bean, BindingResult result, ModelMap model) {
        this.controllerPageIn(request);
        if(bean != null){
            RY_User user = UserAccountBean.createUserFromBean(bean);
            LoginUserLogic logic = new LoginUserLogic();
            if(logic.doLoginUser(user)){                
                HttpSession session = request.getSession(true);
                RM_SessionData sessData = new RM_SessionData();
                session.setAttribute("sessdata", sessData);
                ApplicationFlow.UserLogin(sessData, user);
                
                
                List<RM_Student> students = loadStudentsByUser(user);
                if(students != null){
                    if(students.size() == 1){
                        RM_Student student = students.get(0);
                        ApplicationFlow.StudentSelected(sessData, student);
                        return "redirect:readingLogAdd";    // go to submit minutes
                    }else if(students.size() > 1){
                        ApplicationFlow.GotoSelectStudent(sessData, students);
                        return "redirect:studentSelect"; // select student
                    }
                }
                return "redirect:studentAdd"; // create student
                
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
        return "userLogin"; // this is which page to use.
    }
    
    private List<RM_Student> loadStudentsByUser(RY_User user){
        LoaderStudentsByUser loader = new LoaderStudentsByUser();
        return loader.loadListByUser(user);
    }
    
}
