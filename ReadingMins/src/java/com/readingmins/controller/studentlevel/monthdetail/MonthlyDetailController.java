/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.studentlevel.monthdetail;

import com.readingmins.web.app.WebUtils;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rcommon.rdata.common.RY_DataBase;
import rcommon.rdata.iosystem.DataIOIdentity;
import rm_lib.application.workflow.ApplicationFlow;
import rm_lib.data.RM_ReadingMins;
import rm_lib.process.logics.AddReadingRecordLogic;
import rm_lib.sess.RM_SessionData;

/**
 *
 * @author renhongxiang
 */
@Controller
@Scope("session")
public class MonthlyDetailController extends MonthlyDetailControllerBase{

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String detailGet(HttpServletRequest request, @ModelAttribute("month") String beanMonth, ModelMap model) {

        this.prepareMenuInfo(request, model);

        this.buildMonthlyEdtailPage(request, model, beanMonth);
        
        this.prepareEditingForm(request, model);
        
        return "detail"; // this is which page to use.
    }

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public String detailPost(HttpServletRequest request, ModelMap model,
                            @ModelAttribute("month") String beanMonth, 
                            @ModelAttribute("editMinsForm") SubmitMins minbean ) {
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
                            break;
                        }
                    }
                }
            }
        }
        
        String saveStr = request.getParameter("saveRec");
        if(saveStr != null){
            this.saveCurRec(request, minbean);
        }

        String deleteStr = request.getParameter("delete");
        if(deleteStr != null){
            this.deleteCurRec(request, minbean);
        }
        
        this.prepareMenuInfo(request, model);
        
        this.buildMonthlyEdtailPage(request, model, beanMonth);
                
        this.prepareEditingForm(request, model);
        
        return "detail"; // this is which page to use.
    }

    
    private boolean deleteCurRec(HttpServletRequest request, SubmitMins minbean){
        RM_SessionData sessData = WebUtils.getSessionData(request);
        if(sessData != null){
            RM_ReadingMins curMin = sessData.getCurReadingLog();
            if(curMin != null){
                sessData.setCurReadingLog(null);
                curMin.setBookTitle(null);
                curMin.setReadMins(0);
                curMin.setStatus(RY_DataBase.STATUS_INACTIVE);
                AddReadingRecordLogic logic = new AddReadingRecordLogic();
                return logic.doSaveReadingInfo(curMin, WebUtils.getLoginUser(request));
            }
        }
        return false;
    }
    
    
    private boolean saveCurRec(HttpServletRequest request, SubmitMins minbean){
        RM_SessionData sessData = WebUtils.getSessionData(request);
        if(sessData != null){
            RM_ReadingMins curMin = sessData.getCurReadingLog();
            if(curMin != null){
                curMin.setReadDate(minbean.getDate());
                curMin.setBookTitle(minbean.getTitle());
                curMin.setReadMins(minbean.getMins());
                AddReadingRecordLogic logic = new AddReadingRecordLogic();
                return logic.doSaveReadingInfo(curMin, WebUtils.getLoginUser(request));
            }
        }
        return false;
    }
    
    protected void prepareEditingForm(HttpServletRequest request, ModelMap model){
        SubmitMins mins = new SubmitMins();
        RM_SessionData sessData = WebUtils.getSessionData(request);
        if(sessData != null){
            RM_ReadingMins curMin = sessData.getCurReadingLog();
            if(curMin != null){
                mins.setDate(curMin.getReadDate());
                mins.setMins(curMin.getReadMins());
                mins.setTitle(curMin.getBookTitle());
            }
        }
        model.addAttribute("editMinsForm", mins);
    }
    
    
    


    
    
}
