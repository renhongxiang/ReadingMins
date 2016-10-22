/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.process.logics;

import rcommon.rdata.common.RY_User;
import rcommon.rerror.RErrorManager;
import rcommon.rerror.RErrorSupportObject;
import rm_lib.data.RM_ReadingMins;
import rm_lib.process.logics.operation.AddReadingRecordOperation;

/**
 *
 * @author renhongxiang
 */
public class AddReadingRecordLogic extends RErrorSupportObject{
    
    public boolean doSaveReadingInfo(RM_ReadingMins readRec, RY_User user){
        RErrorManager errMan = this.createErrorMessage();
        this.setErrorManager(errMan);
        AddReadingRecordOperation op = new AddReadingRecordOperation();
        if(op != null){
            op.setErrorManager(errMan);
            op.setReadingRec(readRec);
            op.setUser(user);
            if(op.DoOperation()){
                return true;
            }
        }
        return false;
    }
    
}
