/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.data;

import rcommon.rdata.common.RY_DataBase;
import rcommon.rdata.common.RY_IODataGroupBase;
import rcommon.rdata.iosystem.DataIOHandleBase;
import rcommon.rdata.iosystem.DataIOIdentity;
import rcommon.rdata.structure.RY_IODataObjectBase;

/**
 *
 * @author renhongxiang
 */
public class RM_StudentIODataGroup extends RY_IODataGroupBase{

    public RM_StudentIODataGroup(RY_DataBase data) {
        super(data);
    }

    @Override
    protected boolean setDataToIOData(DataIOHandleBase ioHandle, boolean loadOnly) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean setIODataToData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RY_IODataObjectBase createIOData() {
        return new RM_StudentIOData();
    }

    @Override
    protected DataIOIdentity getInheritanceIOID(DataIOHandleBase saveHandle, boolean loadOnly) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
