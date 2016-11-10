/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.config;

import com.readingmins.web.app.RMWebUtils;
import javax.servlet.http.HttpServlet;
import rm_lib.application.init.RM_AppInit;

/**
 *
 * @author renhongxiang
 */
public class ReadMinsInitServlet extends HttpServlet{
    public ReadMinsInitServlet(){
        RM_AppInit.initApp();
        RMWebUtils util = new RMWebUtils();
        RMWebUtils.setInstance(util);
        ReadingMinsEmailCertify.InitReadingMinsEmailCertify();
        ReadingMinsResetPassword.InitReadingMinsResetPassword();
    }
}
