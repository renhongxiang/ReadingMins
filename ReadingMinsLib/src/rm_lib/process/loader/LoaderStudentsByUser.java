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
import rcommon.rdata.iosystem.DataIOListLoadOperation;
import rcommon.rdata.structure.RY_IODataObjectBase;
import rm_lib.data.RM_Student;
import rm_lib.data.RM_StudentIOData;

/**
 *
 * @author renhongxiang
 */
public class LoaderStudentsByUser {
    
    public List<RM_Student> loadListByUser(RY_User user){
        RM_Student student = RM_Student.createInstance();
        if(student != null){
            student.setUser(user);
            student.setStatus(RY_DataCommonBase.STATUS_ACTIVE);
            DataIOListLoadOperation oper = new DataIOListLoadOperation();
            RM_StudentIOData ioData = student.getStudentIOData();
            oper.setLoadIOData(ioData);
            if(oper.DoOperation()){
                List<RY_IODataObjectBase> objList = oper.getLoadDataList();
                if(objList != null){
                    List<RM_Student> studentList = new ArrayList<RM_Student>();
                    for(RY_IODataObjectBase obj : objList){
                        if(obj instanceof RM_StudentIOData){                            
                            RM_Student studentT = RM_Student.createWithIOData((RM_StudentIOData)obj);
                            studentList.add(studentT);
                        }
                    }
                    return studentList;
                }
            }            
        }
//        LoaderStudentsByUserOperation oper = new LoaderStudentsByUserOperation();
//        oper.setUser(user);
//        if(oper.DoOperation()){
//            return oper.getStudentList();
//        }
        return null;
    }

    
    
}
