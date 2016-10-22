/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.data;

import rcommon.rdata.common.RY_DataBase;
import rcommon.rdata.common.RY_IODataGroupBase;
import rcommon.rdata.iosystem.DataIOHandleBase;
import rcommon.rdata.iosystem.DataIOIdentity;
import rcommon.rdata.structure.RY_IODataObjectBase;

/**
 *
 * @author renhongxiang
 */
public class RM_StudentIODataGroup extends RY_IODataGroupBase{

    public RM_StudentIODataGroup(RY_DataBase data) {
        super(data);
    }

    @Override
    protected boolean setDataToIOData(DataIOHandleBase ioHandle, boolean loadOnly) {
        RM_Student student = this.getStudent();
        if(student != null){
            return student.setDataToIODataStudent(ioHandle, loadOnly);
        }
        return false;
    }

    @Override
    protected boolean setIODataToData() {
        RM_Student student = this.getStudent();
        if(student != null){
            return student.setIODataToDataStudent();
        }
        return false;
    }

    @Override
    public RY_IODataObjectBase createIOData() {
        return new RM_StudentIOData();
    }

    @Override
    protected DataIOIdentity getInheritanceIOID(DataIOHandleBase saveHandle, boolean loadOnly) {
        return null;
    }
    
    private RM_Student getStudent(){
        RY_DataBase obj = this.getDataObj();
        if(obj != null){
            if(obj instanceof RM_Student){
                return (RM_Student)obj;
            }
        }
        return null;
    }
    
}
