/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readinglog.app.init;

import java.sql.Connection;
import java.sql.DriverManager;
import rcommon.database.rsqlbase.RY_SQLConnectionFactory;
import rcommon.database.rsqlbase.RY_SQLConnectionSetting;

/**
 *
 * @author renhongxiang
 */
public class RMSQLConnectionMySQL extends RY_SQLConnectionFactory{

    public RMSQLConnectionMySQL(){
        RMMySQLConnectionSetting setting = new RMMySQLConnectionSetting();
        RMSQLConnectionMySQL.setSetting(setting);
    }
    
    
    @Override
    public synchronized Connection getConnection(){
        return getDBConnection();
    }
    
    public Connection getDBConnection(){
        RY_SQLConnectionSetting setting = RMSQLConnectionMySQL.getSetting();
        if(setting != null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = null;
                conn = DriverManager.getConnection(setting.getDbURL(), setting.getDbUserID(), setting.getDbPassword());
                return conn;
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.setErrorMessage("MySQL connection create failed");
        }
        return null;
    }    
    
}
