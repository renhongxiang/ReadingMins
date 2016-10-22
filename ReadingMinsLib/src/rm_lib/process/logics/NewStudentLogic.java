/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.process.logics;

import rcommon.rdata.common.RY_User;
import rcommon.rerror.RErrorManager;
import rcommon.rerror.RErrorSupportObject;
import rm_lib.data.RM_Student;
import rm_lib.process.logics.operation.NewStudentOperation;

/**
 *
 * @author renhongxiang
 */
public class NewStudentLogic extends RErrorSupportObject{
    
    public boolean doCreateNewStudent(RM_Student student, RY_User user){
        RErrorManager errMan = this.createErrorMessage();
        this.setErrorManager(errMan);
        NewStudentOperation op = new NewStudentOperation();
        if(op != null){
            op.setErrorManager(errMan);
            op.setStudent(student);
            op.setUser(user);
            if(op.DoOperation()){
                return true;
            }
        }
        return false;
    }
    
}
