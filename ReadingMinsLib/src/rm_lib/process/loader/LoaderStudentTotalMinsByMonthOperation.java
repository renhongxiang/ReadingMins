/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.process.loader;

import java.util.ArrayList;
import java.util.List;
import rcommon.rdata.common.RY_DataBase;
import rcommon.rdata.dataformat.RMonth;
import rcommon.rdata.datavalue.R_Int_Value;
import rcommon.rdata.iosys.operation.common.DataIOTimerOperation;
import rcommon.rdata.structure.RY_IODataObjectBase;
import rm_lib.data.RM_ReadingMins;
import rm_lib.data.RM_ReadingMinsIOData;
import rm_lib.data.RM_Student;

/**
 *
 * @author renhongxiang
 */
public class LoaderStudentTotalMinsByMonthOperation extends DataIOTimerOperation{

    private RM_Student student;
    private RMonth  month;

    private List<RM_ReadingMins> resultList = null;
    
    public RM_Student getStudent() {
        return student;
    }

    public void setStudent(RM_Student student) {
        this.student = student;
    }

    public RMonth getMonth() {
        return month;
    }

    public void setMonth(RMonth month) {
        this.month = month;
    }
    
    @Override
    protected boolean doProcessOperation() {
        RM_ReadingMins loadMins = new RM_ReadingMins();
        loadMins.setStudent(getStudent());
        loadMins.setStatus(RY_DataBase.STATUS_ACTIVE);
        loadMins.setDataToIODataReadingMins(null, true);
        RM_ReadingMinsIOData ioData = loadMins.getReadingMinsIOData();
        if(ioData != null){
            ioData.setStatus_value(R_Int_Value.createIntegerValue(RM_Student.STATUS_ACTIVE));
            List<RY_IODataObjectBase> ioDataList = ioData.doLoadListRecordByDataInMonth(this.getDataIOHandle(), ioData, month);
//            List<RY_IODataObjectBase> ioDataList = ioData.doLoadListRecordByData(this.getDataIOHandle(), ioData);
            if(ioDataList != null){
                resultList = new ArrayList<RM_ReadingMins>();
                if(resultList != null){
                    for(RY_IODataObjectBase ioDataItem: ioDataList){
                        if(ioDataItem instanceof RM_ReadingMinsIOData){
                            RM_ReadingMinsIOData loadItem = (RM_ReadingMinsIOData)ioDataItem;
                            RM_ReadingMins objItem = new RM_ReadingMins();
                            objItem.fillDataWithLoadedReadingMinsIOData(loadItem);
                            objItem.setStudent(getStudent());
                            resultList.add(objItem);
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public List<RM_ReadingMins> getResultList() {
        return resultList;
    }
    
}
