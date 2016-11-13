/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.application.init;

import rcommon.rdata.iosystem.DataIOFactoryManager;
import rcommon.rdata.iosystem.DataIOOperationFactory;
import rcommon.database.rsqlbase.RY_SQLConnectionFactory;
import rcommon.rdata.iosys.operation.common.DataIOTimerOperation;
import readinglog.app.init.RMAppSetting;
import readinglog.app.init.RMSQLConnectionMySQL;
import rytable.RY_TableManager;
import rytable.ini.DBInitBase;

/**
 *
 * @author renhongxiang
 */
public class RM_AppInit extends DBInitBase{

    private static boolean appInited = false;
    private static final Object lock = new Object();
    
    public static void initApp(){
        if(!appInited){
            synchronized(lock){
                if(!appInited){
                    RM_AppInit appInit = new RM_AppInit();
                    appInit.doInit();
                    appInited = true;
                }
            }            
        }
    }
    
    @Override
    protected int getDataBaseType() {
        return DBInitBase.DBTYPE_MYSQL;
    }

    @Override
    protected RY_SQLConnectionFactory getConnectFact(){
        return new RMSQLConnectionMySQL();
    }
    
    @Override
    protected String getTBNamePrefix(){
        return "RM_";
    }

    @Override
    public RY_TableManager createTableManager() {
        return new RM_DataBase();
    }
    
    protected DataIOOperationFactory createOperationFactory(){
        RM_DataIOOperationFactory opDataIOHandleFact = new RM_DataIOOperationFactory();
        return opDataIOHandleFact;
    }
    
    @Override
    public RY_SQLConnectionFactory createSQLConnection(){
        return new RMSQLConnectionMySQL();
    }

    @Override
    public void doInit(){
        if(!appInited){
            RMAppSetting setting = new RMAppSetting();
            RMAppSetting.setAppSetting(setting);

            RM_EmailSetting emailSetting = new RM_EmailSetting();
            RM_EmailSetting.initInstance(emailSetting);
            
            super.doInit();

            DataIOFactoryManager.setDefaultDataFactory(createOperationFactory());
            RMTimerUserFactory defaultUserFact = new RMTimerUserFactory();
            DataIOTimerOperation.setUserFact(defaultUserFact);
        }
    }
}
