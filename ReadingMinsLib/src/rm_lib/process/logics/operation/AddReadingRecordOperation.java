/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.process.logics.operation;

import rcommon.rdata.iosys.operation.common.DataIOTimerOperation;
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
        if(readRec != null){
            return readRec.doSave(this.getDataIOHandle());
        }
        return false;
    }
    
}
