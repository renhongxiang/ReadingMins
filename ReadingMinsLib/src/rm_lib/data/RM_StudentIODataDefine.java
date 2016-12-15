/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.data;

import java.util.List;
import rcommon.rdata.common.RY_PersonIOData;
import rcommon.rdata.common.RY_UserIOData;
import rcommon.rdata.define.RY_DataItemDefine;
import rcommon.rdata.define.RY_DataItemDefineID;
import rcommon.rdata.define.RY_DataItemDefineInteger;
import rcommon.rdata.define.RY_DataItemDefineString;
import rcommon.rdata.hb_base.HB_ForeignKey;
import rcommon.rdata.hb_base.HB_IndexKey;
import rcommon.rdata.structure.RY_IODataCommonDataDefine;

/**
 *
 * @author renhongxiang
 */
public class RM_StudentIODataDefine extends RY_IODataCommonDataDefine{

    public static final String DATA_NAME = "Student";
    
    public static final String FN_USER_ID = "User_ID";
    public static final String FN_PERSON_ID = "Person_ID";
    public static final String FN_SCHOOL_ID = "School_ID";
    public static final String FN_STUDENT_IDCODE = "Student_IDCODE";
    public static final String FN_DAILY_MINS = "Daily_Mins";
    
    public static final String DES_USER_ID = "user id of the student";
    public static final String DES_PERSON_ID = "student person id of the student personal info";
    public static final String DES_SCHOOL_ID = "student school id";
    public static final String DES_STUDENT_IDCODE = "Student ID code to indentify same name statudent";
    public static final String DES_DAILY_MINS = "Student daily reading target";
    
    
    @Override
    public String getDataName() {
        return DATA_NAME;
    }
    
    @Override
    public void buildDataDefine() {
        super.buildDataDefine();
        this.addItem(RY_DataItemDefineID.createItem(FN_USER_ID, RY_DataItemDefine.NULL_ALLOW_FALSE, FN_USER_ID, DES_USER_ID, RY_DataItemDefine.TABLE_ID_NO));
        this.addItem(RY_DataItemDefineID.createItem(FN_PERSON_ID, RY_DataItemDefine.NULL_ALLOW_FALSE, FN_PERSON_ID, DES_PERSON_ID, RY_DataItemDefine.TABLE_ID_NO));
        this.addItem(RY_DataItemDefineID.createItem(FN_SCHOOL_ID, RY_DataItemDefine.NULL_ALLOW_TRUE, FN_SCHOOL_ID, DES_SCHOOL_ID, RY_DataItemDefine.TABLE_ID_NO));
        this.addItem(RY_DataItemDefineString.createItem(FN_STUDENT_IDCODE, 10, RY_DataItemDefine.NULL_ALLOW_TRUE, FN_STUDENT_IDCODE, DES_STUDENT_IDCODE, false));
        this.addItem(RY_DataItemDefineInteger.createItem(FN_DAILY_MINS, 3, RY_DataItemDefine.NULL_ALLOW_TRUE, FN_DAILY_MINS, DES_DAILY_MINS));
    }

    @Override
    protected void buildIndexKey(List<HB_IndexKey> keyList) {
        super.buildIndexKey(keyList);
        this.addIndexKey(keyList, FN_USER_ID);
        this.addIndexKey(keyList, FN_PERSON_ID);
    }

    @Override
    protected void buildForeignKey(List<HB_ForeignKey> KeyList){
        super.buildForeignKey(KeyList);
        this.addForeignKey(KeyList, RY_PersonIOData.getPersonDataDefine(), FN_PERSON_ID);
        this.addForeignKey(KeyList, RY_UserIOData.getUserDataDefine(), FN_USER_ID);
    }
    
}
