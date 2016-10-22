/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.download.readinglog;

import com.readingmins.web.app.WebUtils;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rcommon.rdata.dataformat.RMonth;
import rm_lib.process.logics.DownloadReadingLog;
import rm_lib.sess.RM_SessionData;

/**
 *
 * @author renhongxiang
 */
@Controller
@Scope("session")
public class DownloadReadLogController {

    @RequestMapping(value = "/downloadReadingLog", method = RequestMethod.GET)
    public void getFile(HttpServletRequest request, HttpServletResponse response) {
        try {
            RM_SessionData sessData = WebUtils.getSessionData(request);
            ServletOutputStream outputStream = response.getOutputStream();
            if(outputStream != null){
                
                String path = WebUtils.getServerRealPath(request);
                
                File folder = new File(path);
                
                File[] files = folder.listFiles();
                
                RMonth month = RMonth.getCurrMonth();
                DownloadReadingLog download = new DownloadReadingLog();
                
                download.setPath(path);
                
                download.downloadReadingLog(outputStream, sessData, month);
                
                
            }
            response.flushBuffer();
        } catch (IOException ex) {
        }
    }    
}
