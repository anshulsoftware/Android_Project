package com.jdbcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main_Insert {

	public static void main(String[] args) throws Exception{
	
		insert(1002, "Kael", "Developer");
	}
	
	public static void insert(int id, String name, String desg) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "system";
		String pass = "root";
		
		String sql = "insert into employee values('"+id+"','"+name+"','"+desg+"')";
		
		String sql2 = "insert into employee values(1003,'Paul', 'Developer')";
		
		//STEP 1
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");  //load JDBC driver with specific database
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} 
				
				//Step 2 
				Connection con=null;
				Statement stmt=null;
				try {
					con = DriverManager.getConnection(url, user, pass);
					
					stmt = con.createStatement();
					
					stmt.executeUpdate(sql);
					
					stmt.executeUpdate(sql2);
					
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
