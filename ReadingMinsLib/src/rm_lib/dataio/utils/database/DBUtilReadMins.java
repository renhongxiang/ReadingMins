/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.dataio.utils.database;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rcommon.rdata.dataformat.RMonth;
import rcommon.rdata.iosys.db.DataIODBHandleUtil;
import rcommon.rdata.iosystem.DataIOHandleBase;
import rcommon.rdata.structure.RY_IODataObjectBase;
import rcommon.rerror.RErrorSupportObject;
import rm_lib.data.RM_ReadingMinsIOData;
import rm_lib.database.RM_ReadingMinsTB;
import rm_lib.dataio.utils.DataIOUtilReadMins;
import rytable.RY_DBTableBase;
import rytable.column.RY_DBColumnBase;
import rytable.data.iosys.dbutils.sqls.DBUtilsConditionBase;
import rytable.data.iosys.dbutils.sqls.DBUtilsSQLTableQueryListWithAddInfo;
import rytable.data.iosys.dbutils.sqls.conditions.DBUtilsConditionColCompareImput;

/**
 *
 * @author renhongxiang
 */
public class DBUtilReadMins extends DataIOUtilReadMins{

    
    public RM_ReadingMinsTB getReadingMinsTable(){
        return RM_ReadingMinsTB.createInstance();
    }
    
    @Override
    public List<RY_IODataObjectBase> loanRecListByInfoInMonth(DataIOHandleBase ioHandle, RM_ReadingMinsIOData minsInfo, RMonth month){
        
        DBUtilsSQLTableQueryListWithAddInfo sqlUtil = new DBUtilsSQLTableQueryListWithAddInfo();
        if(sqlUtil != null){
            try {
                Connection conn = DataIODBHandleUtil.getConnection(ioHandle);
                sqlUtil.setDataObj(minsInfo);
                sqlUtil.setDataTable(getReadingMinsTable());
                sqlUtil.setErrorManager(RErrorSupportObject.getErrorManager(ioHandle));
                sqlUtil.setAddConditionList(getByMonthConditions(month));
                if(sqlUtil.DoQuery(conn)){
                    List<RY_IODataObjectBase> list =  sqlUtil.getLoadList();
                    return list;
                }
            } catch (Exception ex) {
                Logger.getLogger(RY_DBTableBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    private List<DBUtilsConditionBase> getByMonthConditions(RMonth month){
        List<DBUtilsConditionBase> condList = new ArrayList<DBUtilsConditionBase>();
        if(condList != null && month != null){
            RM_ReadingMinsTB table = getReadingMinsTable();
            if(table != null){
                RY_DBColumnBase dateCol = table.getColDate();
                if(dateCol != null){
                    DBUtilsConditionColCompareImput cond1 = DBUtilsConditionColCompareImput.createCondition(dateCol);
                    if(cond1 != null){
                        cond1.setCompareType(DBUtilsConditionColCompareImput.COMPARE_TYPE_NONE_LESS);
                        Date startDate = month.getMonthStartDate();
                        cond1.setValue(startDate);
                        condList.add(cond1);
                    }
                    DBUtilsConditionColCompareImput cond2 = DBUtilsConditionColCompareImput.createCondition(dateCol);
                    if(cond2 != null){
                        cond2.setCompareType(DBUtilsConditionColCompareImput.COMPARE_TYPE_LESS);
                        RMonth nextmonth = month.addMonth(1);
                        Date startDate = nextmonth.getMonthStartDate();
                        cond2.setValue(startDate);
                        condList.add(cond2);
                    }
                    return condList;
                }
            }
        }
        return null;
    }
//        if(queryData != null){
//            RY_IODataObjectBase ioData = this.getDataObj();
//            ArrayList<R_TypeValueBase> dataList = ioData.getDataList();
//            if(dataList != null){
//                RY_DBTableBase table = this.getTable();
//                for(int i=0; i<dataList.size(); i++){
//                    R_TypeValueBase value = dataList.get(i);
//                    if(value != null && value.isValueValid()){
//                        RY_DBColumnBase col = table.getColumnByIndex(i);
//                        if(col != null && value != null){
//                            DBUtilsConditionColEqualImput conditionID = DBUtilsConditionColEqualImput.createCondition(col);
//                            if(conditionID != null){
//                                conditionID.setValue(value);
//                                queryData.addQueryCondition(conditionID);                    
//                            }
//                        }
//                    }
//                }
//                return true;
//            }
//        }
    
}
