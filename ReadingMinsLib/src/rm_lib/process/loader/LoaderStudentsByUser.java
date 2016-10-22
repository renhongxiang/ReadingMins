/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.process.loader;

import java.util.List;
import rcommon.rdata.common.RY_User;
import rm_lib.data.RM_Student;

/**
 *
 * @author renhongxiang
 */
public class LoaderStudentsByUser {
    
    public List<RM_Student> loadListByUser(RY_User user){
        LoaderStudentsByUserOperation oper = new LoaderStudentsByUserOperation();
        oper.setUser(user);
        if(oper.DoOperation()){
            return oper.getStudentList();
        }
        return null;
    }

    
    
}
