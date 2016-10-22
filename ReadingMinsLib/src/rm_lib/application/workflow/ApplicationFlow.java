/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.application.workflow;

import java.util.List;
import rcommon.rdata.common.RY_User;
import rcommon.rdata.iosystem.DataIOIdentity;
import rm_lib.data.RM_ReadingMins;
import rm_lib.data.RM_Student;
import rm_lib.sess.RM_SessDataGroup;
import rm_lib.sess.RM_SessionData;

/**
 *
 * @author renhongxiang
 */
public class ApplicationFlow {
    public static void UserLogin(RM_SessionData sessData, RY_User user){
        if(sessData != null && user != null){
            sessData.setLoginUser(user);
            sessData.setGroupData(null);
        }
    }
    
    public static void GoToSelectStudent(RM_SessionData sessData, List<RM_Student> students){
        if(sessData != null){
            RM_SessDataGroupSelectUser group = new RM_SessDataGroupSelectUser();
            group.setStudents(students);
            sessData.setGroupData(null);
            sessData.setGroupData(group);
        }
    }
    
    public static void StudentSelected(RM_SessionData sessData, RM_Student student){
        if(sessData != null){
            RM_SessDataGroupStudentBase group = new RM_SessDataGroupStudentBase();
            group.setStudent(student);
            sessData.setGroupData(null);
            sessData.setGroupData(group);
        }
    }
    
    public static void SelectStudentFromList(RM_SessionData sessData, List<RM_Student> students){
        if(sessData != null){
            RM_SessDataGroupStudentList group = new RM_SessDataGroupStudentList();
            group.setStudentList(students);
            sessData.setGroupData(null);
            sessData.setGroupData(group);
        }
    }
    
    public static void EditingReadingLog(RM_SessionData sessData, DataIOIdentity logID){
        if(sessData != null){
            RM_SessDataGroup sessGroup = sessData.getGroupData();
            if(sessGroup != null){
                if(sessGroup instanceof RM_SessDataGroupStudentBase){
                    RM_SessDataGroupStudentBase studentGroup = (RM_SessDataGroupStudentBase)sessGroup;
                    studentGroup.setReadingLogID(logID);
                }
            }
        }
    }
    
    public static void SelectReadingLog(RM_SessionData sessData, RM_ReadingMins min){
        if(sessData != null){
            sessData.setCurReadingLog(min);
        }
    }
    
    public static void IntoSelectReadingLogList(RM_SessionData sessData, RM_SessDataGroupSelectReadingLog readLogGroup){
        if(sessData != null){
            RM_SessDataGroup sessGroup = sessData.getGroupData();
            if(sessGroup != null){
                if(sessGroup instanceof RM_SessDataGroupStudentBase){
                    RM_SessDataGroupStudentBase studentGroup = (RM_SessDataGroupStudentBase)sessGroup;
                    studentGroup.setSubData(readLogGroup);
                }
            }
        }
    }
    
}
