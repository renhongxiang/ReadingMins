/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.mins;

import com.readingmins.controller.studentlevel.monthdetail.SubmitMins;
import com.readingmins.controller.studentlevel.StudentLevelController;
import com.readingmins.web.app.WebUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rcommon.rdata.common.RY_DataBase;
import rm_lib.application.workflow.RM_SessDataGroupLog;
import rm_lib.data.RM_ReadingMins;
import rm_lib.process.logics.AddReadingRecordLogic;
import rm_lib.sess.RM_SessDataGroup;
import rm_lib.sess.RM_SessionData;

/**
 *
 * @author renhongxiang
 */
@Controller
@Scope("session")
public class ReadingLogEditController extends StudentLevelController{

    @Override
    protected RM_SessDataGroup createPageData(){
        return new RM_SessDataGroupLog();
    }
    
    
    @RequestMapping(value = "/readingLogEdit", method = RequestMethod.GET)
    public String editMinsGet(HttpServletRequest request, ModelMap model) {

        this.controllerPageIn(request);
        
        this.prepareMenuInfo(request, model);
        
        RM_SessionData sessData = WebUtils.getSessionData(request);
        if(sessData != null){
            RM_ReadingMins curMin = sessData.getCurReadingLog();
            if(curMin != null){
                SubmitMins mins = new SubmitMins();
                mins.setDate(curMin.getReadDate());
                mins.setMins(curMin.getReadMins());
                mins.setTitle(curMin.getBookTitle());
                model.addAttribute("minsForm", mins);
            }
        }
        
        return "readingLogEdit"; // this is which page to use.
    }
    
    @RequestMapping(value = "/readingLogEdit", params = "save", method = RequestMethod.POST)
    public String editMinsPostSave(HttpServletRequest request, @ModelAttribute("minsForm") SubmitMins bean, ModelMap model) {
        this.controllerPageIn(request);
        if(bean != null){
            RM_SessionData sessData = WebUtils.getSessionData(request);
            if(sessData != null){
                RM_ReadingMins min = sessData.getCurReadingLog();
                if(min != null){
                    min.setReadDate(bean.getDate());
                    min.setBookTitle(bean.getTitle());
                    min.setReadMins(bean.getMins());
                    AddReadingRecordLogic logic = new AddReadingRecordLogic();
                    if(logic.doSaveReadingInfo(min, WebUtils.getLoginUser(request))){
                        return "redirect:readingLogAdd";
                    }
                }
            }            
        }
        return "readingLogEdit";
    }    

    @RequestMapping(value = "/readingLogEdit", params = "delete", method = RequestMethod.POST)
    public String editMinsPostDelete(HttpServletRequest request, @ModelAttribute("minsForm") SubmitMins bean, ModelMap model) {
        this.controllerPageIn(request);
        if(bean != null){
            RM_SessionData sessData = WebUtils.getSessionData(request);
            if(sessData != null){
                RM_ReadingMins min = sessData.getCurReadingLog();
                if(min != null){
                    min.setBookTitle(null);
                    min.setReadMins(0);
                    min.setStatus(RY_DataBase.STATUS_INACTIVE);
                    AddReadingRecordLogic logic = new AddReadingRecordLogic();
                    if(logic.doSaveReadingInfo(min, WebUtils.getLoginUser(request))){
                        return "redirect:readingLogAdd";
                    }
                }
            }            
        }
        return "readingLogEdit";
    }    
    
}
