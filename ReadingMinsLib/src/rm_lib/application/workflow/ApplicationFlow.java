/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.application.workflow;

import java.util.List;
import rcommon.data.session.RSessionDataSignupPackage;
import rcommon.rdata.common.RY_User;
import rm_lib.data.RM_ReadingMins;
import rm_lib.data.RM_Student;
import rm_lib.sess.RM_SessDataLoginGroup;
import rm_lib.sess.RM_SessionData;

/**
 *
 * @author renhongxiang
 */
public class ApplicationFlow {

    public static void UserLogin(RM_SessionData sessData, RY_User user){
        if(sessData != null && user != null){
            RM_SessDataLoginGroup group = new RM_SessDataLoginGroup();
            sessData.setCurPackage(group);
            group.setLoginUser(user);
        }
    }
    
    public static void GotoSelectStudent(RM_SessionData sessData, List<RM_Student> students){
        if(sessData != null){
            RM_SessDataGroupStudentList group = new RM_SessDataGroupStudentList();
            sessData.setGroupData(group);
            group.setStudentList(students);
        }
    }
    
    public static void StudentSelected(RM_SessionData sessData, RM_Student student){
        if(sessData != null){
            RM_SessDataGroupStudentBase group = new RM_SessDataGroupStudentBase();
            sessData.setGroupData(group);
            group.setStudent(student);
        }
    }
    
    public static void SelectStudentFromList(RM_SessionData sessData, List<RM_Student> students){
        if(sessData != null){
            RM_SessDataGroupStudentList group = new RM_SessDataGroupStudentList();
            sessData.setGroupData(group);
            group.setStudentList(students);
        }
    }
    
    public static void SelectReadingLog(RM_SessionData sessData, RM_ReadingMins min){
        if(sessData != null){
            RM_SessDataGroupLog group = new RM_SessDataGroupLog();
            sessData.setGroupData(group);
            group.setReadingLog(min);
        }
    }

    public static void UserRegistered(RM_SessionData sessData, RY_User user){
        if(sessData != null && user != null){
            RSessionDataSignupPackage group = new RSessionDataSignupPackage();
            sessData.setCurPackage(group);
            group.setRegisterUser(user);
        }
    }
    
}
