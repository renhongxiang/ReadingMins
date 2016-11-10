/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.sess;

import java.util.List;
import rcommon.data.session.RSessionDataBase;
import rcommon.data.session.RSessionDataPackage;
import rm_lib.application.workflow.RM_SessDataGroupLog;
import rm_lib.application.workflow.RM_SessDataGroupMonthly;
import rm_lib.application.workflow.RM_SessDataGroupStudentBase;
import rm_lib.application.workflow.RM_SessDataGroupStudentList;
import rm_lib.data.RM_ReadingMins;
import rm_lib.data.RM_Student;

/**
 *
 * @author renhongxiang
 */
public class RM_SessionData extends RSessionDataBase{

    public RSessionDataPackage getGroupData() {
        return this.getCurPackage();
    }
    
    public RM_Student getCurStudent(){
        RSessionDataPackage groupData = this.getGroupData();
        if(groupData instanceof RM_SessDataGroupStudentBase){
            RM_Student student = ((RM_SessDataGroupStudentBase) groupData).getStudent();
            return student;
        }
        return null;
    }

    
    public List<RM_Student> getStudentList(){
        RSessionDataPackage groupData = this.getGroupData();
        if(groupData instanceof RM_SessDataGroupStudentList){
            return ((RM_SessDataGroupStudentList) groupData).getStudentList();
        }
        return null;
    }
    
    public void setCurReadingLog(RM_ReadingMins min){
        RSessionDataPackage groupData = this.getGroupData();
        if(groupData instanceof RM_SessDataGroupLog){
            ((RM_SessDataGroupLog) groupData).setReadingLog(min);
        }
    }

    public RM_ReadingMins getCurReadingLog(){
        RSessionDataPackage groupData = this.getGroupData();
        if(groupData instanceof RM_SessDataGroupLog){
            return ((RM_SessDataGroupLog) groupData).getReadingLog();
        }
        return null;
    }

    public List<RM_ReadingMins> getSelectMinList(){
        RSessionDataPackage groupData = this.getGroupData();
        if(groupData instanceof RM_SessDataGroupMonthly){
            RM_SessDataGroupMonthly monthlyGroup = (RM_SessDataGroupMonthly)groupData;
            return monthlyGroup.getMonthReclist();
        }
        return null;
    }
}
