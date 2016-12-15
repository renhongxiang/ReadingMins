/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.database;

import rcommon.rdata.structure.RY_IODataDefine;
import rm_lib.data.RM_StudentIOData;
import rm_lib.data.RM_StudentIODataDefine;
import rytable.RY_DBBackupedTable;
import rytable.column.RY_DBColumnBase;

/**
 *
 * @author renhongxiang
 */
public class RM_StudentTB extends RY_DBBackupedTable{

    
    private RM_StudentTB(){
        
    }
    
    public static RM_StudentTB createInstance(){
        RM_StudentTB table = new RM_StudentTB();
        if(table != null){
            table.initCols();
        }
        return table;
    }
    
    

    public RY_DBColumnBase getColUserID() {
        return this.getColumnByKey(RM_StudentIODataDefine.FN_USER_ID);
    }

    public RY_DBColumnBase getColPersonID() {
        return this.getColumnByKey(RM_StudentIODataDefine.FN_PERSON_ID);
    }

    @Override
    public RY_IODataDefine getDataDefine() {
        return RM_StudentIOData.getStudentDataDefine();
    }
    
}
