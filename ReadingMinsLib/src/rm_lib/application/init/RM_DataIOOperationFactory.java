/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.application.init;

import rcommon.rdata.iosystem.DataIOHandleBase;
import rcommon.rdata.iosystem.DataIOOperationFactory;
import rytable.data.iosys.dbutils.DataIODBUtilManager;

/**
 *
 * @author renhongxiang
 */
public class RM_DataIOOperationFactory extends DataIOOperationFactory{
    
    @Override
    public DataIOHandleBase createIOHandle(){
        
        RM_DataIOHandle handle = new RM_DataIOHandle();

        DataIODBUtilManager dataIOUtilMan = new DataIODBUtilManager();
        handle.setDataIOUtilManager(dataIOUtilMan);
        
        return handle;
    }
    
}
