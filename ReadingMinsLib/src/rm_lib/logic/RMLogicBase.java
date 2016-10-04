/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.logic;

import rcommon.rerror.RErrorManager;
import rcommon.rerror.RErrorSupportObject;

/**
 *
 * @author renhongxiang
 */
public class RMLogicBase extends RErrorSupportObject{
    
    
    @Override
    public RErrorManager getErrorManager() {
        RErrorManager errManager = super.getErrorManager();
        if(errManager == null){
            errManager = new RErrorManager();
            this.setErrorManager(errManager);
        }
        return super.getErrorManager();
    }
    
}
