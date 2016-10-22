/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.dataio.utils;

import java.util.List;
import rcommon.rdata.dataformat.RMonth;
import rcommon.rdata.iosystem.DataIOHandleBase;
import rcommon.rdata.iosystem.DataIOUtilsBase;
import rcommon.rdata.structure.RY_IODataObjectBase;
import rm_lib.data.RM_ReadingMinsIOData;

/**
 *
 * @author renhongxiang
 */
public abstract class DataIOUtilReadMins extends DataIOUtilsBase{

    public List<RY_IODataObjectBase> loanRecListByInfoInMonth(DataIOHandleBase ioHandle, RM_ReadingMinsIOData minsInfo, RMonth month){
        return null;
    }
    
}
