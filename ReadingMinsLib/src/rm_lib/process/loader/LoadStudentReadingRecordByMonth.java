/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.process.loader;

import java.util.List;
import rcommon.rdata.common.RY_User;
import rcommon.rdata.dataformat.RMonth;
import rm_lib.data.RM_ReadingMins;
import rm_lib.data.RM_Student;

/**
 *
 * @author renhongxiang
 */
public class LoadStudentReadingRecordByMonth {
    
    public List<RM_ReadingMins> getReadingMinsByMonth(RM_Student student, RMonth month, RY_User user){
        LoaderStudentTotalMinsByMonthOperation oper = new LoaderStudentTotalMinsByMonthOperation();
        oper.setMonth(month);
        oper.setStudent(student);
        oper.setUser(user);
        if(oper.DoOperation()){
            return oper.getResultList();
        }
        
        return null;
    }
    
}
