/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.application.init;

import rcommon.database.rsqlbase.RY_SQLConnectionFactory;
import rcommon.rdata.iosystem.DataIOFactoryManager;
import rcommon.rdata.iosystem.DataIOOperationFactory;
import rcommon.rdata.iosys.operation.common.DataIOTimerOperation;
import rcommon.rdata.structure.RY_IODataCommonDataDefine;
import readinglog.app.init.RMSQLConnectionMySQL;
import rm.encrypt.RMEncryptInit;
import rytable.RY_DataBaseInitBase;
import rytable.RY_DataBaseInitMySQL;
//import readinglog.app.init.RMAppSetting;
//import readinglog.app.init.RMSQLConnectionMySQL;
import rytable.RY_TableManager;
import rytable.ini.DBInitBase;

/**
 *
 * @author renhongxiang
 */
public class RM_AppInit extends DBInitBase{
    
    protected static boolean appInited = false;
    
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
    
//    @Override
//    public RY_SQLConnectionFactory createSQLConnection(){
//        return new RMSQLConnectionMySQL();
//    }

    @Override
    public void doInit(){
        if(!appInited){
            RY_IODataCommonDataDefine.setIsLockAllowNull(true);
            
            this.initDataBase();
            
            this.initEmail();
            
            super.doInit();

            DataIOFactoryManager.setDefaultDataFactory(createOperationFactory());
            RMTimerUserFactory defaultUserFact = new RMTimerUserFactory();
            DataIOTimerOperation.setUserFact(defaultUserFact);
            
            RMEncryptInit encryyptLib = new RMEncryptInit();
            encryyptLib.InitLib();
            
            appInited = true;
        }
    }
    
    protected void initEmail(){
        RM_EmailSetting emailSetting = new RM_EmailSetting();
        RM_EmailSetting.initInstance(emailSetting);
    }
    
    public void initDataBase(){
        initDBConnectionFact();
        initDataBaseSript();
        
    }
    
    protected void initDBConnectionFact(){
        RMSQLConnectionMySQL sqlFact = new RMSQLConnectionMySQL(); // special connection class with setting
        RY_SQLConnectionFactory.setFactory(sqlFact);        
    }
    
    protected void initDataBaseSript(){
        RY_DataBaseInitBase dbinit = new RY_DataBaseInitMySQL(); // generate type class
        dbinit.DataBaseInit();
    }
    
    
}
