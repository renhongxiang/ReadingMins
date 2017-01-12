/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.config;

import com.readingmins.debug.RM_DebugUtil;
import com.readingmins.web.app.RMWebUtils;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author renhongxiang
 */
public class ReadMinsInitServlet extends HttpServlet{
    public ReadMinsInitServlet(){
        RM_AppInitWeb.initApp();
        RMWebUtils util = new RMWebUtils();
        RMWebUtils.setInstance(util);
        
        RM_EmailUserID.initInstance();
        
        RM_DebugUtil debugUtil = new RM_DebugUtil();
        RM_DebugUtil.setDebugUtil(debugUtil);
        
        ReadingMinsEmailCertify.InitReadingMinsEmailCertify();
        ReadingMinsResetPassword.InitReadingMinsResetPassword();
    }
}
