/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Savindu.Dao;

import java.sql.*;
import  com.Savindu.Util.DBConnection;
/**
 *
 * @author Savindu
 */
public class DBHanddler {
    
    Connection connection = null;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement preparedStatement = null;
    
        
    public void displayUsers(){
        
            String sql = "select * from ras_Users";
            
        try{
            connection = DBConnection.openConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            System.out.println("id \t"+"name \t createDate \t");
            while(rs.next()){
                String id = rs.getString(1);
                String name = rs.getString(4);
                String createDate = rs.getString(11);
                  
                  System.out.println(id+"\t"+name+"\t"+createDate+"\t");
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
