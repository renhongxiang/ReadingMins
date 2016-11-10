/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.web.app;

import com.framework.utils.WebUtils;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import rcommon.data.session.RSessionDataBase;
import rm_lib.data.RM_Student;
import rm_lib.sess.RM_SessionData;

/**
 *
 * @author renhongxiang
 */
public class RMWebUtils extends WebUtils{
    
    public RM_Student getSessCurStudent(HttpServletRequest request){
        RM_SessionData rm_sessData = getRMSessData(request);
        if(rm_sessData != null)
            return rm_sessData.getCurStudent();
        return null;
    }
    
    public List<RM_Student> getSessStudentList(HttpServletRequest request){
        RM_SessionData rm_sessData = getRMSessData(request);
        if(rm_sessData != null)
            return rm_sessData.getStudentList();
        return null;
    }
    
    private RM_SessionData getRMSessData(HttpServletRequest request){
        RSessionDataBase sessData = getSessionData(request);
        if(sessData != null){
            if(sessData instanceof RM_SessionData){
                return (RM_SessionData)sessData;
            }
        }
        return null;
    }
    
    @Override
    protected RSessionDataBase createSessionData(){
        return new RM_SessionData();
    }
    
}
