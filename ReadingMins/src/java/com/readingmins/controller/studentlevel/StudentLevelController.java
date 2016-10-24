/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.studentlevel;

import com.readingmins.controller.LoginedControllerBase;
import com.readingmins.web.app.WebUtils;
import java.math.BigDecimal;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.ModelMap;
import rcommon.rdata.dataformat.RMonth;
import rm_lib.application.workflow.RM_SessDataGroupStudentBase;
import rm_lib.data.RM_Student;
import rm_lib.process.loader.LoaderStudentTotalMinsByMonth;
import rm_lib.sess.RM_SessDataGroup;

/**
 *
 * @author renhongxiang
 */
public class StudentLevelController extends LoginedControllerBase{
    

    @Override
    protected RM_SessDataGroup createPageData(){
        return new RM_SessDataGroupStudentBase();
    }
    
    
    protected void prepareMenuInfo(HttpServletRequest request, ModelMap model){
        RM_Student student = WebUtils.getSessCurStudent(request);
        if(student != null){
            student.doLoad();
            String name = student.getFirstLastName();
            model.addAttribute("studentName", name);
        }
        
        RMonth month = RMonth.getCurrMonth();
        model.addAttribute("curMonth", RMonth.monthToString(month, RMonth.MONTH_TEMPLATE_US));
        
        LoaderStudentTotalMinsByMonth monthMinsLogic = new LoaderStudentTotalMinsByMonth();
        BigDecimal totalMins = monthMinsLogic.getTotalMinsByMonth(student, month, WebUtils.getLoginUser(request));
        model.addAttribute("curmins", totalMins.toString());
    }
}
