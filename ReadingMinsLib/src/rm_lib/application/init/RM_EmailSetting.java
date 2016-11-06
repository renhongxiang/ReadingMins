/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.application.init;

import rcommon.email.R_EmailSetting;

/**
 *
 * @author renhongxiang
 */
public class RM_EmailSetting extends R_EmailSetting{
    
    
    
    @Override
    public String getHost(){
        return "smtp.gmail.com";
    }
    
    @Override
    public int getSmtpPort(){
        return 465;
    }
    
    @Override
    public String getUserName(){
        return "ereadinglog@gmail.com";        
    }
    
    @Override
    public String getPassword(){
        return "Rhxzlq01";
    }
    
    @Override
    public boolean isSSLConnect(){
        return true;
    }
    
    @Override
    public String defaultFromAddress(){
        return "ereadinglog@gmail.com";
    }
    
}
