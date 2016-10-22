/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.studentlevel;

import com.readingmins.controller.student.StudentBean;
import com.readingmins.web.app.WebUtils;
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
public class EditStudentController extends StudentLevelController{
    
    @RequestMapping(value = "/editStudent", method = RequestMethod.GET)
    public String editStudentGet(HttpServletRequest request, ModelMap model) {
        this.prepareMenuInfo(request, model);
        StudentBean bean = new StudentBean();
        RM_Student student = WebUtils.getSessCurStudent(request);
        StudentBean.fileBeanWithStudentInfo(bean, student);
        model.addAttribute("editStudentForm", bean);
        return "editStudent"; // this is which page to use.
    }

    @RequestMapping(value = "/editStudent", params = "Save", method = RequestMethod.POST)
    public String editStudentPostSave(HttpServletRequest request, @ModelAttribute("editStudentForm") StudentBean bean, ModelMap model) {
        this.prepareMenuInfo(request, model);
        if(bean != null){
            RM_Student student = WebUtils.getSessCurStudent(request);
            if(student != null){
                StudentBean.fillStudentInfoFromBean(student, bean);
                EditStudentLogic logic = new EditStudentLogic();
                RY_User user = WebUtils.getLoginUser(request);
                logic.doSaveStudent(student, user);
            }
        }
        return "editStudent"; // this is which page to use.
    }

    @RequestMapping(value = "/editStudent", params = "Delete", method = RequestMethod.POST)
    public String editStudentPostDelete(HttpServletRequest request, @ModelAttribute("editStudentForm") StudentBean bean, ModelMap model) {
        RM_Student student = WebUtils.getSessCurStudent(request);
        if(student != null){
            student.setStatus(RY_DataBase.STATUS_INACTIVE);
            EditStudentLogic logic = new EditStudentLogic();
            RY_User user = WebUtils.getLoginUser(request);
            logic.doSaveStudent(student, user);
        }        
        return "redirect:selectStudent"; // this is which page to use.
    }
    
}
