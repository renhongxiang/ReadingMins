/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.application.workflow;

import java.util.List;
import rcommon.data.session.RSessionDataLoginPackage;
import rcommon.data.session.RSessionDataPackage;
import rm_lib.data.RM_Student;

/**
 *
 * @author renhongxiang
 */
public class RM_SessDataGroupStudentList extends RSessionDataLoginPackage{
    private List<RM_Student> studentList = null;

    public List<RM_Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<RM_Student> studentList) {
        this.studentList = studentList;
    }
    
    @Override
    protected boolean copyPackageDataFrom(RSessionDataPackage curPackage){
        if(super.copyPackageDataFrom(curPackage)){
            if(curPackage instanceof RM_SessDataGroupStudentList){
                RM_SessDataGroupStudentList fromPackage = (RM_SessDataGroupStudentList)curPackage;
                this.setStudentList(fromPackage.getStudentList());
            }
            return true;
        }
        return false;
    }
    
}
