/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.process.logics;

import java.io.OutputStream;
import java.util.List;
import rcommon.rdata.common.RY_User;
import rcommon.rdata.dataformat.RMonth;
import rm_lib.data.RM_Student;
import rm_lib.data.logicdata.RM_MonthReadingData;
import rm_lib.document.RJRPDFReadingLog;
import rm_lib.document.RJRPDFReadingLogData;
import rm_lib.document.RM_ReadingMinsDocData;
import rm_lib.sess.RM_SessionData;

/**
 *
 * @author renhongxiang
 */
public class DownloadReadingLog {
    
    private String path = null;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    public boolean downloadReadingLog(OutputStream outputStream, RM_SessionData sessData, RMonth month){
        if(sessData != null){
            RJRPDFReadingLogData docData = new RJRPDFReadingLogData();
            
            RM_Student student = sessData.getCurStudent();
            if(student != null){
                String name = student.getFirstLastName();
                RY_User user = sessData.getLoginUser();
                docData.setStudentName(name);
                docData.setMonth(month);
                String code = student.getStudentCode();
                docData.setStudentID(code);
//                parameters.put(name, user)

                RM_MonthReadingData monthData = new RM_MonthReadingData();
                List<RM_ReadingMinsDocData> monthlyList = monthData.loadMonthlyData(month, student, user);

                docData.setMonthList(monthlyList);
                
                docData.buildDailyList();
                
                docData.setTotalMins(monthData.getTotalMins());
            }
            
            docData.setSubReportPath(path);
            
            RJRPDFReadingLog readLogDoc = new RJRPDFReadingLog();
            readLogDoc.setTempFolderPath(path);
            readLogDoc.setReportData(docData);
            readLogDoc.downLoadReport(outputStream);
            
        }
        return true;
    }
    
    
}
