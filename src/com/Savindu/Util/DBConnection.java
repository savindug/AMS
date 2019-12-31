/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Savindu.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import view.AppInterface;

/**
 *
 * @author Savindu
 */
public class DBConnection {
       
	private static final String URL = "jdbc:sqlserver://localhost:50042;DatabaseName=RIMS_Attendance";
	
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	private static final String USERNAME = "sa";
	
	private static final String PASSWORD = "check123";
	
	public static Connection connection = null;
	

public static Connection openConnection() {

//checking for the connection---------------------------


	if(connection != null) {

		return connection;
	
	}else {
		
		try {
			
			Class.forName(DRIVER);
                        
			connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                        
                        if(connection != null) {
                            System.out.println("Successfully Connected to the Database!");

                        }
	
		}catch(ClassNotFoundException e){
			
			e.printStackTrace();
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}

		return connection;
	}
}


}
