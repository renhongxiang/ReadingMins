/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.dataio.utils.database;

import rcommon.rdata.structure.RY_IODataStorage;
import rm_lib.database.RM_StudentTB;
import rm_lib.dataio.utils.DataIOUtilStudent;

/**
 *
 * @author renhongxiang
 */
public class DBUtilStudent extends DataIOUtilStudent{

    
    private RM_StudentTB getDataTable(){
        return RM_StudentTB.createInstance();
    }            
    
}
