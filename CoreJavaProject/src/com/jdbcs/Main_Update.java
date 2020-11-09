package com.jdbcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main_Update {

	public static void main(String[] args) {
		updateByPrepare(1002, "Manager");
	}
	
public static void updateByPrepare(int id, String desg) {
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "system";
		String pass = "root";
		
		String sql = "UPDATE EMPLOYEE SET EMP_DESG = ? WHERE ID= ?";  // ? is a place holder
		
	
				//STEP 1
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");  //load JDBC driver with specific database
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} 
				
				//Step 2 
				Connection con=null;
				PreparedStatement stmt=null;
				try {
					con = DriverManager.getConnection(url, user, pass);
					
					stmt = con.prepareStatement(sql);
					
					stmt.setString(1, desg);					
					stmt.setInt(2, id);
	
					stmt.executeUpdate();   // first insert
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					try {
						stmt.close();
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
						
				}		
				
				System.out.println("update record successfully...");
	
	}
}
