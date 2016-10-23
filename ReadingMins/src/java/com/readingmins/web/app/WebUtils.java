/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.web.app;

import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import rcommon.rdata.common.RY_User;
import rm_lib.data.RM_Student;
import rm_lib.sess.RM_SessDataGroup;
import rm_lib.sess.RM_SessionData;

/**
 *
 * @author renhongxiang
 */
public class WebUtils {
    public static RM_SessionData getSessionData(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session != null){
            RM_SessionData sessData = (RM_SessionData)session.getAttribute("sessdata");
            return sessData;
        }
        return null;
    }
    
    public static RM_Student getSessCurStudent(HttpServletRequest request){
        RM_SessionData sessData = WebUtils.getSessionData(request);
        if(sessData != null){
            return sessData.getCurStudent();
        }
        return null;
    }

    public static List<RM_Student> getSessStudentList(HttpServletRequest request){
        RM_SessionData sessData = WebUtils.getSessionData(request);
        if(sessData != null){
            return sessData.getStudentList();
        }
        return null;
    }
    
    public static RY_User getLoginUser(HttpServletRequest request){
        RM_SessionData sessData = WebUtils.getSessionData(request);
        if(sessData != null){
            return sessData.getLoginUser();
        }
        return null;
    }
    
    public static String getServerRealPath(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        if(session != null){
            ServletContext context = session.getServletContext();
            if(context != null){
                return context.getRealPath("");
            }
        }
        return null;
    }
    
    public static boolean isInSession(HttpServletRequest request){
        RY_User user = WebUtils.getLoginUser(request);
        if(user != null){
            return true;
        }
        return false;
    }
    
    public static RM_SessDataGroup getCurSessDataGroup(HttpServletRequest request){
        RM_SessionData sessData = WebUtils.getSessionData(request);
        if(sessData != null){
            return sessData.getGroupData();
        }
        return null;

    }
}
