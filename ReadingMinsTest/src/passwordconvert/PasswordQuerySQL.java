/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordconvert;

import java.sql.PreparedStatement;
import rcommon.database.rsqlbase.RY_SQLBase;
import rytable.common.RY_UserTB;

/**
 *
 * @author renhongxiang
 */
public class PasswordQuerySQL extends RY_SQLBase{
    
    @Override
    protected String GetQueryString(){
        RY_UserTB table = RY_UserTB.createInstance();
        String tableName = table.getTableQueryName();
        return "Select * from " + tableName;
    }
    
    private Long id = null;
    private String newPassword = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
    
    @Override
    protected String GetUpdateString(){
        RY_UserTB table = RY_UserTB.createInstance();
        String tableName = table.getTableQueryName();
        String queryStr = "Update " + tableName + " set Password = ? where id = ?";
        return queryStr;
    }
    
    
    @Override
    protected boolean buildUpdateStatement(PreparedStatement stmt)throws Exception{
        if(stmt != null){
            Long id = this.getId();
            String newPwd = this.getNewPassword();
            if(id != null && newPwd != null){
                stmt.setString(1, newPwd);
                stmt.setLong(2, id);
                return true;
            }
        }
        return false;
    }
    
    
}
