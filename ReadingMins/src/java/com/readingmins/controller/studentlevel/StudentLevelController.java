/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.studentlevel;

import com.readingmins.web.app.WebUtils;
import com.readingmins.controller.base.RM_LoginedControllerBase;
import com.readingmins.web.app.RMWebUtils;
import java.math.BigDecimal;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.ModelMap;
import rcommon.data.session.RSessionDataPackage;
import rcommon.rdata.dataformat.RMonth;
import rm_lib.application.workflow.RM_SessDataGroupStudentBase;
import rm_lib.data.RM_Student;
import rm_lib.process.loader.LoaderStudentTotalMinsByMonth;
import rm_lib.sess.RM_SessionData;

/**
 *
 * @author renhongxiang
 */
public abstract class StudentLevelController extends RM_LoginedControllerBase{
    
    @Override
    protected RSessionDataPackage createPageData(){
        return new RM_SessDataGroupStudentBase();
    }
    
    
    protected void prepareMenuInfo(HttpServletRequest request, ModelMap model){
        WebUtils util = WebUtils.getInstance();
        if(util != null){
            if(util instanceof RMWebUtils){
                RMWebUtils rmUtils = (RMWebUtils)util;
                RM_Student student = rmUtils.getSessCurStudent(request);
                if(student != null){
                    student.doLoad();
                    String name = student.getFirstLastName();
                    model.addAttribute("studentName", name);
                }

                RMonth month = RMonth.getCurrMonth();
                model.addAttribute("curMonth", RMonth.monthToString(month, RMonth.MONTH_TEMPLATE_US));

                LoaderStudentTotalMinsByMonth monthMinsLogic = new LoaderStudentTotalMinsByMonth();
                BigDecimal totalMins = monthMinsLogic.getTotalMinsByMonth(student, month, rmUtils.getLoginUser(request));
                model.addAttribute("curmins", totalMins.toString());
            }
        }
    }

    protected RM_Student getStudent(HttpServletRequest request){
        RM_SessionData sessData = this.getRMSessionData(request);
        if(sessData != null){
            return sessData.getCurStudent();
        }
        return null;
    }
    
}
