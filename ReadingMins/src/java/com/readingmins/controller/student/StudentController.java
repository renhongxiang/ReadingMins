/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.student;

import com.readingmins.web.app.WebUtils;
import java.util.ArrayList;
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
import rm_lib.process.loader.LoaderStudentsByUser;
import rm_lib.process.logics.NewStudentLogic;
import rm_lib.sess.RM_SessionData;

/**
 *
 * @author renhongxiang
 */
@Controller
@Scope("session")
public class StudentController {
    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public String addStudentGet(ModelMap model) {
        model.addAttribute("addStudentForm", new StudentBean());
        return "addStudent"; // this is which page to use.
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudentPost(HttpServletRequest request, @ModelAttribute("addStudentForm") StudentBean bean, BindingResult result, ModelMap model) {
        if(bean != null){
            RY_User user = WebUtils.getLoginUser(request);
            if(user != null){
                RM_Student student = new RM_Student();
                if(student != null){
                    student.setUser(user);
                    StudentBean.fillStudentInfoFromBean(student,bean);
                    // save student
                    NewStudentLogic logic = new NewStudentLogic();
                    if(logic.doCreateNewStudent(student, user)){
                        
                        return "redirect:addRecord";
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
        return "addStudent"; // this is which page to use.
    }
    
    
    private List<StudentBean> buildStudentBeanList(List<RM_Student> dataList){
        if(dataList != null){
            List<StudentBean> beanList = new ArrayList<StudentBean>();
            if(beanList != null){
                for(int i=0; i<dataList.size();i++){
                    RM_Student student = dataList.get(i);
                    StudentBean bean = new StudentBean();
                    StudentBean.fileBeanWithStudentInfo(bean, student);
                    bean.setOrderID(i);
                    beanList.add(bean);
                }
            }
            return beanList;
        }
        return null;
    }

    private List<RM_Student> loadStudentsByUser(RY_User user){
        LoaderStudentsByUser loader = new LoaderStudentsByUser();
        return loader.loadListByUser(user);
    }
    
    @RequestMapping(value = "/selectStudent", method = RequestMethod.GET)
    public String selectStudentGet(HttpServletRequest request, ModelMap model) {
        RY_User user = WebUtils.getLoginUser(request);            
        List<RM_Student> rmStudents = this.loadStudentsByUser(user);
        
        RM_SessionData sessData = WebUtils.getSessionData(request);        
        ApplicationFlow.SelectStudentFromList(sessData, rmStudents);
        List<StudentBean> studentList = buildStudentBeanList(rmStudents);
        
        StudentBeanList contactForm = new StudentBeanList();
        contactForm.setStudents(studentList);
        model.put("studentList", contactForm);
        return "selectStudent"; // this is which page to use.
    }
    
    @RequestMapping(value = "/selectStudent", method = RequestMethod.POST)
    public String selectStudentPost(HttpServletRequest request, ModelMap model) {
        List<RM_Student> studentList = WebUtils.getSessStudentList(request);
        if(studentList != null){
            for(int i=0;i<studentList.size();i++){
                RM_Student student = studentList.get(i);
                if(student != null){
                    String button = request.getParameter("firstName"+i);
                    if(button == null){
                        button = request.getParameter("lastName"+i);
                    }
                    if(button != null){
                        RM_SessionData sessData = WebUtils.getSessionData(request);
                        ApplicationFlow.StudentSelected(sessData, student);
                        return "redirect:detail";
                    }
                }
            }
        }
        return "selectStudent"; // this is which page to use.
    }

}
