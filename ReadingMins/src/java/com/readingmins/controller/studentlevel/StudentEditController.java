/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.studentlevel;

import com.readingmins.controller.student.StudentBean;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rcommon.rdata.common.RY_DataBase;
import rcommon.rdata.common.RY_User;
import rm_lib.data.RM_Student;
import rm_lib.process.logics.EditStudentLogic;

/**
 *
 * @author renhongxiang
 */
@Controller
@Scope("session")
public class StudentEditController extends StudentLevelController{
    
    public static String PAGE_NAME = "studentEdit";
    
    @RequestMapping(value = "/studentEdit", method = RequestMethod.GET)
    public String editStudentGet(HttpServletRequest request, ModelMap model) {
        
        this.controllerPageIn(request, model);
        
        this.prepareMenuInfo(request, model);
        StudentBean bean = new StudentBean();
        
        
        RM_Student student = this.getStudent(request);
        StudentBean.fileBeanWithStudentInfo(bean, student);
        model.addAttribute("editStudentForm", bean);
        return getControllerPageName(); // this is which page to use.
    }

    @RequestMapping(value = "/studentEdit", params = "Save", method = RequestMethod.POST)
    public String editStudentPostSave(HttpServletRequest request, @ModelAttribute("editStudentForm") StudentBean bean, ModelMap model) {
        
        this.controllerPageIn(request, model);
        
        this.prepareMenuInfo(request, model);
        if(bean != null){
            RM_Student student = this.getStudent(request);
            if(student != null){
                StudentBean.fillStudentInfoFromBean(student, bean);
                EditStudentLogic logic = new EditStudentLogic();
                RY_User user = this.getLoginUser(request);
                logic.doSaveStudent(student, user);
            }
        }
        return getControllerPageName(); // this is which page to use.
    }

    @RequestMapping(value = "/studentEdit", params = "Delete", method = RequestMethod.POST)
    public String editStudentPostDelete(HttpServletRequest request, @ModelAttribute("editStudentForm") StudentBean bean, ModelMap model) {

        this.controllerPageIn(request, model);
        
        RM_Student student = this.getStudent(request);
        if(student != null){
            student.setStatus(RY_DataBase.STATUS_INACTIVE);
            EditStudentLogic logic = new EditStudentLogic();
            RY_User user = this.getLoginUser(request);
            logic.doSaveStudent(student, user);
        }        
        return "redirect:studentSelect"; // this is which page to use.
    }

    @Override
    public String getControllerPageName() {
        return PAGE_NAME;
    }
    
}
