/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.studentlevel.monthdetail;

import com.readingmins.controller.studentlevel.StudentLevelController;
import com.readingmins.web.app.WebUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.ModelMap;
import rcommon.rdata.common.RY_User;
import rcommon.rdata.dataformat.RMonth;
import rcommon.rdata.iosystem.DataIOIdentity;
import rcommon.utils.datatype.RDateUtils;
import rm_lib.application.workflow.RM_SessDataGroupMonthly;
import rm_lib.data.RM_ReadingMins;
import rm_lib.data.RM_Student;
import rm_lib.data.logicdata.RM_MonthReadingData;
import rm_lib.sess.RM_SessDataGroup;

/**
 *
 * @author renhongxiang
 */
public abstract class MonthlyDetailControllerBase extends StudentLevelController{
    
    @Override
    protected RM_SessDataGroup createPageData(){
        return new RM_SessDataGroupMonthly();
    }
    
    private ReadingLogMonthBean pageBean = null;
    
    protected String getMonthListTableName(){
        return "monthReadingLog";
    }

    protected ReadingLogMonthBean getBean(){
        if(pageBean == null){
            pageBean = new ReadingLogMonthBean();
        }
        return pageBean;
    }
    
    protected void setBean(ReadingLogMonthBean bean){
        pageBean = bean;
    }
    
    protected void buildMonthlyEdtailPage(HttpServletRequest request, ModelMap model, String beanMonth){
        RMonth month = RMonth.stringToMonth(beanMonth, RMonth.MONTH_TEMPLATE_US);
        if(month == null){
            month = RMonth.getCurrMonth();
        }
        this.buildMonthlyEdtailPage(request, model, month);
    }
    
    protected void buildMonthlyEdtailPage(HttpServletRequest request, ModelMap model, RMonth month){
        
        List<RM_ReadingMins> list = this.getReadingRecordByMonth(request, month);

        RM_SessDataGroup pageData = WebUtils.getCurSessDataGroup(request);
        if(pageData instanceof RM_SessDataGroupMonthly){
            ((RM_SessDataGroupMonthly) pageData).setMonthReclist(list);
            ((RM_SessDataGroupMonthly) pageData).setCurMonth(month);
        }
        
        List<ReadingLogBean> beanList = this.buildBeanList(list);
        ReadingLogMonthBean bean = getBean();
        bean.setReadLogList(beanList);
        
        Integer totalMins = this.getTotalMins(list);
        bean.setTotalMins(totalMins);
        
        RM_Student student = WebUtils.getSessCurStudent(request);
        Integer shortMins = this.getShortMins(student, month, totalMins);

//        model.addAttribute(getTotalMinsName(), totalMins);

        bean.setShortMins(shortMins);
        
        model.addAttribute(getMonthListTableName(), bean);
        
    }
    
    public Integer getShortMins(RM_Student student, RMonth month, Integer totalMins){
        if( student != null){
            return student.getShortMins(month, totalMins);
        }
        return 0;
    }
    
    public Integer getTotalMins(List<RM_ReadingMins> list){
        Integer total = 0;
        if(list != null){
            for(RM_ReadingMins min : list){
                if(min != null && min.getReadMins() != null){
                    total += min.getReadMins();
                }
            }
        }
        return total;
    }
    
    public List<ReadingLogBean> getReadingLogByRecords(HttpServletRequest request, RMonth month){
        List<RM_ReadingMins> list = this.getReadingRecordByMonth(request, month);
        List<ReadingLogBean> beanList = this.buildBeanList(list);
        return beanList;
    }
    
    protected List<RM_ReadingMins> getReadingRecordByMonth(HttpServletRequest request, RMonth month){
        RY_User user = WebUtils.getLoginUser(request);
        RM_Student student = WebUtils.getSessCurStudent(request);
        RM_MonthReadingData monthData = new RM_MonthReadingData();
        List<RM_ReadingMins> list = monthData.loadDataListByMonth(month, student, user);
        RM_MonthReadingData.sortListData(list);
        return list;
    }
    
    protected List<ReadingLogBean> buildBeanList(List<RM_ReadingMins> list){
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
