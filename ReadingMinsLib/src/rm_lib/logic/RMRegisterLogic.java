/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.logic;

import rcommon.rdata.common.RY_User;

/**
 *
 * @author renhongxiang
 */
public class RMRegisterLogic extends RMLogicBase{
    private RY_User user = null;
    
    public boolean doRegisterUser(RY_User user){
        return false;
    }
    
    private boolean ableToRegister(RY_User user){
        if(isUserExist(user)){
        }
        return true;
    }
    
    public boolean isUserExist(RY_User user){
        return false;
    }
    
    public boolean isEmailExist(RY_User user){
        return false;
    }
}
