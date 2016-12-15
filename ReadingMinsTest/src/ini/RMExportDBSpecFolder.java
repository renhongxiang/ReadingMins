/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ini;

import rcommon.fileIO.ini.RIniItemFolder;

/**
 *
 * @author renhongxiang
 */
public class RMExportDBSpecFolder extends RIniItemFolder{

    private static final String FOLDER_KEY = "DB_SPEC_FOLDER";
    
    public RMExportDBSpecFolder() {
        super(FOLDER_KEY);
    }
    
}
