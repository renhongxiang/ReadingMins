/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.application.workflow;

import rcommon.data.session.RSessionDataLoginPackage;
import rcommon.data.session.RSessionDataPackage;
import rm_lib.data.RM_Student;

/**
 *
 * @author renhongxiang
 */
public class RM_SessDataGroupStudentBase extends RSessionDataLoginPackage{
    
    private RM_Student  student;
    
    public RM_Student getStudent() {
        return student;
    }

    public void setStudent(RM_Student student) {
        this.student = student;
    }
    
    @Override
    protected boolean copyPackageDataFrom(RSessionDataPackage curPackage){
        if(super.copyPackageDataFrom(curPackage)){
            if(curPackage instanceof RM_SessDataGroupStudentBase){
                RM_SessDataGroupStudentBase fromPackage = (RM_SessDataGroupStudentBase)curPackage;
                this.setStudent(fromPackage.getStudent());
            }
            return true;
        }
        return false;
    }
    
}
