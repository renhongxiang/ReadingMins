/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.controller.student;

import rm_lib.data.RM_Student;

/**
 *
 * @author renhongxiang
 */
public class StudentBean {
    
    private String firstName;
    private String lastName;
    private String studentID;
    private int dailyMins = 0;
    private int orderID = 0;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getDailyMins() {
        return dailyMins;
    }

    public void setDailyMins(int dailyMins) {
        this.dailyMins = dailyMins;
    }


    public static void fillStudentInfoFromBean(RM_Student student, StudentBean bean){
        if(student != null && bean != null){
            student.setFirstName(bean.getFirstName());
            student.setLastName(bean.getLastName());
            student.setStudentCode(bean.getStudentID());
            student.setDailyRequestReadingMins(bean.getDailyMins());
        }
    }
    
    public static void fileBeanWithStudentInfo(StudentBean bean, RM_Student student){
        if(student != null && bean != null){
            bean.setFirstName(student.getFirstName());
            bean.setLastName(student.getLastName());
            bean.setStudentID(student.getStudentCode());
            bean.setDailyMins(student.getDailyRequestReadingMins());
        }
    }
}
