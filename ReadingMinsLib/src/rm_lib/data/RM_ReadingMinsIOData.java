/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.data;

import java.util.List;
import rcommon.rdata.dataformat.RMonth;
import rcommon.rdata.datavalue.R_Date_Value;
import rcommon.rdata.datavalue.R_Int_Value;
import rcommon.rdata.datavalue.R_String_Value;
import rcommon.rdata.datavalue.R_TypeValueBase;
import rcommon.rdata.iosystem.DataIOHandleBase;
import rcommon.rdata.iosystem.DataIOIdentity;
import rcommon.rdata.structure.RY_IODataBase;
import rcommon.rdata.structure.RY_IODataDefine;
import rcommon.rdata.structure.RY_IODataObjectBase;
import static rm_lib.data.RM_ReadingMinsIODataDefine.FN_DATE;
import static rm_lib.data.RM_ReadingMinsIODataDefine.FN_MINS;
import static rm_lib.data.RM_ReadingMinsIODataDefine.FN_STUDENT_ID;
import static rm_lib.data.RM_ReadingMinsIODataDefine.FN_TITLE;
import rm_lib.dataio.utils.DataIOUtilReadMins;
import rm_lib.dataio.utils.database.DBUtilReadMins;

/**
 *
 * @author renhongxiang
 */
public class RM_ReadingMinsIOData extends RY_IODataBase{

    
//    
//    @Override
//    protected DataIOUtilsBase getDataIOUtil(DataIOHandleBase ioHandle) {
//        return getReadingMinsSaveUtil(ioHandle);
//    }
//

    protected DataIOUtilReadMins getReadingMinsSaveUtil(DataIOHandleBase saveHandle){
        if(saveHandle != null){
            return new DBUtilReadMins();
        }
        return null;
    }
    
    
//    @Override
//    protected RY_IODataObjectBase createObject() {
//        return new RM_ReadingMinsIOData();
//    }
    
    
// <editor-fold  desc=" Get/Set">
    public R_Date_Value getReadDate() {
        R_TypeValueBase value = this.getValueByName(FN_DATE);
        if (value instanceof R_Date_Value) {
            return (R_Date_Value) value;
        }
        return null;
    }

    public void setReadDate(R_Date_Value readDate) {
        this.setValueByName(FN_DATE, readDate);
    }

    public R_Int_Value getMins() {
        R_TypeValueBase value = this.getValueByName(FN_MINS);
        if (value instanceof R_Int_Value) {
            return (R_Int_Value) value;
        }
        return null;
    }

    public void setMins(R_Int_Value type) {
        this.setValueByName(FN_MINS, type);
    }
    
    public R_String_Value getBookTitle() {
        R_TypeValueBase value = this.getValueByName(FN_TITLE);
        if (value instanceof R_String_Value) {
            return (R_String_Value) value;
        }
        return null;
    }

    public void setBookTitle(R_String_Value title) {
        this.setValueByName(FN_TITLE, title);
    }
    
    public DataIOIdentity getStudentIOID() {
        R_TypeValueBase value = this.getValueByName(FN_STUDENT_ID);
        if(value instanceof DataIOIdentity){
            return (DataIOIdentity)value;
        }
        return null;
    }

    public void setStudentIOID(DataIOIdentity companyAddressIOID) {
        this.setValueByName(FN_STUDENT_ID, companyAddressIOID);
    }
    
// </editor-fold>
    
    
    public List<RY_IODataObjectBase> doLoadListRecordByDataInMonth(DataIOHandleBase ioHandle, RM_ReadingMinsIOData info, RMonth month){
        if(info != null){
            DataIOUtilReadMins util = this.getReadingMinsSaveUtil(ioHandle);
            if(util != null){
                return util.loanRecListByInfoInMonth(ioHandle,info, month);
            }
        }
        return null;
    }

    private static RM_ReadingMinsIODataDefine readingMinDataDefine = null;
    
    @Override
    public RY_IODataDefine getDataDefine() {
//        readingMinDataDefine = (RM_ReadingMinsIODataDefine)this.getDataDefine(readingMinDataDefine);
        return readingMinDataDefine;
    }

//    @Override
//    protected RY_IODataDefine createDataDefine() {
//        return new RM_ReadingMinsIODataDefine();
//    }

    public static RM_ReadingMinsIODataDefine getReadingMinDataDefine() {
        if(readingMinDataDefine == null){
            readingMinDataDefine = new RM_ReadingMinsIODataDefine();
            readingMinDataDefine.buildDataDefine();
        }        
        return readingMinDataDefine;
    }
    
    @Override
    protected RY_IODataObjectBase createObject() {
        return new RM_ReadingMinsIOData();
    }
    
}
