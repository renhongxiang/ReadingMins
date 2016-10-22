/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.process.logics.operation;

import rcommon.rdata.iosys.operation.common.DataIOTimerOperation;
import rm_lib.data.RM_Student;

/**
 *
 * @author renhongxiang
 */
public class NewStudentOperation extends DataIOTimerOperation{

    private RM_Student student;

    public RM_Student getStudent() {
        return student;
    }

    public void setStudent(RM_Student student) {
        this.student = student;
    }
    
    @Override
    protected boolean doProcessOperation() {
        RM_Student student = this.getStudent();
        if(student != null){
            return student.doSave(this.getDataIOHandle());
        }
        return false;
    }
    
}
