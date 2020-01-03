/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Savindu.Util;

import static com.Savindu.Util.DBConnection.openConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Savindu
 */
public class ServerConnection {
    
        
	private static final String URL = "jdbc:mysql://remotemysql.com:3306/kYYREuLXgx";
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	private static final String USERNAME = "kYYREuLXgx";
	
	private static final String PASSWORD = "Ivw9uq1gro";
	
    public static Connection connection = null;
    
    /*private static final String URL = "jdbc:mysql://johnny.heliohost.org:3306/nwsb_att_sys";
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	private static final String USERNAME = "nwsb";
	
	private static final String PASSWORD = "nw2251997";
	
    public static Connection connection = null;*/
	
	

public static Connection openConnection() {

//checking for the connection---------------------------


	if(connection != null) {

		return connection;
	
	}else {
		
		try {
			
			Class.forName(DRIVER);
                        DriverManager.setLoginTimeout(1200);
			connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                        
                        if(connection != null) {
                            System.out.println("Successfully Connected to the Server!");

                        }
	
		}catch(ClassNotFoundException e){
			
			e.printStackTrace();
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}

		return connection;
	}
}
    public static void main(String args[]) {
      openConnection();
    }
}
