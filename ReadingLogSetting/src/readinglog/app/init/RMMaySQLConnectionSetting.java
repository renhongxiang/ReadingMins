/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readinglog.app.init;

import rcommon.database.rsqlbase.RY_SQLConnectionSetting;

/**
 *
 * @author renhongxiang
 */
public class RMMaySQLConnectionSetting implements RY_SQLConnectionSetting{

    @Override
    public String getDbURL() {
        return "jdbc:mysql://localhost:3306/readinglogtest";
    }

    @Override
    public String getDbUserID() {
        return "DBEdit";
    }

    @Override
    public String getDbPassword() {
        return "123456";
    }    

}
