/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.process.loader;

import java.math.BigDecimal;
import java.util.List;
import rcommon.rdata.common.RY_User;
import rcommon.rdata.dataformat.RMonth;
import rm_lib.data.RM_ReadingMins;
import rm_lib.data.RM_Student;

/**
 *
 * @author renhongxiang
 */
public class LoaderStudentTotalMinsByMonth {
    
    public BigDecimal getTotalMinsByMonth(RM_Student student, RMonth month, RY_User user){
        BigDecimal total = BigDecimal.ZERO;
        LoadStudentReadingRecordByMonth logic = new LoadStudentReadingRecordByMonth();
        List<RM_ReadingMins> minsList = logic.getReadingMinsByMonth(student, month, user);
        if(minsList != null){
            for(RM_ReadingMins min : minsList){
                if(min != null){
                    BigDecimal minB = BigDecimal.ZERO;
                    if(min.getReadMins() != null){
                        minB = new BigDecimal(min.getReadMins());
                    }
                    total = total.add(minB);
                }
            }
        }
        return total;
    }
    
}
