package readingminstest;

import rcommon.database.rsqlbase.RY_SQLConnectionFactory;
import readinglog.app.init.RMAppSetting;
import readinglog.app.init.RMSQLConnectionMySQL;
import rm_lib.application.init.RM_AppInit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author renhongxiang
 */
public class RM_AppInitTest extends RM_AppInit{

    private static final Object lock = new Object();
    
    public static void initApp(){
        if(!appInited){
            synchronized(lock){
                if(!appInited){
                    RM_AppInitTest appInit = new RM_AppInitTest();
                    appInit.doInit();
                    appInited = true;
                }
            }            
        }
    }
    
    @Override
    protected RY_SQLConnectionFactory getConnectFact() {
        return new RMSQLConnectionMySQL();
    }

    @Override
    public RY_SQLConnectionFactory createSQLConnection() {
        return new RMSQLConnectionMySQL();
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
