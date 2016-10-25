/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.studentlevel.monthdetail;

import com.readingmins.controller.studentlevel.StudentLevelController;
import com.readingmins.web.app.WebUtils;
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
import rm_lib.application.workflow.RM_SessDataGroupMonthly;
import rm_lib.data.RM_ReadingMins;
import rm_lib.data.RM_Student;
import rm_lib.data.logicdata.RM_MonthReadingData;
import rm_lib.process.logics.DownloadReadingLog;
import rm_lib.sess.RM_SessDataGroup;
import rm_lib.sess.RM_SessionData;

/**
 *
 * @author renhongxiang
 */
@Controller
@Scope("session")
public class ReadingLogDownloadController extends StudentLevelController{

    
    @Override
    protected RM_SessDataGroup createPageData(){
        return new RM_SessDataGroupMonthly();
    }
    
    @RequestMapping(value = "/readingLogDownload", method = RequestMethod.GET)
    public String monthInfoGet(HttpServletRequest request, @ModelAttribute("month") String beanMonth, ModelMap model) {
        this.controllerPageIn(request);
        
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

        model.addAttribute("month", RMonth.monthToString(month, RMonth.MONTH_TEMPLATE_US));
        
        ReadingLogMonthBean monthBean = this.getMonthlyReadingLog(request, month);
        
        model.addAttribute("monthReadingLog", monthBean);
        
        
        return "readingLogDownload"; // this is which page to use.
    }    
    
    @RequestMapping(value = "/readingLogDownload", method = RequestMethod.POST)
    public String monthInfoPost(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("month") String bean, ModelMap model) {
        String button = request.getParameter("download");
        if(button != null){
            boolean res = this.download(request, response, model);
            if(!res){
                // error
            }
            return "readingLogDownload";
        }
        
        button = request.getParameter("month");
        if(button != null){
            return this.monthInfoPostChangeMonth(request, response, model);
        }        
        return "readingLogDownload";
    }
    
    

    public String monthInfoPostChangeMonth(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        this.prepareMenuInfo(request, model);
        
        String monthStr = (String)model.get("month");
        RMonth month = RMonth.stringToMonth(monthStr, RMonth.MONTH_TEMPLATE_US);
        model.addAttribute("month", RMonth.monthToString(month, RMonth.MONTH_TEMPLATE_US));
        
        
        ReadingLogMonthBean monthBean = this.getMonthlyReadingLog(request, month);
        
        model.addAttribute("monthReadingLog", monthBean);
        return "readingLogDownload"; // this is which page to use.
    }
    
    
    protected boolean download(HttpServletRequest request, HttpServletResponse response, ModelMap model){
        String monthStr = (String)model.get("month");
        RMonth month = RMonth.stringToMonth(monthStr, RMonth.MONTH_TEMPLATE_US);
        if(month != null){
            try {            
                RM_SessionData sessData = WebUtils.getSessionData(request);
                ServletOutputStream outputStream = response.getOutputStream();
                if(outputStream != null){
                    String path = WebUtils.getServerRealPath(request);
                    DownloadReadingLog download = new DownloadReadingLog();
                    download.setPath(path);
                    download.downloadReadingLog(outputStream, sessData, month);
                }
                response.flushBuffer();
                return true;
            } catch (IOException ex) {
            }
        }
        return false;
    }
    
    public ReadingLogMonthBean getMonthlyReadingLog(HttpServletRequest request, RMonth month){
        ReadingLogMonthBean bean = new ReadingLogMonthBean();
        List<ReadingLogBean> list = getMonthlyReadingLogByMonth(request, month);
        bean.setReadLogList(list);
        return bean;
    }
    
    public List<ReadingLogBean> getMonthlyReadingLogByMonth(HttpServletRequest request, RMonth month){
        List<RM_ReadingMins> list = this.getMonthlyReadingRecordByMonth(request, month);
        List<ReadingLogBean> beanList = this.buildBeanList(list);
        return beanList;
    }
    
    private List<RM_ReadingMins> getMonthlyReadingRecordByMonth(HttpServletRequest request, RMonth month){
        RY_User user = WebUtils.getLoginUser(request);
        RM_Student student = WebUtils.getSessCurStudent(request);
        RM_MonthReadingData monthData = new RM_MonthReadingData();
        return monthData.loadMonthlyData(month, student, user);
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
