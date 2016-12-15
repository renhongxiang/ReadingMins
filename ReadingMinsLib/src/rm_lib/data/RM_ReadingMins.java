/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.data;

import java.util.Date;
import rcommon.rdata.common.base.RY_DataCommonBase;
import rcommon.rdata.datavalue.R_Date_Value;
import rcommon.rdata.datavalue.R_Int_Value;
import rcommon.rdata.datavalue.R_String_Value;
import rcommon.rdata.iosystem.DataIOHandleBase;
import rcommon.rdata.iosystem.DataIOIdentity;
import rcommon.rdata.structure.RY_IODataGroupBase;
import rcommon.rdata.structure.RY_IODataObjectBase;

/**
 *
 * @author renhongxiang
 */
public class RM_ReadingMins extends RY_DataCommonBase{
    
    private RM_Student student = null;
    
// <editor-fold  desc=" Group Function ">
    
    private RM_ReadingMinsIODataGroup studentDataGroup = null;

    private RY_IODataGroupBase getReadingMinsDataGroup(boolean createIfNull){
        if(studentDataGroup == null && createIfNull){
            studentDataGroup = this.createReadingMinsDataGroup();
        }
        return studentDataGroup;
    }
    
    protected RM_ReadingMinsIODataGroup createReadingMinsDataGroup(){
        return new RM_ReadingMinsIODataGroup(this);
    }    

    public RM_ReadingMinsIOData getReadingMinsIOData(){
        return this.getReadingMinsIOData(false);
    }
    
    public RM_ReadingMinsIOData getReadingMinsIOData(boolean createIfNull){        
        RY_IODataObjectBase ioData = null;
        RY_IODataGroupBase group = this.getReadingMinsDataGroup(createIfNull);
        if(group != null){
            ioData = group.getCurrData(createIfNull);
        }
        if(ioData != null && ioData instanceof RM_ReadingMinsIOData){
            return (RM_ReadingMinsIOData)ioData;
        }        
        return null;
    }    
    
// </editor-fold>
 
// <editor-fold  desc="Get/Set">
    
    public Date getReadDate() {
        RM_ReadingMinsIOData ioData = this.getReadingMinsIOData();
        if(ioData != null){
            return R_Date_Value.getDateValue(ioData.getReadDate());
        }
        return null;
    }

    public void setReadDate(Date readDate) {
        RM_ReadingMinsIOData ioData = this.getReadingMinsIOData(true);
        if(ioData != null){
            ioData.setReadDate(R_Date_Value.createDateValue(readDate));
        }
    }
    
    public Integer getReadMins() {
        RM_ReadingMinsIOData ioData = this.getReadingMinsIOData();
        if(ioData != null){
            return R_Int_Value.getIntegerValue(ioData.getMins());
        }
        return null;
    }

    public void setReadMins(Integer mins) {
        RM_ReadingMinsIOData ioData = this.getReadingMinsIOData();
        if(ioData != null){
            ioData.setMins(R_Int_Value.createIntegerValue(mins));
        }
    }
    
    public String getBookTitle() {
        RM_ReadingMinsIOData ioData = this.getReadingMinsIOData();
        if(ioData != null){
            return R_String_Value.getStringValue(ioData.getBookTitle());
        }
        return null;
    }

    public void setBookTitle(String bookTitle) {
        RM_ReadingMinsIOData ioData = this.getReadingMinsIOData(true);
        if(ioData != null){
            ioData.setBookTitle(R_String_Value.createValueFromString(bookTitle));
        }
    }
    
    
// </editor-fold>

    public RM_Student getStudent() {
        return student;
    }

    public void setStudent(RM_Student student) {
        this.student = student;
        if(student != null){
            RM_StudentIOData ioData = student.getStudentIOData();
            if(ioData != null){
                DataIOIdentity id = ioData.getIoID();
                RY_IODataGroupBase group = this.getReadingMinsDataGroup(true);
                if(group != null){
                    group.setDataByName(RM_ReadingMinsIODataDefine.FN_STUDENT_ID, id);
                }
            }
        }
    }
    
    
    private boolean doSaveDependent(DataIOHandleBase saveHandle){
        return true;
    }
    
    private boolean doSaveRelated(DataIOHandleBase saveHandle){
        return true;
    }

    private boolean savePrepareLoad(DataIOHandleBase saveHandle){
        RY_IODataGroupBase group = this.getReadingMinsDataGroup(true);
        if(group != null){
            return group.doPrepareLoad(saveHandle);
        }
        return false;
    }
    
    @Override
    public boolean doSave(DataIOHandleBase saveHandle){
        if(this.savePrepareLoad(saveHandle)){
            if(super.doSave(saveHandle)){
                if(this.doSaveDependent(saveHandle)){
                    if(this.doSaveReadMins(saveHandle)){
                        return this.doSaveRelated(saveHandle);
                    }
                }
            }
            
        }
        return false;
    }
    
    protected boolean doSaveReadMins(DataIOHandleBase saveHandle){
        RY_IODataGroupBase group = this.getReadingMinsDataGroup(false);
        if(group != null){
            return group.doSave(saveHandle);
        }
        return true;
    }
    
    public boolean setDataToIODataReadingMins(DataIOHandleBase saveHandle, boolean loadOnly){
        RM_ReadingMinsIOData ioData = this.getReadingMinsIOData(true);
        if(ioData != null){
            RM_Student student = this.getStudent();
            if(student != null){
                DataIOIdentity userIOID = student.getStudentIOID();
                ioData.setStudentIOID(userIOID);
            }
            return true;
        }
        return false;
    }
    
    public final boolean fillDataWithLoadedReadingMinsIOData(RM_ReadingMinsIOData ioData){
        if(ioData != null){
            RY_IODataGroupBase group = this.getReadingMinsDataGroup(true);
            if(group != null){
                return group.fillDataWithSavedData(ioData);
            }
        }
        return false;
    }
    
    public DataIOIdentity getMinsIOID() {
        return this.getMinsIOID(null, true);
    }
    
    
    public DataIOIdentity getMinsIOID(DataIOHandleBase saveHandle, boolean loadOnly) {
        RY_IODataGroupBase group = this.getReadingMinsDataGroup(false);
        if(group != null){
            return group.getIOID(saveHandle, loadOnly);
        }
        return null;
    }
    
    public void setMinsIOID(DataIOIdentity ioID) {
        RY_IODataGroupBase group = this.getReadingMinsDataGroup(true);
        if(group != null){
            group.setIOID(ioID);
        }
    }

    @Override
    protected RY_IODataGroupBase getDefaultGroup() {
        return this.getReadingMinsDataGroup(true);
    }
    
}
