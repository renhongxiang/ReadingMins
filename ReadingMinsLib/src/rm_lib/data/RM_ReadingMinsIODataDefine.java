/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.data;

import java.util.List;
import rcommon.rdata.define.RY_DataItemDefine;
import rcommon.rdata.define.RY_DataItemDefineDate;
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
public class RM_ReadingMinsIODataDefine extends RY_IODataCommonDataDefine{

    public static final String DATA_NAME = "ReadMins";

    public static final String FN_DATE = "Date";
    public static final String FN_MINS = "Minds";
    public static final String FN_TITLE = "TITLE";
    public static final String FN_STUDENT_ID = "Student_ID";
    
    
    public static final String DES_DATE = "Date of reading";
    public static final String DES_MINS = "How many minutes student readed";
    public static final String DES_TITLE = "Title of the book";
    public static final String DES_STUDENT_ID = "ID of the Student";
    

    @Override
    public String getDataName() {
        return DATA_NAME;
    }
    
    @Override
    public void buildDataDefine() {
        super.buildDataDefine();
        this.addItem(RY_DataItemDefineDate.createItem(FN_DATE, RY_DataItemDefine.NULL_ALLOW_FALSE, FN_DATE, DES_DATE));
        this.addItem(RY_DataItemDefineString.createItem(FN_TITLE, 40, RY_DataItemDefine.NULL_ALLOW_TRUE, FN_TITLE, DES_TITLE, false));
        this.addItem(RY_DataItemDefineInteger.createItem(FN_MINS, 4, RY_DataItemDefine.NULL_ALLOW_FALSE, FN_MINS, DES_MINS));
        this.addItem(RY_DataItemDefineID.createItem_1(FN_STUDENT_ID, RY_DataItemDefine.NULL_ALLOW_FALSE, FN_STUDENT_ID, DES_STUDENT_ID, RY_DataItemDefine.TABLE_ID_NO));
    }

    @Override
    protected void buildIndexKey(List<HB_IndexKey> keyList) {
        super.buildIndexKey(keyList);
        this.addIndexKey(keyList, FN_DATE);
        this.addIndexKey(keyList, FN_STUDENT_ID, FN_DATE);
    }

    @Override
    protected void buildForeignKey(List<HB_ForeignKey> KeyList){
        super.buildForeignKey(KeyList);
        this.addForeignKey(KeyList, RM_StudentIOData.getStudentDataDefine(), FN_STUDENT_ID);
    }
    
}
