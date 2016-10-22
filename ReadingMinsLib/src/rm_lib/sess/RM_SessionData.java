/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.sess;

import java.util.List;
import rcommon.data.session.SessionLevelDataBase;
import rcommon.rdata.common.RY_User;
import rcommon.rdata.iosystem.DataIOIdentity;
import rm_lib.application.workflow.RM_SessDataGroupSelectReadingLog;
import rm_lib.application.workflow.RM_SessDataGroupStudentBase;
import rm_lib.application.workflow.RM_SessDataGroupStudentList;
import rm_lib.data.RM_ReadingMins;
import rm_lib.data.RM_Student;

/**
 *
 * @author renhongxiang
 */
public class RM_SessionData {
    
    private RY_User loginUser = null;    
    private RM_SessDataGroup groupData = null;

    public RY_User getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(RY_User loginUser) {
        this.loginUser = loginUser;
    }

    public RM_SessDataGroup getGroupData() {
        return groupData;
    }

    public void setGroupData(RM_SessDataGroup groupData) {
        this.groupData = groupData;
    }
    
    public RM_Student getCurStudent(){
        RM_SessDataGroup groupData = this.getGroupData();
        if(groupData instanceof RM_SessDataGroupStudentBase){
            RM_Student student = ((RM_SessDataGroupStudentBase) groupData).getStudent();
            return student;
        }
        return null;
    }

    public DataIOIdentity getCurReadingLogID(){
        RM_SessDataGroup groupData = this.getGroupData();
        if(groupData instanceof RM_SessDataGroupStudentBase){
            return ((RM_SessDataGroupStudentBase) groupData).getReadingLogID();
        }
        return null;
    }
    
    public List<RM_Student> getStudentList(){
        RM_SessDataGroup groupData = this.getGroupData();
        if(groupData instanceof RM_SessDataGroupStudentList){
            return ((RM_SessDataGroupStudentList) groupData).getStudentList();
        }
        return null;
    }
    
    public void setCurReadingLog(RM_ReadingMins min){
        RM_SessDataGroup groupData = this.getGroupData();
        if(groupData instanceof RM_SessDataGroupStudentBase){
            groupData.setSubData(null);
            ((RM_SessDataGroupStudentBase) groupData).setCurReadingLog(min);
        }
    }

    public RM_ReadingMins getCurReadingLog(){
        RM_SessDataGroup groupData = this.getGroupData();
        if(groupData instanceof RM_SessDataGroupStudentBase){
            return ((RM_SessDataGroupStudentBase) groupData).getCurReadingLog();
        }
        return null;
    }

    public List<RM_ReadingMins> getSelectMinList(){
        RM_SessDataGroup groupData = this.getGroupData();
        if(groupData instanceof RM_SessDataGroupStudentBase){
            RM_SessDataGroupStudentBase studentGroup = (RM_SessDataGroupStudentBase)groupData;
            
            SessionLevelDataBase group = studentGroup.getSubData();
            if(group instanceof RM_SessDataGroupSelectReadingLog){
                RM_SessDataGroupSelectReadingLog readLogGroup = (RM_SessDataGroupSelectReadingLog)group;
                return readLogGroup.getReadingMinsList();
            }
        }
        return null;
    }
}
