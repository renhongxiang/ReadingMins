package com.readingmins.controller.user;

import com.readingmins.controller.SessionController;
import rcommon.data.session.RSessionDataPackage;
import rcommon.data.session.RSessionDataSignupPackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author renhongxiang
 */
public abstract class UserControllerBase extends SessionController{
    
    @Override
    protected RSessionDataPackage createPageData(){
        return new RSessionDataSignupPackage();
    }
       
}
