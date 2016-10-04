/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.data;

import rcommon.rdata.common.RY_DataBase;
import rcommon.rdata.common.RY_IODataGroupBase;
import rcommon.rdata.common.RY_User;
import rcommon.rdata.structure.RY_IODataObjectBase;

/**
 *
 * @author renhongxiang
 */
public class RM_Student extends RY_DataBase{
    
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
    
// </editor-fold>

    public RY_User getUser() {
        return user;
    }

    public void setUser(RY_User user) {
        this.user = user;
    }
    
    
    
}
