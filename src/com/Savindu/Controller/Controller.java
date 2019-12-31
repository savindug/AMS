/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Savindu.Controller;
import com.Savindu.Entity.Attendance;
import com.Savindu.Entity.User;
import com.Savindu.Util.DBConnection;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
/**
 *
 * @author Savindu
 */
public class Controller {

       
    public ArrayList<User> userList(){
        
        ArrayList<User> userList = new ArrayList<>();
        
        Connection connection = null;
        ResultSet rs = null;
        Statement st = null;
        User user;
        
        //sql query
        String sql = "select u.PIN, u.UserName, u.Sex, d.DeptName \n"
                + "from ras_Users u, ras_Dept d \n"
                + "where d.DeptId = u.DeptId";
            
            try{
                connection = DBConnection.openConnection();
                st = connection.createStatement();
                rs = st.executeQuery(sql);

                System.out.println("User id \tUsername \tGender \t\tCreateDate \t\t\tLastLoggedIn");
                System.out.println("_____________________________________________________________________________________________________");
                System.out.println("");
                while(rs.next()){
                    user = new User();
                    user.setuID(rs.getString(1));
                    user.setuName(rs.getString(2));
                    user.setGender(rs.getString(3));
                    user.setUserdepart(rs.getString(4));
                    
                    userList.add(user);
                    

                }

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }

        return userList;
    }
    
     public ArrayList<Attendance> getattL(){
       Connection connection = null;
        ResultSet rs = null;
        Statement st = null;
       Attendance att;
        ArrayList<Attendance> attL = new ArrayList<>();
        
        String sql = "  select u.PIN, u.UserName, a.Clock, at.ItemName, a.Remark from \n" +
"                    ras_AttRecord a, ras_Dept d, ras_Users u, ras_AttTypeItem at\n" +
"                     where  u.UID = a.ID and a.AttTypeId = at.ItemId";
                     //"  order by usr.PIN";
//                     
                     //String sql = "select * from ras_AttRecord group by pin";
            
            try{
                connection = DBConnection.openConnection();
                st = connection.createStatement();
                rs = st.executeQuery(sql);     
                
                while(rs.next()){
                    att = new Attendance();
                    att.setuId(rs.getString(1));
                    att.setuName(rs.getString(2));
                   
                    att.setAttTime(rs.getString(3));
                    att.setRemark(rs.getString(4));
                    attL.add(att);
                    //System.out.println(user.getuID()+"\t\t"+user.getuName()+"\t\t"+user.getGender()+"\t\t"+user.getCreateDate()+"\t\t"+user.getLastLoggedIn());

                }
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }

            System.out.println(rs);
        return attL;
    }
     
     
        public ArrayList<User> leaveList(){
        
        ArrayList<User> leaveList = new ArrayList<>();
        
        Connection connection = null;
        ResultSet rs = null;
        Statement st = null;
        User leave;
        
        //sql query
        String sql = "  select usr.pin, usr.UserName, att.FromDate, att.ToDate, att.LastUpdatedDate, att.Remark  from \n" +
                     "  ras_AttLeaveRecord att\n" +
                     "  inner join ras_Users usr \n" +
                     "  on att.UID = usr.UID \n"+
                     "  order by usr.PIN";
        
            
            try{
                connection = DBConnection.openConnection();
                st = connection.createStatement();
                rs = st.executeQuery(sql);

                System.out.println("User id \tUsername \tFromDate \t\tToDate \t\t\tLeaveSubmitted \t\tRemark");
                System.out.println("_____________________________________________________________________________________________________");
                System.out.println("");
                while(rs.next()){
                    leave = new User();
                    leave.setuID(rs.getString(1));
                    leave.setuName(rs.getString(2));
                    leave.setLeaveStart(rs.getString(3));
                    leave.setLeaveEnd(rs.getString(4));
                    leave.setLeaveSubmitted(rs.getString(5));
                    leave.setLeaveRemark(rs.getString(6));
                    leaveList.add(leave);
                    System.out.println(leave.getuID()+"\t\t"+leave.getuName()+"\t\t"+leave.getLeaveStart()+"\t\t"+leave.getLeaveEnd()+"\t\t"+leave.getLeaveSubmitted()+"\t\t"+leave.getLeaveRemark());

                }

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }

        return leaveList;
    }
    
//        public void createOTList(){
//          
//        String create_table = "IF NOT EXISTS\n" +
//                                "   (  SELECT *\n" +
//                                "      FROM sys.tables\n" +
//                                "      WHERE [name] = 'otList'\n" +
//                                "   )\n" +
//                                "   CREATE TABLE otList (\n" +
//                                "  id int NOT NULL,\n" +
//                                "  userId int NOT NULL,\n" +
//                                "  userName varchar NOT NULL,\n" +
//                                "  department varchar NOT NULL,\n" +
//                                "  clock datetime NOT NULL,\n" +
//                                "  trgdate datetime NOT NULL\n" +
//                                "  )";
//        Connection connection = null;
//        ResultSet rs = null;
//        Statement st = null;
//        
//        try{
//                connection = DBConnection.openConnection();
//                st = connection.createStatement();
//                st.executeUpdate(create_table);     
//                
//            }catch(Exception e){
//                JOptionPane.showMessageDialog(null, e);
//                e.printStackTrace();
//            }
//        
//     }
            
         public ArrayList<Attendance> getOTList(){
       Connection connection = null;
        ResultSet rs = null;
        Statement st = null;
         Attendance ot;
        ArrayList<Attendance> otL = new ArrayList<>();
        
        String sql ="SELECT att.din, usr.UserName , MAX(clock) as Clock_In, MIN(clock) as Clock_out, DATEDIFF(HOUR, MIN(clock), MAX(clock)) AS Othours, CAST(clock AS DATE) as DateField\n" +
                    "FROM ras_AttRecord att, ras_Users usr\n" +
                    "where usr.din = att.din \n" +
                    "GROUP BY CAST(clock AS DATE), att.din, usr.UserName";
        
            
            try{
                connection = DBConnection.openConnection();
                st = connection.createStatement();
                rs = st.executeQuery(sql);

                while(rs.next()){
                    ot = new Attendance();
                    ot.setuId(rs.getString(1));
                    ot.setuName(rs.getString(2));
                    ot.setClockIn(rs.getString(3));
                    ot.setClockOut(rs.getString(4));
                    ot.setOtHrs(rs.getInt(5));
                    ot.setDate(rs.getString(6));
                    otL.add(ot);
                    
                }

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }
        
        return otL;
    }
 
         public void exportTable(JTable table, File file) throws IOException {
            TableModel model = table.getModel();
            FileWriter out = new FileWriter(file);
            for(int i=0; i < model.getColumnCount(); i++) {
        out.write(model.getColumnName(i) + "\t");
            }
            out.write("\n");

            for(int i=0; i< model.getRowCount(); i++) {
        for(int j=0; j < model.getColumnCount(); j++) {
            out.write(model.getValueAt(i,j).toString()+"\t");
            }
            out.write("\n");
        }

        out.close();
        System.out.println("write out to: " + file);
}

}

