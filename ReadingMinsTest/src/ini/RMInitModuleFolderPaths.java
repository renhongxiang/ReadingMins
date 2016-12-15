/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ini;

import rcommon.fileIO.ini.RInitModuleFolderPaths;

/**
 *
 * @author renhongxiang
 */
public class RMInitModuleFolderPaths extends RInitModuleFolderPaths{

    @Override
    public void buildModule() {
        this.addItem(new RMExportDBSpecFolder());
    }
    
}
