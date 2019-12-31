/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Savindu.Entity;

/**
 *
 * @author Savindu
 */
public class User {
    private String uName;
    private String uID;
    private String gender;
    private String createDate;
    private String lastLoggedIn;
    private String leaveStart;
    private String leaveEnd;
    private String leaveSubmitted;
    private String leaveRemark;
    private String userdepart;
    
    public User() {
       
    }

    public String getUserdepart() {
        return userdepart;
    }

    public void setUserdepart(String userdepart) {
        this.userdepart = userdepart;
    }
    
    public void setuName(String uName) {
        this.uName = uName;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }

    public void setGender(String gender) {
        if(gender.equals("M")){
            this.gender = "Male";
        }else{
            this.gender = "Female";
        }
        
    }
    
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public void setLastLoggedIn(String lastLoggedIn) {
        this.lastLoggedIn = lastLoggedIn;
    }

    public String getuName() {
        return uName;
    }

    public String getuID() {
        return uID;
    }

    public String getGender() {
        return gender;
    }
    
    public String getCreateDate() {
        return createDate;
    }

    public String getLastLoggedIn() {
        return lastLoggedIn;
    }

    public String getLeaveStart() {
        return leaveStart;
    }

    public String getLeaveEnd() {
        return leaveEnd;
    }

    public String getLeaveSubmitted() {
        return leaveSubmitted;
    }

    public String getLeaveRemark() {
        return leaveRemark;
    }

    public void setLeaveStart(String leaveStart) {
        this.leaveStart = leaveStart;
    }

    public void setLeaveEnd(String leaveEnd) {
        this.leaveEnd = leaveEnd;
    }

    public void setLeaveSubmitted(String leaveSubmitted) {
        this.leaveSubmitted = leaveSubmitted;
    }

    public void setLeaveRemark(String leaveRemark) {
        this.leaveRemark = leaveRemark;
    }
    
    
}
