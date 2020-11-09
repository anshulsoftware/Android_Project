package com.jdbcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main_Delete {

	public static void main(String[] args) {
		deleteByPrepare(1002);
		
	}

	public static void deleteByPrepare(int id) {

		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "system";
		String pass = "root";

		String sql = "DELETE FROM EMPLOYEE WHERE ID= ? "; // ? is a place holder

		// STEP 1
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // load JDBC driver with specific database
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Step 2
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DriverManager.getConnection(url, user, pass);

			stmt = con.prepareStatement(sql);

			stmt.setInt(1, id);

			stmt.executeUpdate(); 

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

		System.out.println("deleted record successfully...");

	}
}
