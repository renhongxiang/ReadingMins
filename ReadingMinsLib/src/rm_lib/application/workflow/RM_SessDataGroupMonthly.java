/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.application.workflow;

import java.util.List;
import rcommon.data.session.RSessionDataPackage;
import rcommon.rdata.dataformat.RMonth;
import rm_lib.data.RM_ReadingMins;

/**
 *
 * @author renhongxiang
 */
public class RM_SessDataGroupMonthly extends RM_SessDataGroupStudentBase{
    
    private RMonth curMonth = null;

    public RMonth getCurMonth() {
        return curMonth;
    }

    public void setCurMonth(RMonth curMonth) {
        this.curMonth = curMonth;
    }
    
    List<RM_ReadingMins> monthReclist = null;

    public List<RM_ReadingMins> getMonthReclist() {
        return monthReclist;
    }

    public void setMonthReclist(List<RM_ReadingMins> monthReclist) {
        this.monthReclist = monthReclist;
    }
    
    @Override
    protected boolean copyPackageDataFrom(RSessionDataPackage curPackage){
        if(super.copyPackageDataFrom(curPackage)){
            if(curPackage instanceof RM_SessDataGroupMonthly){
                RM_SessDataGroupMonthly fromPackage = (RM_SessDataGroupMonthly)curPackage;
                this.setCurMonth(fromPackage.getCurMonth());
                this.setMonthReclist(fromPackage.getMonthReclist());
            }
            return true;
        }
        return false;
    }
    
}
