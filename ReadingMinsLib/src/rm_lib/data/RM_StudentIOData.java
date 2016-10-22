/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.data;

import rcommon.rdata.datavalue.R_TypeValueBase;
import rcommon.rdata.common.RY_IODataBase;
import rcommon.rdata.datavalue.R_Int_Value;
import rcommon.rdata.datavalue.R_String_Value;
import rcommon.rdata.define.RY_DataItemDefine;
import rcommon.rdata.define.RY_DataItemDefineID;
import rcommon.rdata.define.RY_DataItemDefineInteger;
import rcommon.rdata.define.RY_DataItemDefineString;
import rcommon.rdata.define.RY_IODataMappingManager;
import rcommon.rdata.iosystem.DataIOHandleBase;
import rcommon.rdata.iosystem.DataIOIdentity;
import rcommon.rdata.iosystem.DataIOUtilsBase;
import rcommon.rdata.structure.RY_IODataObjectBase;
import rm_lib.application.init.RM_DataIOHandle;
import rm_lib.dataio.utils.DataIOUtilStudent;
import rm_lib.dataio.utils.RMDataIOUtilManager;

/**
 *
 * @author renhongxiang
 */
public class RM_StudentIOData extends RY_IODataBase{

    public static final String FN_USER_ID = "User_ID";
    public static final String FN_PERSON_ID = "Person_ID";
    public static final String FN_SCHOOL_ID = "School_ID";
    public static final String FN_STUDENT_IDCODE = "Student_IDCODE";
    
    public static final String DES_USER_ID = "user id of the student";
    public static final String DES_PERSON_ID = "student person id of the student personal info";
    public static final String DES_SCHOOL_ID = "student school id";
    public static final String DES_STUDENT_IDCODE = "Student ID code to indentify same name statudent";
    
    
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
            
            man.addItem(RY_DataItemDefineID.createItem(FN_USER_ID, RY_DataItemDefine.NULL_ALLOW_FALSE, FN_USER_ID, DES_USER_ID, RY_DataItemDefine.TABLE_ID_NO));
            man.addItem(RY_DataItemDefineID.createItem(FN_PERSON_ID, RY_DataItemDefine.NULL_ALLOW_FALSE, FN_PERSON_ID, DES_PERSON_ID, RY_DataItemDefine.TABLE_ID_NO));
            man.addItem(RY_DataItemDefineID.createItem(FN_SCHOOL_ID, RY_DataItemDefine.NULL_ALLOW_TRUE, FN_SCHOOL_ID, DES_SCHOOL_ID, RY_DataItemDefine.TABLE_ID_NO));
            man.addItem(RY_DataItemDefineString.createItem(FN_STUDENT_IDCODE, 10, RY_DataItemDefine.NULL_ALLOW_TRUE, FN_STUDENT_IDCODE, DES_STUDENT_IDCODE, false));
            
            return true;
        }
        return false;
    }
    
    @Override
    protected DataIOUtilsBase getDataIOUtil(DataIOHandleBase ioHandle) {
        return this.getStudentSaveUtil(ioHandle);
    }

    protected DataIOUtilStudent getStudentSaveUtil(DataIOHandleBase saveHandle){
        if(saveHandle != null){
            if(saveHandle instanceof RM_DataIOHandle){
                RM_DataIOHandle rmIOHandle = (RM_DataIOHandle)saveHandle;
                RMDataIOUtilManager ioMan =rmIOHandle.getRmDataIOManager();
                if(ioMan != null){
                    return ioMan.getStudentDataIOUtil();
                }
            }
        }
        return null;
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
    
// </editor-fold>
    
}
