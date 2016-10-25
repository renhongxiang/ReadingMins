/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.studentlevel.monthdetail;

import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author renhongxiang
 */

public class ReadingLogMonthBean {

    private List<ReadingLogBean> readLogList = null;

    public List<ReadingLogBean> getReadLogList() {
        return readLogList;
    }

    public void setReadLogList(List<ReadingLogBean> readLogList) {
        this.readLogList = readLogList;
    }
    
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date date;
    
    private String title;
    
    private int mins;
    
    private int shortMins = 0;
    
    private int totalMins = 0;
    
    private String month = null;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public int getTotalMins() {
        return totalMins;
    }

    public void setTotalMins(int totalMins) {
        this.totalMins = totalMins;
    }
    
    public int getMoreMins(){
        return -shortMins;
    }
    
    public int getShortMins() {
        return shortMins;
    }

    public void setShortMins(int shortMins) {
        this.shortMins = shortMins;
    }
    
    public boolean isShort(){
        if(shortMins > 0){
            return true;
        }
        return false;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
    
    
}
