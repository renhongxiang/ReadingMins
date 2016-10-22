/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.data;

import java.util.List;
import rcommon.rdata.common.RY_IODataBase;
import rcommon.rdata.dataformat.RMonth;
import rcommon.rdata.datavalue.R_Date_Value;
import rcommon.rdata.datavalue.R_Int_Value;
import rcommon.rdata.datavalue.R_String_Value;
import rcommon.rdata.datavalue.R_TypeValueBase;
import rcommon.rdata.define.RY_DataItemDefine;
import rcommon.rdata.define.RY_DataItemDefineDate;
import rcommon.rdata.define.RY_DataItemDefineID;
import rcommon.rdata.define.RY_DataItemDefineInteger;
import rcommon.rdata.define.RY_DataItemDefineString;
import rcommon.rdata.define.RY_IODataMappingManager;
import rcommon.rdata.iosystem.DataIOHandleBase;
import rcommon.rdata.iosystem.DataIOIdentity;
import rcommon.rdata.iosystem.DataIOUtilsBase;
import rcommon.rdata.structure.RY_IODataObjectBase;
import rm_lib.application.init.RM_DataIOHandle;
import rm_lib.dataio.utils.DataIOUtilReadMins;
import rm_lib.dataio.utils.RMDataIOUtilManager;

/**
 *
 * @author renhongxiang
 */
public class RM_ReadingMinsIOData extends RY_IODataBase{

    public static final String FN_DATE = "Date";
    public static final String FN_MINS = "Minds";
    public static final String FN_TITLE = "TITLE";
    public static final String FN_STUDENT_ID = "Student_ID";
    
    public static final String DES_DATE = "Date of reading";
    public static final String DES_MINS = "How many minutes student readed";
    public static final String DES_TITLE = "Title of the book";
    public static final String DES_STUDENT_ID = "ID of the Student";
    
    private static RY_IODataMappingManager bankAccountIODataMapManager = null;
    
    @Override
    public RY_IODataMappingManager getDataManagerMan(){
        return getStaticMapManager();
    }
    
    public static RY_IODataMappingManager getStaticMapManager(){
        if(bankAccountIODataMapManager == null){
            bankAccountIODataMapManager = new RY_IODataMappingManager();
            if(!buildMapManager(bankAccountIODataMapManager)){
            }
        }
        return bankAccountIODataMapManager;
    }
    
    protected static boolean buildMapManager(RY_IODataMappingManager man){
        if(man != null){
            RY_IODataBase.buildMapManager(man);
            man.addItem(RY_DataItemDefineDate.createItem(FN_DATE, RY_DataItemDefine.NULL_ALLOW_FALSE, FN_DATE, DES_DATE));
            man.addItem(RY_DataItemDefineString.createItem(FN_TITLE, 40, RY_DataItemDefine.NULL_ALLOW_TRUE, FN_TITLE, DES_TITLE, false));
            man.addItem(RY_DataItemDefineInteger.createItem(FN_MINS, 2, RY_DataItemDefine.NULL_ALLOW_FALSE, FN_MINS, DES_MINS));
            man.addItem(RY_DataItemDefineID.createItem(FN_STUDENT_ID, RY_DataItemDefine.NULL_ALLOW_FALSE, FN_STUDENT_ID, DES_STUDENT_ID, RY_DataItemDefine.TABLE_ID_NO));
            return true;
        }
        return false;
    }
    
    
    @Override
    protected DataIOUtilsBase getDataIOUtil(DataIOHandleBase ioHandle) {
        return getReadingMinsSaveUtil(ioHandle);
    }

    protected DataIOUtilReadMins getReadingMinsSaveUtil(DataIOHandleBase saveHandle){
        if(saveHandle != null){
            if(saveHandle instanceof RM_DataIOHandle){
                RM_DataIOHandle rmIOHandle = (RM_DataIOHandle)saveHandle;
                RMDataIOUtilManager ioMan =rmIOHandle.getRmDataIOManager();
                if(ioMan != null){
                    return ioMan.getReadingMinsDataIOUtil();
                }
            }
        }
        return null;
    }
    
    
    @Override
    protected RY_IODataObjectBase createObject() {
        return new RM_ReadingMinsIOData();
    }
    
    
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
    
}
