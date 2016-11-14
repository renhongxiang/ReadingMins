/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.studentlevel.monthdetail;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rcommon.data.session.RSessionDataPackage;
import rcommon.rdata.dataformat.RMonth;
import rcommon.rdata.iosystem.DataIOIdentity;
import rcommon.rerror.RErrorItem;
import rcommon.rerror.RErrorManager;
import rcommon.rerror.RErrorPair;
import rcommon.utils.datatype.RStringUtils;
import rm_lib.application.workflow.ApplicationFlow;
import rm_lib.application.workflow.RM_SessDataGroupAddLog;
import rm_lib.application.workflow.RM_SessDataGroupMonthly;
import rm_lib.data.RM_ReadingMins;
import rm_lib.data.RM_Student;
import rm_lib.process.logics.AddReadingRecordLogic;
import rm_lib.sess.RM_SessionData;

/**
 *
 * @author renhongxiang
 */
@Controller
@Scope("session")
public class ReadingLogAddController extends MonthlyDetailControllerBase{
    
    public static String PAGE_NAME = "readingLogAdd";
    
    @Override
    protected RSessionDataPackage createPageData(){
        return new RM_SessDataGroupAddLog();
    }
    
    @RequestMapping(value = "/readingLogAdd", method = RequestMethod.GET)
    public String submitMinsGet(HttpServletRequest request, @ModelAttribute("monthReadingLog") ReadingLogMonthBean beanMonth, ModelMap model) {

        this.controllerPageIn(request, model);
        
        this.prepareModel(request, beanMonth, model);
        
        return getControllerPageName(); // this is which page to use.
    }
    
    @RequestMapping(value = "/readingLogAdd", method = RequestMethod.POST)
    public String submitMinsPost(HttpServletRequest request, 
                @ModelAttribute("monthReadingLog") ReadingLogMonthBean beanMonth, 
                @ModelAttribute("monthpost") String hiddenMonth, 
                BindingResult result, 
                ModelMap model) {
        
        this.controllerPageIn(request, model);
        
        if(RStringUtils.isNotBlank(hiddenMonth)){
            beanMonth.setMonth(hiddenMonth);
        }
        
        String buttonStr = request.getParameter("saveNew");
        if(buttonStr != null){
            this.doSaveNewRec(request,result, beanMonth);
        }
        
        if(this.processEditRec(request, beanMonth)){ 
            return "redirect:readingLogEdit";
        }
        
        this.prepareModel(request, beanMonth, model);
        
        return getControllerPageName(); // this is which page to use.
    }    

    protected boolean processEditRec(HttpServletRequest request,ReadingLogMonthBean bean){
        if(request != null){
            RM_SessionData sessData = this.getRMSessionData(request);
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
    
    protected boolean doSaveNewRec(HttpServletRequest request,BindingResult result, ReadingLogMonthBean bean){
        if(bean != null){
            RM_SessionData sessData = this.getRMSessionData(request);
            RM_Student student = this.getStudent(request);
            RM_ReadingMins readingRec = new RM_ReadingMins();
            readingRec.setStudent(student);
            readingRec.setBookTitle(bean.getTitle());
            readingRec.setReadDate(bean.getDate());
            readingRec.setReadMins(bean.getMins());
            
            AddReadingRecordLogic logic = new AddReadingRecordLogic();
            if(logic.doSaveReadingInfo(readingRec, sessData.getLoginUser())){
                return true;
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
        return false;
    }
    
    protected void prepareModel(HttpServletRequest request, ReadingLogMonthBean beanMonth, ModelMap model){
        
        this.prepareMenuInfo(request, model);
        
        RMonth month = RMonth.stringToMonth(beanMonth.getMonth(), RMonth.MONTH_TEMPLATE_US);
        if(month == null){
            RSessionDataPackage group = this.getCurPackage(request);
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
        
        this.setBean(beanMonth);
        
        ReadingLogMonthBean bean = this.getBean();
        bean.setDate(selectDate);
        bean.setMins(30);
        bean.setMonth(RMonth.monthToString(month, RMonth.MONTH_TEMPLATE_US));
        
        this.buildMonthlyEdtailPage(request, model, month);
        
    }

    @Override
    public String getControllerPageName() {
        return PAGE_NAME;
    }
    
}
