/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.base;

import rcommon.data.session.RSessionDataLoginPackage;
import rcommon.data.session.RSessionDataPackage;

/**
 *
 * @author renhongxiang
 */
public abstract class LoginedControllerBase extends SessionController{
    
    @Override
    protected RSessionDataPackage createPageData(){
        return new RSessionDataLoginPackage();
    }
    
}
