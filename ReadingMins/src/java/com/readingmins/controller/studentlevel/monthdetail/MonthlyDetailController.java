/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.studentlevel.monthdetail;

import com.readingmins.controller.studentlevel.StudentLevelController;
import com.readingmins.web.app.WebUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rcommon.rdata.common.RY_User;
import rcommon.rdata.dataformat.RMonth;
import rcommon.rdata.iosystem.DataIOIdentity;
import rcommon.utils.datatype.RDateUtils;
import rm_lib.application.workflow.ApplicationFlow;
import rm_lib.application.workflow.RM_SessDataGroupSelectReadingLog;
import rm_lib.data.RM_ReadingMins;
import rm_lib.data.RM_Student;
import rm_lib.data.logicdata.RM_MonthReadingData;
import rm_lib.process.logics.DownloadReadingLog;
import rm_lib.sess.RM_SessionData;

/**
 *
 * @author renhongxiang
 */
@Controller
@Scope("session")
public class MonthlyDetailController extends StudentLevelController{

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String detailGet(HttpServletRequest request, ModelMap model) {
        this.prepareMenuInfo(request, model);
        RMonth month = RMonth.getCurrMonth();
        this.buildMonthlyEdtailPage(request, model, month);
        return "detail"; // this is which page to use.
    }

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public String detailPost(HttpServletRequest request, @ModelAttribute("month") String bean, ModelMap model) {
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
                            return "redirect:minsEdit";
                        }
                    }
                }
            }
        }
        
        String monthChange = request.getParameter("month");
        if(monthChange != null){
            String monthStr = (String)model.get("month");
            RMonth month = RMonth.stringToMonth(monthStr, RMonth.MONTH_TEMPLATE_US);
            if(month == null){
                month = RMonth.getCurrMonth();
            }
            this.buildMonthlyEdtailPage(request, model, month);
        }
        return "detail"; // this is which page to use.
    }

    protected void buildMonthlyEdtailPage(HttpServletRequest request, ModelMap model, RMonth month){
        model.addAttribute("month", RMonth.monthToString(month, RMonth.MONTH_TEMPLATE_US));
        List<RM_ReadingMins> list = this.getReadingRecordByMonth(request, month);
        RM_SessDataGroupSelectReadingLog readLogGroup = new RM_SessDataGroupSelectReadingLog();
        if(list != null){
            for(RM_ReadingMins min : list){
                readLogGroup.addReadingLog(min);
            }
        }
        RM_SessionData sessData = WebUtils.getSessionData(request);
        ApplicationFlow.IntoSelectReadingLogList(sessData, readLogGroup);
        List<ReadingLogBean> beanList = this.buildBeanList(list);
        ReadingLogMonthBean bean = new ReadingLogMonthBean();
        bean.setReadLogList(beanList);
        model.addAttribute("monthReadingLog", bean);
    }
    
    
    
    public ReadingLogMonthBean getReadingLogData(HttpServletRequest request, RMonth month){
        ReadingLogMonthBean bean = new ReadingLogMonthBean();
        List<ReadingLogBean> list = getReadingLogByRecords(request, month);
        bean.setReadLogList(list);
        return bean;
    }
    
    
    public List<ReadingLogBean> getReadingLogByRecords(HttpServletRequest request, RMonth month){
        List<RM_ReadingMins> list = this.getReadingRecordByMonth(request, month);
        List<ReadingLogBean> beanList = this.buildBeanList(list);
        return beanList;
    }
    
    
    private List<RM_ReadingMins> getReadingRecordByMonth(HttpServletRequest request, RMonth month){
        RY_User user = WebUtils.getLoginUser(request);
        RM_Student student = WebUtils.getSessCurStudent(request);
        RM_MonthReadingData monthData = new RM_MonthReadingData();
        return monthData.loadDataListByMonth(month, student, user);
    }
    
    
    private List<ReadingLogBean> buildBeanList(List<RM_ReadingMins> list){
        List<ReadingLogBean> beanList = new ArrayList<ReadingLogBean>();
        if(beanList != null && list != null){
            for(int i = 0; i<list.size(); i++){
                RM_ReadingMins min = list.get(i);
                if(min != null){
                    ReadingLogBean bean = new ReadingLogBean();
                    Date day = min.getReadDate();
                    bean.setDay(RDateUtils.GetDay(day));
                    bean.setMins(min.getReadMins());
                    bean.setTitle(min.getBookTitle());
                    DataIOIdentity ioID = min.getMinsIOID();
                    if(ioID != null && ioID.isValueValid()){
                        bean.setId(ioID.getIndentifyID());
                    }
                    beanList.add(bean);
                }
            }
            return beanList;
        }        
        return null;
    }


    
    
}
