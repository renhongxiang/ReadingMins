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
}
