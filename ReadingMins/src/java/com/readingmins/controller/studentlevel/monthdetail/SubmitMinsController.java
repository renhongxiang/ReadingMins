/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.studentlevel.monthdetail;

import com.readingmins.web.app.WebUtils;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rcommon.rdata.dataformat.RMonth;
import rcommon.rdata.iosystem.DataIOIdentity;
import rm_lib.application.workflow.ApplicationFlow;
import rm_lib.application.workflow.RM_SessDataGroupAddLog;
import rm_lib.application.workflow.RM_SessDataGroupMonthly;
import rm_lib.data.RM_ReadingMins;
import rm_lib.data.RM_Student;
import rm_lib.process.logics.AddReadingRecordLogic;
import rm_lib.sess.RM_SessDataGroup;
import rm_lib.sess.RM_SessionData;

/**
 *
 * @author renhongxiang
 */
@Controller
@Scope("session")
public class SubmitMinsController extends DetailControllerBase{
    
    @Override
    protected RM_SessDataGroup createPageData(){
        return new RM_SessDataGroupAddLog();
    }
    
    @RequestMapping(value = "/addRecord", method = RequestMethod.GET)
    public String submitMinsGet(HttpServletRequest request, @ModelAttribute("month") String beanMonth, ModelMap model) {

        this.controllerPageIn(request);
        
        this.prepareModel(request, beanMonth, model);
        
        return "addRecord"; // this is which page to use.
    }
    
    @RequestMapping(value = "/addRecord", method = RequestMethod.POST)
    public String submitMinsPost(HttpServletRequest request, 
                @ModelAttribute("monthReadingLog") ReadingLogMonthBean bean, 
                @ModelAttribute("month") String beanMonth,
                ModelMap model) {
        
        this.controllerPageIn(request);
        
        String buttonStr = request.getParameter("saveNew");
        if(buttonStr != null){
            this.doSaveNewRec(request, bean);
        }
        
        if(this.processEditRec(request, bean)){
            return "redirect:minsEdit";
        }
        
        
        this.prepareModel(request, beanMonth, model);
        
        return "addRecord"; // this is which page to use.
    }    

    protected boolean processEditRec(HttpServletRequest request,ReadingLogMonthBean bean){
        if(request != null){
            RM_SessionData sessData = WebUtils.getSessionData(request);
            List<RM_ReadingMins> minsList = sessData.getSelectMinList();
            if(minsList != null){
                for(RM_ReadingMins item : minsList){
                    if(item != null){
                        DataIOIdentity ioID = item.getMinsIOID();
                        if(ioID != null && ioID.isValueValid()){
                            long ID = ioID.getIndentifyID();
                            String code = "monthReadingLog" + ID;
                            String buttonStr = request.getParameter(code);
                            if(buttonStr != null){
                                ApplicationFlow.SelectReadingLog(sessData, item);
                                return true;
                            }
                        }
                    }
                }
            }
            
        }
        return false;
    }
    
    protected boolean doSaveNewRec(HttpServletRequest request,ReadingLogMonthBean bean){
        if(bean != null){
            RM_SessionData sessData = WebUtils.getSessionData(request);
            RM_Student student = WebUtils.getSessCurStudent(request);
            RM_ReadingMins readingRec = new RM_ReadingMins();
            readingRec.setStudent(student);
            readingRec.setBookTitle(bean.getTitle());
            readingRec.setReadDate(bean.getDate());
            readingRec.setReadMins(bean.getMins());
            
            AddReadingRecordLogic logic = new AddReadingRecordLogic();
            if(logic.doSaveReadingInfo(readingRec, sessData.getLoginUser())){
                return true;
            }
        }
        return false;
    }
    
    protected void prepareModel(HttpServletRequest request, @ModelAttribute("month") String beanMonth, ModelMap model){
        this.prepareMenuInfo(request, model);
        
        RMonth month = RMonth.stringToMonth(beanMonth, RMonth.MONTH_TEMPLATE_US);
        if(month == null){
            RM_SessDataGroup group = WebUtils.getCurSessDataGroup(request);
            if(group instanceof RM_SessDataGroupMonthly){
                RM_SessDataGroupMonthly detailGroup = (RM_SessDataGroupMonthly)group;
                month = detailGroup.getCurMonth();
            }
        }
        if(month == null){
            month = RMonth.getCurrMonth();
        }

        Date selectDate = new Date();        
        if(!month.dateInMonth(selectDate)){
            selectDate = month.getMonthLastDate();
        }
        
        ReadingLogMonthBean bean = this.getBean();
        bean.setDate(selectDate);
        bean.setMins(30);
        
        this.buildMonthlyEdtailPage(request, model, month);
        
    }
    
}
