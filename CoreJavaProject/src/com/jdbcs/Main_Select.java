package com.jdbcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main_Select {

	public static void main(String[] args) {

		//selectByPrep(1004);
		selectByPrep();
	}

	public static void selectByPrep(int id) {

		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "system";
		String pass = "root";

		String sql = "select * from employee where id=?"; // ? is a place holder

		// STEP 1
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // load JDBC driver with specific database
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Step 2
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet set =null;
		try {
			con = DriverManager.getConnection(url, user, pass);

			stmt = con.prepareStatement(sql);

			stmt.setInt(1, id);
		
		    set = stmt.executeQuery();
		   
		    while(set.next()) {
		    	
		    	String name_ = set.getString("EMP_NAME");
		    	String desg = set.getString("EMP_DESG");
		    	
		    	System.out.println("Employee Name is "+ name_);
		    	System.out.println("Employee Designation is "+desg);
		    }
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		System.out.println("fetch record successfully...");

	}

	
	public static void selectByPrep() {

		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "system";
		String pass = "root";

		String sql = "select * from employee "; // ? is a place holder

		// STEP 1
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // load JDBC driver with specific database
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Step 2
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet set =null;
		try {
			con = DriverManager.getConnection(url, user, pass);

			stmt = con.prepareStatement(sql);

		    set = stmt.executeQuery();
		   
		    while(set.next()) {
		    	int id = set.getInt("ID");
		    	String name_ = set.getString("EMP_NAME");
		    	String desg = set.getString("EMP_DESG");
		    	
		    	System.out.println("Employee Id is "+id);
		    	System.out.println("Employee Name is "+ name_);
		    	System.out.println("Employee Designation is "+desg);
		    	System.out.println();
		    }
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		System.out.println("fetch record successfully...");

	}
}
