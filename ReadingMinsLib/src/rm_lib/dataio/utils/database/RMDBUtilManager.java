/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.dataio.utils.database;

import rm_lib.dataio.utils.DataIOUtilReadMins;
import rm_lib.dataio.utils.DataIOUtilStudent;
import rm_lib.dataio.utils.RMDataIOUtilManager;

/**
 *
 * @author renhongxiang
 */
public class RMDBUtilManager implements RMDataIOUtilManager{

    @Override
    public DataIOUtilStudent getStudentDataIOUtil() {
        return new DBUtilStudent();
    }
    
    @Override
    public DataIOUtilReadMins getReadingMinsDataIOUtil(){
        return new DBUtilReadMins();
    }
}
