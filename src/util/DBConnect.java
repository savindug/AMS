/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author it18100280
 */
public class DBConnect {
    
    private static Connection conn;
    
    public static Connection connect(){
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/kYYREuLXgx", "kYYREuLXgx", "Ivw9uq1gro");
            System.out.println("Database Connected!");
            DriverManager.setLoginTimeout(1200);
            /*conn = DriverManager.getConnection("jdbc:mysql://johnny.heliohost.org:3306/nwsb_att_sys", "nwsb", "nw2251997");
            System.out.println("Database Connected!");*/
             
           
                    
                    } catch (SQLException ex) {
           
        }
    
        return conn;
    }
    
}
