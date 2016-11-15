/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.data;

import java.util.Date;
import rcommon.rdata.common.RY_IODataGroupBase;
import rcommon.rdata.common.RY_Person;
import rcommon.rdata.common.RY_User;
import rcommon.rdata.dataformat.RMonth;
import rcommon.rdata.datavalue.R_Int_Value;
import rcommon.rdata.datavalue.R_String_Value;
import rcommon.rdata.iosystem.DataIOHandleBase;
import rcommon.rdata.iosystem.DataIOIdentity;
import rcommon.rdata.structure.RY_IODataObjectBase;
import rcommon.utils.datatype.RDateUtils;

/**
 *
 * @author renhongxiang
 */
public class RM_Student extends RY_Person{
    
    private RY_User user = null;
    
// <editor-fold  desc=" Group Function ">
    
    private RM_StudentIODataGroup studentDataGroup = null;

    private RY_IODataGroupBase getStudentDataGroup(boolean createIfNull){
        if(studentDataGroup == null && createIfNull){
            studentDataGroup = this.createStudentDataGroup();
        }
        return studentDataGroup;
    }
    
    protected RM_StudentIODataGroup createStudentDataGroup(){
        return new RM_StudentIODataGroup(this);
    }    

    public RM_StudentIOData getStudentIOData(){
        return this.getStudentIOData(false);
    }
    
    public RM_StudentIOData getStudentIOData(boolean createIfNull){        
        RY_IODataObjectBase ioData = null;
        RY_IODataGroupBase group = this.getStudentDataGroup(createIfNull);
        if(group != null){
            ioData = group.getCurrData(createIfNull);
        }
        if(ioData != null && ioData instanceof RM_StudentIOData){
            return (RM_StudentIOData)ioData;
        }        
        return null;
    }    
    
    public RM_StudentIOData getSavedStudentIOData(boolean createIfNull){        
        RY_IODataObjectBase ioData = null;
        RY_IODataGroupBase group = this.getStudentDataGroup(createIfNull);
        if(group != null){
            ioData = group.getLastSavedData(createIfNull);
        }
        if(ioData != null && ioData instanceof RM_StudentIOData){
            return (RM_StudentIOData)ioData;
        }        
        return null;
    }    
    
// </editor-fold>

    public RY_User getUser() {
        return user;
    }

    public void setUser(RY_User user) {
        this.user = user;
    }
    
    public void setDailyRequestReadingMins(Integer mins){
        RM_StudentIOData ioData = this.getStudentIOData();
        if(ioData != null){
            ioData.setDailyMins(R_Int_Value.createIntegerValue(mins));
        }
    }
    
    public Integer getDailyRequestReadingMins(){
        RM_StudentIOData ioData = this.getStudentIOData();
        if(ioData != null){
            return R_Int_Value.getIntValue(ioData.getDailyMins(), 30);
        }
        return 30;
    }
    
    public String getStudentCode() {
        RM_StudentIOData ioData = this.getStudentIOData();
        if(ioData != null){
            return R_String_Value.getStringValue(ioData.getIDCode());
        }
        return null;
    }

    public void setStudentCode(String code) {
        RM_StudentIOData ioData = this.getStudentIOData(true);
        if(ioData != null){
            ioData.setIDCode(R_String_Value.createValueFromString(code));
        }
    }
    
    
    private boolean doSaveDependent(DataIOHandleBase saveHandle){
        return true;
    }
    
    private boolean doSaveRelated(DataIOHandleBase saveHandle){
        return true;
    }

    private boolean savePrepareLoad(DataIOHandleBase saveHandle){
        RY_IODataGroupBase group = this.getStudentDataGroup(true);
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
                    if(this.doSaveStudent(saveHandle)){
                        return this.doSaveRelated(saveHandle);
                    }
                }
            }
            
        }
        return false;
    }
    
    @Override
    public boolean doLoad(DataIOHandleBase loadHandle){
        return this.doLoadStudent(loadHandle);            
    }
    
    protected boolean doLoadStudent(DataIOHandleBase ioHandle){
        RY_IODataGroupBase group = this.getStudentDataGroup(true);
        if(group != null){
            return group.doLoad(ioHandle);
        }
        return false;
    }
    
    protected boolean doSaveStudent(DataIOHandleBase saveHandle){
        RY_IODataGroupBase group = this.getStudentDataGroup(false);
        if(group != null){
            return group.doSave(saveHandle);
        }
        return true;
    }
    
    public boolean setDataToIODataStudent(DataIOHandleBase saveHandle, boolean loadOnly){
        RM_StudentIOData ioData = this.getStudentIOData(true);
        if(ioData != null){
            RY_User user = this.getUser();
            if(user != null){
                DataIOIdentity userIOID = user.getUserIOID();
                ioData.setUserID(userIOID);
            }
            
            ioData.setPersonID(this.getPersonIOID(saveHandle, loadOnly));
            return true;
        }
        return false;
    }
    
    public boolean setIODataToDataStudent(){
        RM_StudentIOData ioData = this.getStudentIOData(false);
        if(ioData != null){            
            this.setPersonIOID(ioData.getPersonID());
            return true;
        }
        
        return false;
    }
    
    public final boolean fillDataWithLoadedStudentIOData(RM_StudentIOData ioData){
        if(ioData != null){
            RY_IODataGroupBase group = this.getStudentDataGroup(true);
            if(group != null){
                return group.fillDataWithSavedData(ioData);
            }
        }
        return false;
    }
    
    public DataIOIdentity getStudentIOID() {
        return this.getStudentIOID(null, true);
    }
    
    
    public DataIOIdentity getStudentIOID(DataIOHandleBase saveHandle, boolean loadOnly) {
        RY_IODataGroupBase group = this.getStudentDataGroup(false);
        if(group != null){
            return group.getIOID(saveHandle, loadOnly);
        }
        return null;
    }
    
    public Integer getShortMins(RMonth month, Integer totalMins){
        if(month != null && totalMins != null ){
            RMonth curMonth = RMonth.getCurrMonth();
            int diff = RMonth.diffMonth(month, curMonth);
            Integer minRead = this.getDailyRequestReadingMins();
            if(diff == 0){
                Date today = new Date();
                int curDays = RDateUtils.GetDay(today);
                int totalNeed = curDays * minRead;
                return totalNeed - totalMins;
            }else if(diff > 0){
                Date lastDay = month.getMonthLastDate();
                int lastDays = RDateUtils.GetDay(lastDay);
                int totalNeed = lastDays * minRead;
                return totalNeed - totalMins;
            }
        }
        return 0;
    }
    
}
