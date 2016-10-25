/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.process.logics.operation;

import java.util.Date;
import rcommon.rdata.iosys.operation.common.DataIOTimerOperation;
import rcommon.rerror.RErrorCodeTranslater;
import rcommon.utils.datatype.RStringUtils;
import rm_lib.data.RM_ReadingMins;

/**
 *
 * @author renhongxiang
 */
public class AddReadingRecordOperation extends DataIOTimerOperation{


    private RM_ReadingMins readingRec = null;

    public RM_ReadingMins getReadingRec() {
        return readingRec;
    }

    public void setReadingRec(RM_ReadingMins readingRec) {
        this.readingRec = readingRec;
    }
    
    
    @Override
    protected boolean doProcessOperation() {
        RM_ReadingMins readRec = this.getReadingRec();
        if(this.validateReadingLog(readRec)){
            if(readRec != null){
                return readRec.doSave(this.getDataIOHandle());
            }
        }
        return false;
    }
    
    private boolean validateReadingLog(RM_ReadingMins readRec){
        boolean res = false;
        if(readRec != null){
            res = true;
            if(readRec.isActive()){
                Date readDate = readRec.getReadDate();
                if(readDate == null){
                    this.setErrorCode(AddReadingRecordOperationErrorTranslater.ERR_DATE_MISSING, null);
                    res = false;
                }
                String title = readRec.getBookTitle();
                if(RStringUtils.isBlank(title)){
                    this.setErrorCode(AddReadingRecordOperationErrorTranslater.ERR_TITLE_MISSING, null);
                    res = false;
                }
                Integer mins = readRec.getReadMins();
                if(mins == null){
                    mins = 0;
                }
                if(mins <= 0){
                    this.setErrorCode(AddReadingRecordOperationErrorTranslater.ERR_MINS_MISSING, null);
                    res = false;
                }
            }
        }
        return res;
    }
    
    @Override
    public RErrorCodeTranslater getTranslator(){
        return AddReadingRecordOperationErrorTranslater.getTranslater();
    }
    
}
