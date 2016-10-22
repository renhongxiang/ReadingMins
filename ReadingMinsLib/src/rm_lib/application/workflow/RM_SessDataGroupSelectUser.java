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
public class RM_SessDataGroupSelectUser extends RM_SessDataGroup{
    
    private List<RM_Student> students;

    public List<RM_Student> getStudents() {
        return students;
    }

    public void setStudents(List<RM_Student> students) {
        this.students = students;
    }
    
    
}
