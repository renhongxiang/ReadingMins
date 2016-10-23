/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.login;

import com.readingmins.controller.register.UserAccountBean;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
public class UserLoginController {
    
    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public String login(ModelMap model) {
//        RM_AppInit.initApp();
        model.addAttribute("userForm", new UserAccountBean());
        return "Login"; // this is which page to use.
    }
    
    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public String loginPost(HttpServletRequest request, @ModelAttribute("userForm") UserAccountBean bean, BindingResult result, ModelMap model) {
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
                        return "redirect:addRecord";    // go to submit minutes
                    }else if(students.size() > 1){
                        ApplicationFlow.GotoSelectStudent(sessData, students);
                        return "redirect:selectStudent"; // select student
                    }
                }
                return "redirect:addStudent"; // create student
                
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
        return "Login"; // this is which page to use.
    }
    
    private List<RM_Student> loadStudentsByUser(RY_User user){
        LoaderStudentsByUser loader = new LoaderStudentsByUser();
        return loader.loadListByUser(user);
    }
    
}
