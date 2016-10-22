/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.document;

import java.util.Date;
import java.util.List;
import rcommon.rdata.dataformat.RMonth;
import rcommon.utils.datatype.RDateUtils;
import rjasper.RJRReportDataBase;
import rjasper.RJRSubReportDataBase;
import rm_lib.data.RM_ReadingMins;

/**
 *
 * @author renhongxiang
 */
public class RJRPDFReadingLogData extends RJRReportDataBase{
    
    private static final String PARA_NAME = "StudentName";
    private static final String PARA_MONTH = "Month";
    private static final String PARA_STUDENT_ID = "StudentID";    
    private static final String PARA_MINS_TOTAL = "Total_Mins";
    private static final String PARA_SUBREPORT = "SubPage_Path";

    private static final String KEY_SUBMINS = "subMins";

    private static final String SUB_PARA_DAY = "days";
    private static final String SUB_PARA_TITLE = "BookTitle";
    private static final String SUB_PARA_MINS = "dailymins";
    
    private List<RM_ReadingMins> monthDataList = null;
    
    public List<RM_ReadingMins> getMonthList(){
        return monthDataList;
    }
    
    public void setMonthList(List<RM_ReadingMins> monthList){
        this.monthDataList = monthList;
    }
    
    public void setStudentName(String name){
        this.addDataMap(PARA_NAME, name);
    }
    
    public void setMonth(RMonth month){
        if(month != null){
            String monthStr = convertMonthToString(month);
            this.addDataMap(PARA_MONTH, monthStr);
        }
    }
    
    public void setStudentID(String stuID){
        this.addDataMap(PARA_STUDENT_ID, stuID);
    }
    
    public void setTotalMins(Integer total){
        this.addDataMap(PARA_MINS_TOTAL, total);
    }

    public void setSubReportPath(String path){
        this.addDataMap(PARA_SUBREPORT, path);
    }
    
    public void buildDailyList(){
        List<RM_ReadingMins> list = getMonthList();
        if(list != null){
            RJRSubReportDataBase dailySubData = new RJRSubReportDataBase();
            this.addSubReportData(KEY_SUBMINS, dailySubData);
            for(RM_ReadingMins min : list){
                if(min != null){
                    RJRReportDataBase reportData = new RJRReportDataBase();
                    dailySubData.addReportData(reportData);
                    Date readDate = min.getReadDate();
                    reportData.addDataMap(SUB_PARA_DAY, "" + RDateUtils.GetDay(readDate));
                    reportData.addDataMap(SUB_PARA_TITLE, min.getBookTitle());
                    reportData.addDataMap(SUB_PARA_MINS, "" + min.getReadMins());
                }
            }
        }
    }
    
    private String convertMonthToString(RMonth month){
        return RMonth.monthToString(month, RMonth.MONTH_TEMPLATE_US);
    }
    
    
    
}
