/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.process.logics;

import rcommon.rdata.common.RY_User;
import rcommon.rdata.iosystem.DataIOSaveDataOperation;
import rcommon.rerror.RErrorManager;
import rcommon.rerror.RErrorSupportObject;
import rm_lib.data.RM_Student;

/**
 *
 * @author renhongxiang
 */
public class EditStudentLogic extends RErrorSupportObject{
    
    public boolean doDeleteStudent(RM_Student student, RY_User user){
        RErrorManager errMan = this.createErrorMessage();
        this.setErrorManager(errMan);
        DataIOSaveDataOperation op = new DataIOSaveDataOperation();
        if(op != null){
            op.setErrorManager(errMan);
            op.setData(student);
            op.setUser(user);
            if(op.DoOperation()){
                return true;
            }
        }
        return false;
    }

    public boolean doSaveStudent(RM_Student student, RY_User user){
        RErrorManager errMan = this.createErrorMessage();
        this.setErrorManager(errMan);
        DataIOSaveDataOperation op = new DataIOSaveDataOperation();
        if(op != null){
            op.setErrorManager(errMan);
            op.setData(student);
            op.setUser(user);
            if(op.DoOperation()){
                return true;
            }
        }
        return false;
    }
    
}
