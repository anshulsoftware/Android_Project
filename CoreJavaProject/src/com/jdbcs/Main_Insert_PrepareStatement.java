package com.jdbcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Main_Insert_PrepareStatement {

	
	public static void main(String[] args) {
	insertByPrepare(1001, "Anshul", "Developer");	
	}
	
	
	public static void insertByPrepare(int id, String name, String desg) {
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "system";
		String pass = "root";
		
		String sql = "insert into employee values(?,?,?)";  // ? is a place holder
		
	
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
					
					stmt.setInt(1, id);
					stmt.setString(2, name);
					stmt.setString(3, desg);
					
					stmt.executeUpdate();   // first insert
					
					stmt.setInt(1, 1003);
					stmt.setString(2, "Paul");
					stmt.setString(3, "Developer");
					
					stmt.executeUpdate();  // second insert
					
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
				
				System.out.println("insert record successfully...");
	
	}
	
	
	
}
