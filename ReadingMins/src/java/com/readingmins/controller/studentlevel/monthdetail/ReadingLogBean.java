/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.studentlevel.monthdetail;

import rcommon.rdata.iosystem.DataIOIdentity;

/**
 *
 * @author renhongxiang
 */
public class ReadingLogBean {
    private int day = 0;
    private String title = null;
    private int mins = 0;
    private long id = 0;
//    private DataIOIdentity ioID = null;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMins() {
        return mins;
    }

    public void setMins(int mins) {
        this.mins = mins;
    }

    public long getId() {
        return this.id;
//        DataIOIdentity ioID = this.getIoID();
//        if(ioID != null){
//            return ioID.getIndentifyID();
//        }
//        return 0;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public DataIOIdentity getIoID() {
//        return ioID;
//    }
//
//    public void setIoID(DataIOIdentity ioID) {
//        this.ioID = ioID;
//    }
    
    
}
