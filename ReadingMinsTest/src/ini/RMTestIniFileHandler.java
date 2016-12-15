/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ini;

import rcommon.fileIO.ini.RIniFileModuleHandler;
import rcommon.fileIO.ini.RInitModuleDataBase;
import rcommon.fileIO.ini.RInitModuleExcel;

/**
 *
 * @author renhongxiang
 */
public class RMTestIniFileHandler extends RIniFileModuleHandler{
    
    @Override
    public void BuildInitHandle() {
        RInitModuleExcel excelModule = new RInitModuleExcel();
        this.addModule(excelModule);
        
        RInitModuleDataBase databaseModule = new RInitModuleDataBase();
        databaseModule.buildModule();
        this.addModule(databaseModule);
        
        RMInitModuleFolderPaths pathModule = new RMInitModuleFolderPaths();
        pathModule.buildModule();
        this.addModule(pathModule);
    }
    
}
