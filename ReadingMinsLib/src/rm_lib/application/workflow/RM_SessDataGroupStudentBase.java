/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.application.workflow;

import rcommon.rdata.iosystem.DataIOIdentity;
import rm_lib.data.RM_ReadingMins;
import rm_lib.data.RM_Student;
import rm_lib.sess.RM_SessDataGroup;

/**
 *
 * @author renhongxiang
 */
public class RM_SessDataGroupStudentBase extends RM_SessDataGroup{
    
    private RM_Student  student;

    private DataIOIdentity readingLogID = null;
    
    private RM_ReadingMins curReadingLog = null;
    
    public RM_Student getStudent() {
        return student;
    }

    public void setStudent(RM_Student student) {
        this.student = student;
    }

    public DataIOIdentity getReadingLogID() {
        return readingLogID;
    }

    public void setReadingLogID(DataIOIdentity readingLogID) {
        this.readingLogID = readingLogID;
    }

    public RM_ReadingMins getCurReadingLog() {
        return curReadingLog;
    }

    public void setCurReadingLog(RM_ReadingMins curReadingLog) {
        this.curReadingLog = curReadingLog;
    }

    
    
}
