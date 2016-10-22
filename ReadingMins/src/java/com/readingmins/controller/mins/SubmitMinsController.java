/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.mins;

import com.readingmins.controller.studentlevel.StudentLevelController;
import com.readingmins.web.app.WebUtils;
import java.math.BigDecimal;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rcommon.rdata.dataformat.RMonth;
import rm_lib.data.RM_ReadingMins;
import rm_lib.data.RM_Student;
import rm_lib.process.loader.LoaderStudentTotalMinsByMonth;
import rm_lib.process.logics.AddReadingRecordLogic;
import rm_lib.sess.RM_SessionData;

/**
 *
 * @author renhongxiang
 */
@Controller
@Scope("session")
public class SubmitMinsController extends StudentLevelController{

    @RequestMapping(value = "/addRecord", method = RequestMethod.GET)
    public String submitMinsGet(HttpServletRequest request, ModelMap model) {

        this.prepareMenuInfo(request, model);
        
        SubmitMins mins = new SubmitMins();
        mins.setDate(new Date());
        mins.setMins(30);
        model.addAttribute("minsForm", mins);
        
        return "addRecord"; // this is which page to use.
    }
    
    @RequestMapping(value = "/addRecord", method = RequestMethod.POST)
    public String submitMinsPost(HttpServletRequest request, @ModelAttribute("minsForm") SubmitMins bean, BindingResult result, ModelMap model) {
        if(bean != null){
            RM_SessionData sessData = WebUtils.getSessionData(request);
            RM_Student student = WebUtils.getSessCurStudent(request);
            RM_ReadingMins readingRec = new RM_ReadingMins();
            readingRec.setStudent(student);
            bean.fillIntoReadingRec(readingRec);
            AddReadingRecordLogic logic = new AddReadingRecordLogic();
            if(logic.doSaveReadingInfo(readingRec, sessData.getLoginUser())){

                model.addAttribute("rm_Date", readingRec.getReadDate());
                model.addAttribute("rm_Title", readingRec.getBookTitle());
                model.addAttribute("rm_Mins", readingRec.getReadMins());

                RMonth month = RMonth.getCurrMonth();
                model.addAttribute("curMonth", RMonth.monthToString(month, RMonth.MONTH_TEMPLATE_US));
                
                LoaderStudentTotalMinsByMonth monthMinsLogic = new LoaderStudentTotalMinsByMonth();
                BigDecimal totalMins = monthMinsLogic.getTotalMinsByMonth(student, month, WebUtils.getLoginUser(request));
                model.addAttribute("curmins", totalMins.toString());

                return "addRecord";
            }
        }
        return "addRecord"; // this is which page to use.
    }    
    
}
