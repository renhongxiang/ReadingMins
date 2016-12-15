/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.data;

import rcommon.rdata.datavalue.R_TypeValueBase;
import rcommon.rdata.datavalue.R_Int_Value;
import rcommon.rdata.datavalue.R_String_Value;
import rcommon.rdata.iosystem.DataIOIdentity;
import rcommon.rdata.structure.RY_IODataBase;
import rcommon.rdata.structure.RY_IODataDefine;
import rcommon.rdata.structure.RY_IODataObjectBase;
import static rm_lib.data.RM_StudentIODataDefine.FN_DAILY_MINS;
import static rm_lib.data.RM_StudentIODataDefine.FN_PERSON_ID;
import static rm_lib.data.RM_StudentIODataDefine.FN_SCHOOL_ID;
import static rm_lib.data.RM_StudentIODataDefine.FN_STUDENT_IDCODE;
import static rm_lib.data.RM_StudentIODataDefine.FN_USER_ID;

/**
 *
 * @author renhongxiang
 */
public class RM_StudentIOData extends RY_IODataBase{

//    @Override
//    protected DataIOUtilsBase getDataIOUtil(DataIOHandleBase ioHandle) {
//        return this.getStudentSaveUtil(ioHandle);
//    }
//
//    protected DataIOUtilStudent getStudentSaveUtil(DataIOHandleBase saveHandle){
//        if(saveHandle != null){
//            if(saveHandle instanceof RM_DataIOHandle){
//                RM_DataIOHandle rmIOHandle = (RM_DataIOHandle)saveHandle;
//                RMDataIOUtilManager ioMan =rmIOHandle.getRmDataIOManager();
//                if(ioMan != null){
//                    return ioMan.getStudentDataIOUtil();
//                }
//            }
//        }
//        return null;
//    }
    
    private static RM_StudentIODataDefine studentDataDefine = null;
    
    @Override
    public RY_IODataDefine getDataDefine() {
//        studentDataDefine = (RM_StudentIODataDefine)this.getDataDefine(studentDataDefine);
        return studentDataDefine;
    }

//    @Override
//    protected RY_IODataDefine createDataDefine() {
//        return new RM_StudentIODataDefine();
//    }

    public static RM_StudentIODataDefine getStudentDataDefine() {
        if(studentDataDefine == null){
            studentDataDefine = new RM_StudentIODataDefine();
            studentDataDefine.buildDataDefine();
        }        
        return studentDataDefine;
    }
    
    @Override
    protected RY_IODataObjectBase createObject() {
        return new RM_StudentIOData();
    }
    
// <editor-fold  desc=" Get/Set">
    public DataIOIdentity getUserID() {
        R_TypeValueBase value = this.getValueByName(FN_USER_ID);
        if (value instanceof DataIOIdentity) {
            return (DataIOIdentity) value;
        }
        return null;
    }

    public void setUserID(DataIOIdentity userID) {
        this.setValueByName(FN_USER_ID, userID);
    }

    public DataIOIdentity getPersonID() {
        R_TypeValueBase value = this.getValueByName(FN_PERSON_ID);
        if (value instanceof DataIOIdentity) {
            return (DataIOIdentity) value;
        }
        return null;
    }

    public void setPersonID(DataIOIdentity personID) {
        this.setValueByName(FN_PERSON_ID, personID);
    }

    public DataIOIdentity getSchoolID() {
        R_TypeValueBase value = this.getValueByName(FN_SCHOOL_ID);
        if (value instanceof DataIOIdentity) {
            return (DataIOIdentity) value;
        }
        return null;
    }

    public void setSchoolID(DataIOIdentity schoolID) {
        this.setValueByName(FN_SCHOOL_ID, schoolID);
    }
    
    public R_String_Value getIDCode() {
        R_TypeValueBase value = this.getValueByName(FN_STUDENT_IDCODE);
        if(value instanceof R_String_Value){
            return (R_String_Value)value;
        }
        return null;
    }

    public void setIDCode(R_String_Value code) {
        this.setValueByName(FN_STUDENT_IDCODE, code);
    }
    
    public R_Int_Value getDailyMins() {
        R_TypeValueBase value = this.getValueByName(FN_DAILY_MINS);
        if (value instanceof R_Int_Value) {
            return (R_Int_Value) value;
        }
        return null;
    }

    public void setDailyMins(R_Int_Value type) {
        this.setValueByName(FN_DAILY_MINS, type);
    }
    
// </editor-fold>
    
}
