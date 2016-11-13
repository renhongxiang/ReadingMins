/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.application.workflow;

import java.util.List;
import rcommon.data.session.RSessionDataBase;
import rcommon.rdata.common.RY_User;
import rm_lib.data.RM_ReadingMins;
import rm_lib.data.RM_Student;
import rm_lib.sess.RM_SessDataLoginGroup;

/**
 *
 * @author renhongxiang
 */
public class ApplicationFlow {

    public static void UserLogin(RSessionDataBase sessData, RY_User user){
        if(sessData != null && user != null){
            RM_SessDataLoginGroup group = new RM_SessDataLoginGroup();
            sessData.setCurPackage(group);
            group.setLoginUser(user);
        }
    }
    
    public static void GotoSelectStudent(RSessionDataBase sessData, List<RM_Student> students){
        if(sessData != null){
            RM_SessDataGroupStudentList group = new RM_SessDataGroupStudentList();
            sessData.setCurPackage(group);
            group.setStudentList(students);
        }
    }
    
    public static void StudentSelected(RSessionDataBase sessData, RM_Student student){
        if(sessData != null){
            RM_SessDataGroupStudentBase group = new RM_SessDataGroupStudentBase();
            sessData.setCurPackage(group);
            group.setStudent(student);
        }
    }
    
    public static void SelectStudentFromList(RSessionDataBase sessData, List<RM_Student> students){
        if(sessData != null){
            RM_SessDataGroupStudentList group = new RM_SessDataGroupStudentList();
            sessData.setCurPackage(group);
            group.setStudentList(students);
        }
    }
    
    public static void SelectReadingLog(RSessionDataBase sessData, RM_ReadingMins min){
        if(sessData != null){
            RM_SessDataGroupLog group = new RM_SessDataGroupLog();
            sessData.setCurPackage(group);
            group.setReadingLog(min);
        }
    }

    
}
