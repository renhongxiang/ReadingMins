/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readinglog.app.init;

import java.sql.Connection;
import java.sql.DriverManager;
import rcommon.app.setting.RAppSetting;
import rcommon.database.rsqlbase.RY_SQLConnectionFactory;

/**
 *
 * @author renhongxiang
 */
public class RMSQLConnectionMySQL extends RY_SQLConnectionFactory{

    public RMSQLConnectionMySQL(){
        prepareData();
    }
    
    private void prepareData(){
        boolean develop = true;
        RAppSetting setting = RAppSetting.getAppSetting();
        if(setting != null){
            develop = setting.isDebug();
        }
        if(develop){
            this.setDbURL("jdbc:mysql://localhost:3306/readinglogtest");
            this.setDbUserID("DBEdit");
            this.setDbPassword("123456");
        }else{
            this.setDbURL("jdbc:mysql://localhost:3306/readmins");
            this.setDbUserID("DBEdit");
            this.setDbPassword("123456");
        }
    }
    
    @Override
    public synchronized Connection getConnection(){
        return getDBConnection();
    }
    
    public Connection getDBConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            conn = DriverManager.getConnection(this.getDbURL(), this.getDbUserID(), this.getDbPassword());
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setErrorMessage("MySQL connection create failed");
        return null;
    }    
    
}
