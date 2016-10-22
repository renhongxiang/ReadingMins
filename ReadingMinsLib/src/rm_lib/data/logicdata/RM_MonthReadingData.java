/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.data.logicdata;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import rcommon.rdata.common.RY_User;
import rcommon.rdata.dataformat.RMonth;
import rcommon.utils.datatype.RDateUtils;
import rcommon.utils.datatype.RStringUtils;
import rm_lib.data.RM_ReadingMins;
import rm_lib.data.RM_Student;
import rm_lib.process.loader.LoadStudentReadingRecordByMonth;

/**
 *
 * @author renhongxiang
 */
public class RM_MonthReadingData {
    
    private List<RM_ReadingMins> monthDataList = null;
    
    private RMonth month = null;

    private Integer totalMins = 0;
    

    public List<RM_ReadingMins> loadMonthlyData(RMonth month, RM_Student student, RY_User sessUser){
        List<RM_ReadingMins> dbData = this.loadDataListByMonth(month, student, sessUser);
        
        this.prepareDailyList(month);

        if(dbData != null){
            for(RM_ReadingMins info : dbData){
                this.addReadingInfo(info);
            }
        }
        return this.getMonthList();
    }
    
    public List<RM_ReadingMins> loadDataListByMonth(RMonth month, RM_Student student, RY_User sessUser){
        LoadStudentReadingRecordByMonth load = new LoadStudentReadingRecordByMonth();
        return load.getReadingMinsByMonth(student, month, sessUser);
    }
    
    public boolean prepareDailyList(RMonth month){
        if(month != null){
            monthDataList = new ArrayList<RM_ReadingMins>();
            if(monthDataList != null){
                totalMins = 0;
                Date firstDate = month.getMonthStartDate();
                RMonth monthNext = month.addMonth(1);
                Date lastDate = monthNext.getMonthStartDate();
                for(Date date = firstDate; RDateUtils.DiffDay(date, lastDate) < 0; date = RDateUtils.AddDay(date, 1) ){
                    RM_ReadingMins dailyMin = new RM_ReadingMins();
                    dailyMin.setReadDate(date);
                    dailyMin.setBookTitle("");
                    dailyMin.setReadMins(0);
                    monthDataList.add(dailyMin);
                }
                return true;
            }
        }
        return false;
    }
    
    public void addReadingInfo(RM_ReadingMins info){
        if(info != null){
            Date date = info.getReadDate();
            if(date != null){
                int day = RDateUtils.GetDay(date);
                List<RM_ReadingMins> list = getMonthList();
                if(list != null){
                    RM_ReadingMins listInfo = list.get(day - 1);
                    if(listInfo != null){
                        String title = listInfo.getBookTitle();
                        String nTitle = info.getBookTitle();
                        if(RStringUtils.isNotBlank(title)){
                            title = title + ", " + nTitle;
                        }else{
                            title = nTitle;
                        }
                        listInfo.setBookTitle(title);
                        Integer mins = listInfo.getReadMins();
                        if(mins == null)
                            mins = 0;
                        Integer nMins = info.getReadMins();
                        if(nMins == null)
                            nMins = 0;
                        mins = mins + nMins;
                        listInfo.setReadMins(mins);
                    }
                }
                totalMins += info.getReadMins();
            }
        }
    }

    public List<RM_ReadingMins> getMonthList(){
        return monthDataList;
    }

    public Integer getTotalMins() {
        return totalMins;
    }
    
}
