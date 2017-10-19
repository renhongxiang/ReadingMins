/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.application.init;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import rcommon.database.rsqlbase.RPooledConnectionPool;
import rcommon.rdata.iosys.db.DBConnectionSupport;
import rcommon.rdata.iosystem.DataIOHandleBase;
import rm_lib.dataio.utils.RMDataIOUtilManager;

/**
 *
 * @author renhongxiang
 */
public class RM_DataIOHandle extends DataIOHandleBase implements DBConnectionSupport{
    
    private Connection conn = null;    
    private RMDataIOUtilManager rmDataIOManager = null;
    
    @Override
    public Connection getConnection() {
        if(conn == null){
            conn = this.createConnection();
        }
        return conn;
    }
    
    
    public Connection createConnection() {
        return RPooledConnectionPool.getPooledConnection();        
//        RY_SQLConnectionFactory fact = RY_SQLConnectionFactory.getFactory();
//        if(fact != null){
//            Connection conn = fact.getConnection();
//            if(conn != null){
//                try {
//                    conn.setAutoCommit(false);
//                } catch (SQLException ex) {
//                    Logger.getLogger(RM_DataIOHandle.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                return conn;
//            }
//        }
//        return null;
    }

    @Override
    public boolean release(Connection conn) {
        return RPooledConnectionPool.releasePooledConnection(conn);
//        if(conn != null){
//            RY_SQLConnectionFactory fact = RY_SQLConnectionFactory.getFactory();
//            if(fact != null){
//                fact.releaseConnection(conn);
//                return true;
//            }
//            return false;
//        }
//        return true;
    }
    
    @Override
    protected void rollbackOperation(){
        Connection conn = this.getConnection();
        if(conn != null){
            try {
                conn.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(RM_DataIOHandle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        super.rollbackOperation();
    }
    
    @Override
    protected boolean commitOperation(){
        Connection conn = this.getConnection();
        if(conn != null){
            try {
                if(!conn.getAutoCommit()){
                    conn.commit();
                }
                super.commitOperation();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(RM_DataIOHandle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    
    @Override
    public boolean release(){
        if(conn != null){
            this.release(conn);
            conn = null;
        }        
        return true;
    }

    public RMDataIOUtilManager getRmDataIOManager() {
        return rmDataIOManager;
    }

    public void setRmDataIOManager(RMDataIOUtilManager rmDataIOManager) {
        this.rmDataIOManager = rmDataIOManager;
    }
    
    
}
