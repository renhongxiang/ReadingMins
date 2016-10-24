/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.sess;

import rcommon.data.session.RSessionDataPackage;
import rcommon.rdata.common.RY_User;

/**
 *
 * @author renhongxiang
 */
public class RM_SessDataLoginGroup extends RM_SessDataGroup{
    
    private RY_User loginUser = null;

    public RY_User getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(RY_User loginUser) {
        this.loginUser = loginUser;
    }
    
    @Override
    protected boolean copyPackageDataFrom(RSessionDataPackage curPackage){
        if(super.copyPackageDataFrom(curPackage)){
            if(curPackage instanceof RM_SessDataLoginGroup){
                RM_SessDataLoginGroup fromPackage = (RM_SessDataLoginGroup)curPackage;
                this.setLoginUser(fromPackage.getLoginUser());
            }
            return true;
        }
        return false;
    }
    
}
