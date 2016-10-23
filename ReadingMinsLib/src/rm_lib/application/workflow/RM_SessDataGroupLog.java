/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.application.workflow;

import rcommon.data.session.RSessionDataPackage;
import rm_lib.data.RM_ReadingMins;

/**
 *
 * @author renhongxiang
 */
public class RM_SessDataGroupLog extends RM_SessDataGroupMonthly{
    
    private RM_ReadingMins readingLog = null;

    public RM_ReadingMins getReadingLog() {
        return readingLog;
    }

    public void setReadingLog(RM_ReadingMins readingLog) {
        this.readingLog = readingLog;
    }
    
    
    @Override
    protected boolean copyPackageDataFrom(RSessionDataPackage curPackage){
        if(super.copyPackageDataFrom(curPackage)){
            if(curPackage instanceof RM_SessDataGroupLog){
                RM_SessDataGroupLog fromPackage = (RM_SessDataGroupLog)curPackage;
                this.setReadingLog(fromPackage.getReadingLog());
            }
            return true;
        }
        return false;
    }
    
}
