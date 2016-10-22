/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.database;

import java.util.ArrayList;
import java.util.List;
import rcommon.rdata.common.RY_IODataBase;
import rm_lib.data.RM_ReadingMinsIOData;
import rytable.RY_DBBackupedTable;
import rytable.column.RY_DBColumnBase;
import rytable.keys.RY_DBForeignKey;
import rytable.keys.RY_DBIndexKey;

/**
 *
 * @author renhongxiang
 */
public class RM_ReadingMinsTB extends RY_DBBackupedTable{

    public static final String TB_NAME = "ReadMins";
    
    private RM_ReadingMinsTB(){
        
    }
    
    public static RM_ReadingMinsTB createInstance(){
        RM_ReadingMinsTB table = new RM_ReadingMinsTB();
        if(table != null){
            table.initCols();
        }
        return table;
    }
    
    @Override
    protected RY_IODataBase getIOData() {
        return new RM_ReadingMinsIOData();
    }

    @Override
    protected String getTableBaseName() {
        return TB_NAME;
    }
    
    @Override
    public List<RY_DBForeignKey> getForeignKeyList() {
        List<RY_DBForeignKey> myIdxs = super.getForeignKeyList();
        if (myIdxs == null) {
            myIdxs = new ArrayList<RY_DBForeignKey>();
        }
        if (myIdxs != null) {
            myIdxs.add(new RY_DBForeignKey(RM_StudentTB.createInstance(), this.getColStudentID()));
        }
        return myIdxs;
    }

    @Override
    public List<RY_DBIndexKey> getIndexList() {
        List<RY_DBIndexKey> indexList = super.getIndexList();
        if (indexList == null) {
            indexList = createIndexList();
        }
        if (indexList != null) {
            indexList.add(new RY_DBIndexKey(this.getColStudentID()));
            indexList.add(new RY_DBIndexKey(this.getColDate()));
        }
        return indexList;
    }
    
    public RY_DBColumnBase getColStudentID() {
        return this.getColumnByKey(RM_ReadingMinsIOData.FN_STUDENT_ID);
    }
    
    public RY_DBColumnBase getColDate() {
        return this.getColumnByKey(RM_ReadingMinsIOData.FN_DATE);
    }
    
}
