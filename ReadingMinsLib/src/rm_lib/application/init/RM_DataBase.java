/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.application.init;

import rm_lib.database.RM_ReadingMinsTB;
import rm_lib.database.RM_StudentTB;
import rytable.RY_TableManager;
import rytable.common.RY_AddressTB;
import rytable.common.RY_CompanyTB;
import rytable.common.RY_ContactInfoTB;
import rytable.common.RY_EmailTB;
import rytable.common.RY_LockIDTB;
import rytable.common.RY_PersonTB;
import rytable.common.RY_PhoneTB;
import rytable.common.RY_TimerTB;
import rytable.common.RY_UserTB;

/**
 *
 * @author renhongxiang
 */
public class RM_DataBase extends RY_TableManager{
    
    @Override
    public boolean initDataBase() {
        this.addTable(RY_TimerTB.createInstance());
        this.addTable(RY_LockIDTB.createInstance());
        this.addTable(RY_PersonTB.createInstance());
        this.addTable(RY_UserTB.createInstance());
        this.addTable(RY_AddressTB.createInstance()); 
        this.addTable(RY_CompanyTB.createInstance());
        this.addTable(RY_ContactInfoTB.createInstance());
        this.addTable(RY_PhoneTB.createInstance());
        this.addTable(RY_EmailTB.createInstance());
        this.addTable(RM_StudentTB.createInstance());
        this.addTable(RM_ReadingMinsTB.createInstance());
        return false;
    }    
}
