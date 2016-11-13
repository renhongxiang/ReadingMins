/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.user.login;

import com.framework.controller.account.login.UserLoginController;
import com.framework.controller.account.register.UserAccountBean;
import com.readingmins.controller.student.StudentAddController;
import com.readingmins.controller.student.StudentSelectController;
import com.readingmins.controller.studentlevel.monthdetail.ReadingLogAddController;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rcommon.data.session.RSessionDataBase;
import rcommon.rdata.common.RY_User;
import rm_lib.application.workflow.ApplicationFlow;
import rm_lib.data.RM_Student;
import rm_lib.process.loader.LoaderStudentsByUser;

/**
 *
 * @author renhongxiang
 */

@Controller
@Scope("session")
public class RMUserLoginController extends UserLoginController{
    
    @RequestMapping(value = "/userLogin", method = RequestMethod.GET)
    public String rmLoginGet(HttpServletRequest request, ModelMap model) {
        return this.loginGet(request, model);
    }
    
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public String rmLoginPost(HttpServletRequest request, @ModelAttribute("userForm") UserAccountBean bean, BindingResult result, ModelMap model) {
        return this.loginPost(request, bean, result, model);
    }
    
    @Override
    protected String getLoginedPageName(HttpServletRequest request){
        RY_User user = this.getLoginUser(request);
        RSessionDataBase sessData = this.getSessionData(request);
        
        List<RM_Student> students = loadStudentsByUser(user);
        if(students != null){
            if(students.size() == 1){
                RM_Student student = students.get(0);
                ApplicationFlow.StudentSelected(sessData, student);
                return this.redirectToPage(ReadingLogAddController.PAGE_NAME);
            }else if(students.size() > 1){
                ApplicationFlow.GotoSelectStudent(sessData, students);
                return this.redirectToPage(StudentSelectController.PAGE_NAME);
            }
        }
        return this.redirectToPage(StudentAddController.PAGE_NAME);
    }
    
    private List<RM_Student> loadStudentsByUser(RY_User user){
        LoaderStudentsByUser loader = new LoaderStudentsByUser();
        return loader.loadListByUser(user);
    }
    
}
