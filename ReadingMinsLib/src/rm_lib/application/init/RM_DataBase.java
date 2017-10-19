/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.application.init;

import rm_lib.database.RM_ReadingMinsTB;
import rm_lib.database.RM_StudentTB;
import rytable.RY_TableManager;

/**
 *
 * @author renhongxiang
 */
public class RM_DataBase extends RY_TableManager{
    
    @Override
    public boolean initDataBase() {
        super.initDataBase();
        this.addTable(RM_StudentTB.createInstance());
        this.addTable(RM_ReadingMinsTB.createInstance());
        return true;
    }    
}
