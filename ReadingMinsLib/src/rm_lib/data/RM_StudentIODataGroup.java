/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.data;

import rcommon.rdata.common.base.RY_DataBase;
import rcommon.rdata.iosystem.DataIOHandleBase;
import rcommon.rdata.iosystem.DataIOIdentity;
import rcommon.rdata.structure.RY_IODataGroupBase;
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
    public RY_IODataObjectBase createIOData() {
        return new RM_StudentIOData();
    }

   
}
