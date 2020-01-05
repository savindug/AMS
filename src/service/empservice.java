/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.Savindu.Controller.ServerController;
import com.Savindu.Entity.User;
import java.sql.Connection;
import com.Savindu.Util.DBConnection;
import com.Savindu.Util.ServerConnection;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.empmodel;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import util.DBConnect;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author Nuwanga
 */
public class empservice {
    
     private static Connection con;
     private PreparedStatement ps,ps1;
     
     
     public boolean validateuser(empmodel em){
         
        con = DBConnect.connect();
        boolean status = false;
        ResultSet rs;
        String un = null;
        String pw = null;
        try {           
            
            ps = con.prepareStatement("Select username,password from users where branchname = ?");
            ps.setString(1, em.getBranchname());
            rs = ps.executeQuery();
            
           
         
           
            while(rs.next()){
                un = rs.getString(1);
              
                pw = rs.getString(2);
            }
            
           
            if(un.equals(em.getUsername()) && pw.equals(em.getPassword())){
                status = true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(empservice.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
         
     }
     
     public boolean changepw(empmodel em){
         
        con = DBConnect.connect();
        boolean status = false;
        ResultSet rs;
        String un = null;
        String pw = null;
        try {           
            
            ps = con.prepareStatement("Select username,password from users where branchname = ?");
            ps.setString(1, em.getBranchname());
            rs = ps.executeQuery();
            
           
         
           
            while(rs.next()){
                un = rs.getString(1);
              
                pw = rs.getString(2);
            }
            
           
            if(un.equals(em.getUsername()) && pw.equals(em.getPassword())){
                
                ps1 = con.prepareStatement("update users set password = ? where branchname = ?");
                    ps1.setString(1,em.getNewpassword());
                    ps1.setString(2,em.getBranchname());
                    int row = ps1.executeUpdate();
                    
                    if(row != 0){
                        status = true;
                    }
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(empservice.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return status;
         
     }
     
     
     public boolean changeun(empmodel em){
         
        con = DBConnect.connect();
        boolean status = false;
        ResultSet rs;
        String un = null;
        String pw = null;
        try {           
            
            ps = con.prepareStatement("Select password from users where branchname = ?");
            ps.setString(1, em.getBranchname());
            rs = ps.executeQuery();
            
           
         
           
            while(rs.next()){
                pw = rs.getString(1);
              
            }
            
           
            if( pw.equals(em.getPassword())){
                
                ps1 = con.prepareStatement("update users set username = ? where branchname = ?");
                    ps1.setString(1,em.getNewusername());
                    ps1.setString(2,em.getBranchname());
                    int row = ps1.executeUpdate();
                    
                    if(row != 0){
                        status = true;
                    }
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(empservice.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return status;
         
     }
     
     
     public ResultSet viewemployees(empmodel em){
         
        con = DBConnect.connect();
       
        ResultSet rs = null;
        
        try {           
            
            ps = con.prepareStatement("Select userId, UserName, Gender, deptName, branchName from Employees where branchname = ? Order by userId");
            ps.setString(1, em.getSearchbranchname());
            rs = ps.executeQuery();
            
           
        } catch (SQLException ex) {
            Logger.getLogger(empservice.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return rs;
         
     }
     
     
     public ResultSet viewatt(empmodel em){
         
        con = DBConnect.connect();
       
        ResultSet rs = null;
        
        try {           
            
            ps = con.prepareStatement("Select DISTINCT a.userId, a.UserName, a.branchName, e.deptName, a.clock, a.remarks from \n"
                    + "Employees e, Attendance a \n"
                    + "where a.userId = e.userId and a.branchname = ? and a.clock like ? \n"
                    + "Order by a.clock");
            ps.setString(1, em.getSearchbranchname());
            ps.setString(2, em.getSearchyear().toString()+"-"+em.getSearchmonth().toString()+"%");
            rs = ps.executeQuery();
            
           
        } catch (SQLException ex) {
            Logger.getLogger(empservice.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return rs;
         
     }
     
     public ResultSet viewleave(empmodel em){
         
        con = DBConnect.connect();
       
        ResultSet rs = null;
        
        try {           
            
            ps = con.prepareStatement("Select DISTINCT l.userId, l.UserName, l.branchName, e.deptName, l.submittedDate, l.fromDtae ,l.toDate ,l.remarks \n"
                    + " from Employees e, Leaves l\n"
                    + "where l.userId = e.userId and l.branchname = ? and l.submittedDate like ? \n"
                    + "Order by l.submittedDate");
            ps.setString(1, em.getSearchbranchname());
            ps.setString(2, em.getSearchyear().toString()+"-"+em.getSearchmonth().toString()+"%");
            rs = ps.executeQuery();
            
           
        } catch (SQLException ex) {
            Logger.getLogger(empservice.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return rs;
         
     }
     
     
     public ResultSet viewot(empmodel em){
         
        con = DBConnect.connect();
       
        ResultSet rs = null;
        
        try {           
            
            ps = con.prepareStatement("Select DISTINCT o.userId, o.UserName, o.branchName, e.deptName, o.date, o.clockIn, o.clockOut ,o.otHours \n"
                    + " from Employees e, otTable o\n"
                    + "where o.userId = e.userId and o.branchname = ? and o.date like ? \n"
                    + "Order by o.date");
            ps.setString(1, em.getSearchbranchname());
            ps.setString(2, em.getSearchyear().toString()+"-"+em.getSearchmonth().toString()+"%");
            rs = ps.executeQuery();
            
           
        } catch (SQLException ex) {
            Logger.getLogger(empservice.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return rs;
         
     }
     
     public ResultSet viewfield(empmodel em){
         
        con = DBConnect.connect();
       
        ResultSet rs = null;
        
        try {           
            
            ps = con.prepareStatement("Select *  \n"
                    + " from FieldOfficers \n"
                    + "where  branch like ?");
                   
           
           ps.setString(1, em.getSearchbranchname());
            rs = ps.executeQuery();
            
           
        } catch (SQLException ex) {
            Logger.getLogger(empservice.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return rs;
         
     }
     
     public int maxemp(String Branchname){
         
        con = DBConnect.connect();
        ResultSet rs = null;
        int nxtsql = 0;
            try {
            ps = con.prepareStatement("SELECT max(userId) from Employees where branchName = ? ");
            ps.setString(1,Branchname);
            rs = ps.executeQuery();
            while(rs.next()){
                nxtsql = rs.getInt(1);
               
              
            }
            }catch(Exception e){                
                    
            } 
      
        return nxtsql;
         
     }
     
     public String maxa(String Branchname){
         
        con = DBConnect.connect();
        ResultSet rs = null;
        String nxtsql ="2015-12-10 16:15:54";
        DateTimeFormatter formatter = DateTimeFormat.forPattern("mm/dd/yyyy HH:mm:ss");
        
        
        
            try {
            ps = con.prepareStatement("SELECT max(clock) from Attendance where branchName = ? ");
            ps.setString(1,Branchname);
            rs = ps.executeQuery();
            while(rs.next()){
             
                
                
                nxtsql = rs.getString(1);
                
                
                
               
              
            }
            }catch(Exception e){                
                    
            } 
        
        if (nxtsql == null){
        nxtsql ="2015-12-10 16:15:54";    
        }        
            
        return nxtsql;
         
     }
     /*    */
      public String maxl(String Branchname){
         
        con = DBConnect.connect();
        ResultSet rs = null;
        String nxtsql ="2015-12-10 16:15:54";
        
            try {
            ps = con.prepareStatement("SELECT max(submittedDate) from Leaves where branchName = ? ");
            ps.setString(1,Branchname);
            rs = ps.executeQuery();
            while(rs.next()){
               
                nxtsql = rs.getString(1);
                
               
              
            }
            }catch(Exception e){                
                    
            } 
      
        if (nxtsql == null){
        nxtsql ="2015-12-10 16:15:54";    
        }    
            
            
        return nxtsql;
         
     }
     
      
       public String maxo(String Branchname){
         
        con = DBConnect.connect();
        ResultSet rs = null;
        String nxtsql ="2015-12-10 16:15:54";
            try {
            ps = con.prepareStatement("SELECT max(clockIn) from otTable where branchName = ? ");
            ps.setString(1,Branchname);
            rs = ps.executeQuery();
            while(rs.next()){
                
                nxtsql = rs.getString(1);
                
              
            }
            }catch(Exception e){                
                    
            } 
        if (nxtsql == null){
        nxtsql ="2015-12-10 16:15:54";    
        }        
        return nxtsql;
         
     }
      
     
     public ResultSet getemployees(){
        Connection connection = null;
        ResultSet rs = null;
        Statement st = null;
        
        String sql = "select distinct u.PIN, u.UserName, u.Sex, d.DeptName \n"
                + "from ras_Users u, ras_Dept d \n"
                + "where d.DeptId = u.DeptId";
            
            try{
                connection = DBConnection.openConnection();
                st = connection.createStatement();
                rs = st.executeQuery(sql);

                System.out.println("User id \tUsername \tGender \t\tCreateDate \t\t\tLastLoggedIn");
                System.out.println("_____________________________________________________________________________________________________");
                System.out.println("");
                

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }
       
        return rs;
        
    }
     
     public ResultSet getleave(){
       Connection connection = null;
        ResultSet rs = null;
        Statement st = null;
        
        String sql = "  select distinct usr.pin, usr.UserName, att.FromDate, att.ToDate, att.LastUpdatedDate, att.Remark  from \n" +
                     "  ras_AttLeaveRecord att\n" +
                     "  inner join ras_Users usr \n" +
                     "  on att.UID = usr.UID \n"+
                     "  order by usr.PIN";
            
            try{
                connection = DBConnection.openConnection();
                st = connection.createStatement();
                rs = st.executeQuery(sql);

                

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }
        
        return rs;
    }
     
     public ResultSet getOTList(){
       Connection connection = null;
        ResultSet rs = null;
        Statement st = null;
        
        String sql ="  SELECT usr.pin as Employee_ID, usr.UserName as User_Name, Min(clock) as Clock_In, Max(clock) as Clock_out, DATEDIFF(HOUR, MIN(clock), MAX(clock)) - 8 AS [OT/Late_Covering_Hrs], CAST(clock AS DATE) as Date\n" +
"                    FROM ras_AttRecord att, ras_Users usr, ras_AttTypeItem at\n" +
"                    where usr.din = att.din \n" +
"                    GROUP BY CAST(clock AS DATE), usr.pin, usr.UserName";
        
            
            try{
                connection = DBConnection.openConnection();
                st = connection.createStatement();
                rs = st.executeQuery(sql);

                

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }
        
        return rs;
    }
     
      public ResultSet getatt(){
       Connection connection = null;
        ResultSet rs = null;
         Statement st = null;
        
        
      String sql = " select distinct u.PIN, u.UserName, a.Clock, at.ItemName, a.Remark from \n" +
                    " ras_AttRecord a, ras_Dept d, ras_Users u, ras_AttTypeItem at\n" +
                    "where  u.UID = a.ID and a.AttTypeId = at.ItemId";                 
                     
            
            try{
                connection = DBConnection.openConnection();
                st = connection.createStatement();
                rs = st.executeQuery(sql);    

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }

            System.out.println(rs);
           
        return rs;
    }
      
       public ResultSet searchAttList(empmodel em){
       Connection connection = null;
        ResultSet rs = null;
        
        
        
      String sql = " select  distinct u.PIN, u.UserName, a.Clock, at.ItemName, a.Remark from \n" +
                    " ras_AttRecord a, ras_Dept d, ras_Users u, ras_AttTypeItem at\n" +
                    "where  u.UID = a.ID and a.AttTypeId = at.ItemId and CAST(a.Clock as date)  between ?"
                + "  and ? ";                 
                     
            
            try{
                connection = DBConnection.openConnection();
                ps = connection.prepareStatement(sql);
                ps.setString(1, em.getFromDate().toString());
                ps.setString(2, em.getToDate().toString());
                rs = ps.executeQuery();     

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }

            System.out.println(rs);
           
        return rs;
    }
       
        public ResultSet searchleave(empmodel em){
       Connection connection = null;
        ResultSet rs = null;
        Statement st = null;
        
        String sql = "select distinct  usr.pin, usr.UserName, att.FromDate, att.ToDate, att.LastUpdatedDate, att.Remark  from \n" +
"                     ras_AttLeaveRecord att\n" +
"                     inner join ras_Users usr \n" +
"                     on att.UID = usr.UID \n" +
"		      where att.LastUpdatedDate between  ? and ? \n" +
"                     order by usr.PIN";
            
            try{
                connection = DBConnection.openConnection();
                ps = connection.prepareStatement(sql);
                ps.setString(1, em.getFromDate().toString());
                ps.setString(2, em.getToDate().toString());
                rs = ps.executeQuery(); 

                

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }
        
        return rs;
    }
        
        public ResultSet searchOTList(empmodel em){
       Connection connection = null;
        ResultSet rs = null;
        Statement st = null;
        
        String sql = "  SELECT usr.pin as Employee_ID, usr.UserName as User_Name, Min(clock) as Clock_In, Max(clock) as Clock_out, DATEDIFF(HOUR, MIN(clock), MAX(clock)) - 8 AS [OT/Late_Covering_Hrs], CAST(clock AS DATE) as Date\n" +
"                    FROM ras_AttRecord att, ras_Users usr, ras_AttTypeItem at\n" +
"                    where usr.din = att.din CAST(clock AS DATE) between ? and ? \n" +
"                    GROUP BY CAST(clock AS DATE), usr.pin, usr.UserName";
        

            
            try{
                connection = DBConnection.openConnection();
                ps = connection.prepareStatement(sql);
                ps.setString(1, em.getFromDate().toString());
                ps.setString(2, em.getToDate().toString());
                rs = ps.executeQuery(); 

                

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }
        
        return rs;
    }
        
     public void viewFieldOfficers(int id){
         ResultSet myrs = null;
         int result = 0;
         con = DBConnect.connect();
         InputStream input = null;
         FileOutputStream output = null;
          
            
            String sql = "select file,Name from FieldOfficers where id = ?";
            
            
            
             try{
                con = ServerConnection.openConnection();
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                 preparedStatement.setInt(1, id);
                 
                 myrs = preparedStatement.executeQuery();
                 File thefile = new File("FieldReports\\"+id+"-report.pdf");
                 output = new FileOutputStream(thefile);
                 
                 if(myrs.next()){
                     input = myrs.getBinaryStream("file");
                     
                     byte[] buffer = new byte[1024];
                     while ( input.read(buffer)>0){
                         output.write(buffer);
                     }
                     
                 }
                 
                 
                 JOptionPane.showMessageDialog(null, "Report Saved");

            }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error");
                    Logger.getLogger(empservice.class.getName()).log(Level.SEVERE, null, e);
                }
             
             finally{
                 if(input != null){
                     try {
                         input.close();
                     } catch (IOException ex) {
                         Logger.getLogger(empservice.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
                 
                 
                 if(output != null){
                     try {
                         output.close();
                     } catch (IOException ex) {
                         Logger.getLogger(empservice.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
                 
                 
             }
                
    }   
        
        
        
}
