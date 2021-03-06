/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.student;

import com.readingmins.controller.base.RM_LoginedControllerBase;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rcommon.rdata.common.RY_User;
import rcommon.rerror.RErrorItem;
import rcommon.rerror.RErrorManager;
import rcommon.rerror.RErrorPair;
import rm_lib.application.workflow.ApplicationFlow;
import rm_lib.data.RM_Student;
import rm_lib.process.logics.NewStudentLogic;
import rm_lib.sess.RM_SessionData;

/**
 *
 * @author renhongxiang
 */
@Controller
@Scope("session")
public class StudentAddController extends RM_LoginedControllerBase{
    
    public static String PAGE_NAME = "studentAdd"; 
    
    @RequestMapping(value = "/studentAdd", method = RequestMethod.GET)
    public String addStudentGet(HttpServletRequest request, ModelMap model) {
        String page = this.controllerPageIn(request, model);
        if(page != null){
            return page;
        }
        model.addAttribute("addStudentForm", new StudentBean());
        return getControllerPageName(); // this is which page to use.
    }

    @RequestMapping(value = "/studentAdd", method = RequestMethod.POST)
    public String addStudentPost(HttpServletRequest request, @ModelAttribute("addStudentForm") StudentBean bean, BindingResult result, ModelMap model) {
        String page = this.controllerPageIn(request, model);
        if(page != null){
            return page;
        }
        if(bean != null){
            RY_User user = this.getLoginUser(request);
            if(user != null){
                RM_Student student = RM_Student.createInstance();
                if(student != null){
                    student.setUser(user);
                    StudentBean.fillStudentInfoFromBean(student,bean);
                    // save student
                    NewStudentLogic logic = new NewStudentLogic();
                    if(logic.doCreateNewStudent(student, user)){
                        RM_SessionData sessData = this.getRMSessionData(request);
                        ApplicationFlow.StudentSelected(sessData, student);
                        
                        return "redirect:readingLogAdd";
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
        return getControllerPageName(); // this is which page to use.
    }

    @Override
    public String getControllerPageName() {
        return PAGE_NAME;
    }
    
}
