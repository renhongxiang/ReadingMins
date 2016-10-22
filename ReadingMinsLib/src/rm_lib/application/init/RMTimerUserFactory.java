/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.application.init;

import rcommon.rdata.common.RY_User;
import rcommon.rdata.iosys.operation.common.DataIOTimerOperationUserFactory;
import rcommon.rdata.iosystem.DataIOHandleBase;

/**
 *
 * @author renhongxiang
 */
public class RMTimerUserFactory extends DataIOTimerOperationUserFactory{
    
    @Override
    public RY_User getDefaultUser(DataIOHandleBase ioHandle){
        return null;
    }
    
}
