/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Nuwanga
 */
public class empmodel {

   
    
    private String branchname;
    private String username;
    private String password;    
    private String newpassword;
    private String newusername;
    private String searchbranchname;
    private String searchyear;
    private String searchmonth;
    private String fromDate;
    private String toDate;

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }
    
 
     public empmodel() {
    }
    
    public empmodel(String branchname, String username, String password, String newpassword, String newusername, String searchbranchname, String searchyear, String searchmonth) {
        this.branchname = branchname;
        this.username = username;
        this.password = password;
        this.newpassword = newpassword;
        this.newusername = newusername;
        this.searchbranchname = searchbranchname;
        this.searchmonth= searchmonth;
        this.searchyear = searchyear;
    }
    
    public String getSearchbranchname() {
        return searchbranchname;
    }

    public void setSearchbranchname(String searchbranchname) {
        this.searchbranchname = searchbranchname;
    }

    public String getSearchyear() {
        return searchyear;
    }

    public void setSearchyear(String searchyear) {
        this.searchyear = searchyear;
    }

    public String getSearchmonth() {
        return searchmonth;
    }

    public void setSearchmonth(String searchmonth) {
        this.searchmonth = searchmonth;
    }
    
    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }
    
    public String getNewusername() {
        return newusername;
    }

    public void setNewusername(String newusername) {
        this.newusername = newusername;
    }
     public String getBranchname() {
        return branchname;
    }

    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
