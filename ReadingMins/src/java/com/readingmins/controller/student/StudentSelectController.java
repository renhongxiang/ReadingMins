/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.student;

import com.readingmins.controller.base.RM_LoginedControllerBase;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rcommon.data.session.RSessionDataBase;
import rcommon.data.session.RSessionDataPackage;
import rcommon.rdata.common.RY_User;
import rm_lib.application.workflow.ApplicationFlow;
import rm_lib.application.workflow.RM_SessDataGroupStudentList;
import rm_lib.data.RM_Student;
import rm_lib.process.loader.LoaderStudentsByUser;

/**
 *
 * @author renhongxiang
 */
@Controller
@Scope("session")
public class StudentSelectController extends RM_LoginedControllerBase{
    
    public static String PAGE_NAME = "studentSelect";
    
    @RequestMapping(value = "/studentSelect", method = RequestMethod.GET)
    public String selectStudentGet(HttpServletRequest request, ModelMap model) {
        
        String page = this.controllerPageIn(request, model);
        if(page != null){
            return page;
        }
        
        RY_User user = this.getLoginUser(request);            
        List<RM_Student> rmStudents = this.loadStudentsByUser(user);
        
//        this.getRMSessionData(request).getCurPackage();

        RSessionDataPackage curDataGroup = this.getCurPackage(request);
        if(curDataGroup instanceof RM_SessDataGroupStudentList){
            RM_SessDataGroupStudentList studentListGroup = (RM_SessDataGroupStudentList)curDataGroup;
            studentListGroup.setStudentList(rmStudents);
        }

        
        List<StudentBean> studentList = buildStudentBeanList(rmStudents);
        
        StudentBeanList contactForm = new StudentBeanList();
        contactForm.setStudents(studentList);
        model.put("studentList", contactForm);
        return getControllerPageName(); // this is which page to use.
    }
    
    @RequestMapping(value = "/studentSelect", method = RequestMethod.POST)
    public String selectStudentPost(HttpServletRequest request, ModelMap model) {

        String page = this.controllerPageIn(request, model);
        if(page != null){
            return page;
        }

        List<RM_Student> studentList = null;
        RSessionDataPackage curDataGroup = this.getCurPackage(request);
        if(curDataGroup instanceof RM_SessDataGroupStudentList){
            RM_SessDataGroupStudentList studentListGroup = (RM_SessDataGroupStudentList)curDataGroup;
            studentList = studentListGroup.getStudentList();
        }
        
        if(studentList != null){
            for(int i=0;i<studentList.size();i++){
                RM_Student student = studentList.get(i);
                if(student != null){
                    String button = request.getParameter("firstName"+i);
                    if(button == null){
                        button = request.getParameter("lastName"+i);
                    }
                    if(button != null){
                        RSessionDataBase sessData = this.getSessionData(request);
                        ApplicationFlow.StudentSelected(sessData, student);
                        return "redirect:readingLogAdd";
                    }
                }
            }
        }
        return getControllerPageName(); // this is which page to use.
    }

    @Override
    protected RSessionDataPackage createPageData(){
        return new RM_SessDataGroupStudentList();
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

    @Override
    public String getControllerPageName() {
        return PAGE_NAME;
    }
    
}
