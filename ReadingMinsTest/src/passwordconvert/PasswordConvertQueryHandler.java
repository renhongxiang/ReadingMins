/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordconvert;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import rcommon.database.rsqlbase.RY_OprSimple;
import rcommon.database.rsqlbase.RY_SQLQueryHandler;
import rcommon.encrypt.password.REncryptPwd;

/**
 *
 * @author renhongxiang
 */
public class PasswordConvertQueryHandler extends RY_SQLQueryHandler{
    
    REncryptPwd passwordEncryptor = new REncryptPwd();

    @Override
    public void queryProcessRowDataProcess(ResultSet result, int row, int[] typeList, int width, ResultSetMetaData metaData) throws Exception{
        if(result != null){
            Long id = result.getLong("ID");
            String password = result.getString("Password");
            String encryptedPassword = passwordEncryptor.encryptPassword(password);
            
            PasswordQuerySQL sql = new PasswordQuerySQL();
            sql.setId(id);
            sql.setNewPassword(encryptedPassword);
            RY_OprSimple.DoUpdate(sql);
        }
    }    
    
}
