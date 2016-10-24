/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller;

import rcommon.data.session.RSessionDataPackage;
import rm_lib.sess.RM_SessDataLoginGroup;

/**
 *
 * @author renhongxiang
 */
public class LoginedControllerBase extends SessionController{
    
    @Override
    protected RSessionDataPackage createPageData(){
        return new RM_SessDataLoginGroup();
    }
    
}
