/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.database;

import java.util.ArrayList;
import java.util.List;
import rcommon.rdata.common.RY_IODataBase;
import rm_lib.data.RM_StudentIOData;
import rytable.RY_DBBackupedTable;
import rytable.column.RY_DBColumnBase;
import rytable.common.RY_PersonTB;
import rytable.common.RY_UserTB;
import rytable.keys.RY_DBForeignKey;
import rytable.keys.RY_DBIndexKey;

/**
 *
 * @author renhongxiang
 */
public class RM_StudentTB extends RY_DBBackupedTable{

    public static final String TB_NAME = "Student";
    
    private RM_StudentTB(){
        
    }
    
    public static RM_StudentTB createInstance(){
        RM_StudentTB table = new RM_StudentTB();
        if(table != null){
            table.initCols();
        }
        return table;
    }
    
    @Override
    protected RY_IODataBase getIOData() {
        return new RM_StudentIOData();
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
            myIdxs.add(new RY_DBForeignKey(RY_UserTB.createInstance(), this.getColUserID()));
            myIdxs.add(new RY_DBForeignKey(RY_PersonTB.createInstance(), this.getColPersonID()));
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
            indexList.add(new RY_DBIndexKey(this.getColUserID()));
            indexList.add(new RY_DBIndexKey(this.getColPersonID()));
        }
        return indexList;
    }

    public RY_DBColumnBase getColUserID() {
        return this.getColumnByKey(RM_StudentIOData.FN_USER_ID);
    }

    public RY_DBColumnBase getColPersonID() {
        return this.getColumnByKey(RM_StudentIOData.FN_PERSON_ID);
    }
    
}
