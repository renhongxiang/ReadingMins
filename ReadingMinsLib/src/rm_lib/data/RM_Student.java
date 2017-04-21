/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.data;

import java.util.Date;
import rcommon.rdata.common.RY_Person;
import rcommon.rdata.common.RY_User;
import rcommon.rdata.dataformat.RMonth;
import rcommon.rdata.iosystem.DataIOHandleBase;
import rcommon.rdata.iosystem.DataIOIdentity;
import rcommon.rdata.structure.RY_IODataGroupBase;
import rcommon.rdata.structure.RY_IODataGroupLinkPack;
import rcommon.rdata.structure.RY_IODataObjectBase;
import rcommon.utils.datatype.RDateUtils;

/**
 *
 * @author renhongxiang
 */
public class RM_Student extends RY_Person{
    
    private RY_User user = null;
    
// <editor-fold  desc=" Group Function ">
    
    public static RM_Student createInstance(){
        RM_Student student = new RM_Student();
        student.buildPersonIDLinker();
        return student;
    }
    
    private RM_Student(){
    }
    
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
    
    
// </editor-fold>

    public RY_User getUser() {
        return user;
    }

    public void setUser(RY_User user) {
        this.user = user;
        buildUserIDLinker();
    }
    
    protected void buildUserIDLinker(){
        RY_User user = this.getUser();
        if(user != null){
            RY_IODataGroupBase itemGroup = user.getUserDataGroup(true);
            RY_IODataGroupBase group = this.getStudentDataGroup(true);
            this.buildIDDataLink(itemGroup, group, RM_StudentIODataDefine.FN_USER_ID);
        }
    }
    
    
    public void setDailyRequestReadingMins(Integer mins){
        RY_IODataGroupBase group = this.getStudentDataGroup(true);
        if(group != null){
            group.setIntegerByName(RM_StudentIODataDefine.FN_DAILY_MINS, mins);
        }
    }
    
    public Integer getDailyRequestReadingMins(){
        RY_IODataGroupBase group = this.getStudentDataGroup(true);
        if(group != null){
            Integer value = group.getIntegerByName(RM_StudentIODataDefine.FN_DAILY_MINS, null);
            if(value != null){
                return value;
            }
        }
        return 30;
    }
    
    public String getStudentCode() {
        RY_IODataGroupBase group = this.getStudentDataGroup(true);
        if(group != null){
            return group.getStringByName(RM_StudentIODataDefine.FN_STUDENT_IDCODE, null);
        }
        return null;
    }

    public void setStudentCode(String code) {
        RY_IODataGroupBase group = this.getStudentDataGroup(true);
        if(group != null){
            group.setStringByName(RM_StudentIODataDefine.FN_STUDENT_IDCODE, code);
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
            return group.getIOID(saveHandle);
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
    
    public static RM_Student createWithIOData(RM_StudentIOData ioData){
        RM_Student student = createInstance();
        if(student != null){
            RY_IODataGroupBase group = student.getStudentDataGroup(true);
            if(group != null){
                RY_IODataObjectBase curData = group.getCurrData(true);
                if(curData != null){
                    curData.FillDataFromData(ioData, false);
                }                
                RY_IODataObjectBase lastData = group.getLastSavedData(true);
                if(lastData != null){
                    lastData.FillDataFromData(ioData, true);
                }                
            }
        }
        return student;
    }
    
    @Override
    protected RY_IODataGroupLinkPack getPersonRefLinkPack(){
        RY_IODataGroupBase group = this.getStudentDataGroup(true);
        RY_IODataGroupLinkPack pack = new RY_IODataGroupLinkPack(group, RM_StudentIODataDefine.FN_PERSON_ID);        
        return pack;
    }
    
    @Override
    protected RY_IODataGroupBase getDefaultGroup() {
        return this.getStudentDataGroup(true);
    }
    
}
