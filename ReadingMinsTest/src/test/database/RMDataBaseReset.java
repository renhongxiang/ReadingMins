/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.database;

import rautotest.system.RAutoTestCase;
import rm_lib.application.init.RM_DataBase;

/**
 *
 * @author renhongxiang
 */
public class RMDataBaseReset extends RAutoTestCase{

    @Override
    public String getTestName(){
        return "DB-Reset";
    }
    
    @Override
    public String getTestDescription(){
        return "RM-Reset Database.";
    }
    
    
    @Override
    public boolean RunTest(){
        RM_DataBase rmDB = new RM_DataBase();
        rmDB.initDataBase();
        rmDB.rebuildTables();
        return true;
    }
    
}
