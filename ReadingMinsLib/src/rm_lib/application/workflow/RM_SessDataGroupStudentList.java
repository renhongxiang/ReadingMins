/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.application.workflow;

import java.util.List;
import rm_lib.data.RM_Student;
import rm_lib.sess.RM_SessDataGroup;

/**
 *
 * @author renhongxiang
 */
public class RM_SessDataGroupStudentList extends RM_SessDataGroup{
    private List<RM_Student> studentList = null;

    public List<RM_Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<RM_Student> studentList) {
        this.studentList = studentList;
    }
    
    
}
