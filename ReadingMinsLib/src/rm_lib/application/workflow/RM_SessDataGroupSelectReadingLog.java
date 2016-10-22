/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.application.workflow;

import java.util.List;
import rcommon.algorithm.datastructure.RArrayMap;
import rcommon.rdata.iosystem.DataIOIdentity;
import rm_lib.data.RM_ReadingMins;
import rm_lib.sess.RM_SessDataGroup;

/**
 *
 * @author renhongxiang
 */
public class RM_SessDataGroupSelectReadingLog extends RM_SessDataGroup{
    
    private RArrayMap<Long, RM_ReadingMins> selectMinsMap = null;
    
    
    public RArrayMap<Long, RM_ReadingMins> getMinsMap(){
        if(selectMinsMap == null){
            selectMinsMap = new RArrayMap<Long, RM_ReadingMins>();
        }
        return selectMinsMap;
    }
    
    public boolean addReadingLog(Long key, RM_ReadingMins mins){
        RArrayMap<Long, RM_ReadingMins> map = getMinsMap();
        if(map != null){
            map.putItem(key, mins);
            return true;
        }
        return false;
    }
    
    public boolean addReadingLog(RM_ReadingMins mins){
        return this.addReadingLog(this.getMinsID(mins), mins);
    }
    
    private Long getMinsID(RM_ReadingMins mins){
        if(mins != null){
            DataIOIdentity ioID = mins.getMinsIOID();
            if(ioID != null && ioID.isValueValid()){
                return ioID.getIndentifyID();
            }
        }
        return null;
    }
    
    public List<RM_ReadingMins> getReadingMinsList(){
        RArrayMap<Long, RM_ReadingMins> map = getMinsMap();
        if(map != null){
            return map.getData();
        }
        return null;
    }
}
