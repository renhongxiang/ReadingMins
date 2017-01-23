/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.process.loader;

import java.util.ArrayList;
import java.util.List;
import rcommon.rdata.common.RY_User;
import rcommon.rdata.common.base.RY_DataCommonBase;
import rcommon.rdata.datavalue.R_Int_Value;
import rcommon.rdata.iosys.operation.common.DataIOTimerOperation;
import rcommon.rdata.structure.RY_IODataObjectBase;
import rm_lib.data.RM_Student;
import rm_lib.data.RM_StudentIOData;

/**
 *
 * @author renhongxiang
 */
public class LoaderStudentsByUserOperation extends DataIOTimerOperation{
    
    private RY_User studentUser = null;
    
    private List<RM_Student> studentList = null;

    public List<RM_Student> getStudentList() {
        return studentList;
    }

    public RY_User getStudentUser() {
        return studentUser;
    }

    public void setStudentUser(RY_User studentUser) {
        this.studentUser = studentUser;
    }
    

    @Override
    protected boolean doProcessOperation() {
        RM_Student student = RM_Student.createInstance();
        student.setUser(user);
        student.setStatus(RY_DataCommonBase.STATUS_ACTIVE);
//        student.setDataToIODataStudent(null, true);
        RM_StudentIOData ioData = student.getStudentIOData();
        if(ioData != null){
            ioData.setStatus_value(R_Int_Value.createIntegerValue(RM_Student.STATUS_ACTIVE));
            List<RY_IODataObjectBase> ioDataList = ioData.doLoadListRecordByData(this.getDataIOHandle(), ioData);
            if(ioDataList != null){
                studentList = new ArrayList<RM_Student>();
                if(studentList != null){
                    for(RY_IODataObjectBase ioDataItem: ioDataList){
                        if(ioDataItem instanceof RM_StudentIOData){
                            RM_StudentIOData loadItem = (RM_StudentIOData)ioDataItem;
                            RM_Student studentItem = RM_Student.createInstance();
                            studentItem.fillDataWithLoadedStudentIOData(loadItem);
                            studentItem.setUser(user);
                            studentList.add(studentItem);
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }
    
}
