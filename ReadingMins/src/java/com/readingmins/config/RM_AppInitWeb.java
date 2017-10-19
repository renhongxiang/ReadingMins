/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.config;

import rcommon.database.rsqlbase.RY_SQLConnectionFactory;
import readinglog.app.init.RMAppSetting;
import readinglog.app.init.RMSQLConnectionMySQL;
import rm_lib.application.init.RM_AppInit;

/**
 *
 * @author renhongxiang
 */
public class RM_AppInitWeb extends RM_AppInit{

    private static final Object lock = new Object();
    
    public static void initApp(){
        if(!appInited){
            synchronized(lock){
                if(!appInited){
                    RM_AppInitWeb appInit = new RM_AppInitWeb();
                    appInit.doInit();
                    appInited = true;
                }
            }            
        }
    }
    
    @Override
    public void doInit(){
        if(!appInited){
            RMAppSetting setting = new RMAppSetting();
            RMAppSetting.setAppSetting(setting);
            
            super.doInit();
        }
    }
    
}
