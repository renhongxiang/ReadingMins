/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.database;

import rcommon.rdata.structure.RY_IODataDefine;
import rm_lib.data.RM_ReadingMinsIOData;
import rm_lib.data.RM_ReadingMinsIODataDefine;
import rytable.RY_DBBackupedTable;
import rytable.column.RY_DBColumnBase;

/**
 *
 * @author renhongxiang
 */
public class RM_ReadingMinsTB extends RY_DBBackupedTable{

    
    private RM_ReadingMinsTB(){
        
    }
    
    public static RM_ReadingMinsTB createInstance(){
        RM_ReadingMinsTB table = new RM_ReadingMinsTB();
        if(table != null){
            table.initCols();
        }
        return table;
    }
    
    
    public RY_DBColumnBase getColStudentID() {
        return this.getColumnByKey(RM_ReadingMinsIODataDefine.FN_STUDENT_ID);
    }
    
    public RY_DBColumnBase getColDate() {
        return this.getColumnByKey(RM_ReadingMinsIODataDefine.FN_DATE);
    }

    @Override
    public RY_IODataDefine getDataDefine() {
        return RM_ReadingMinsIOData.getReadingMinDataDefine();
    }
    
}
