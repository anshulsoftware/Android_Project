package com.jdbcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main_Create {

	public static void main(String[] args) throws Exception {
		create();

	}

	public static void create() {

		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "system";
		String pass = "root";
		String sql = "CREATE TABLE EMPLOYEE (ID NUMBER(10) NOT NULL, EMP_NAME VARCHAR2(50), EMP_DESG VARCHAR2(50))";

		// STEP 1
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 

		// Step 2
		Connection con = null;
		Statement stmt = null;
		try {
			con = DriverManager.getConnection(url, user, pass);

			stmt = con.createStatement();

			stmt.executeUpdate(sql);
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

		System.out.println("Table created successfully...");
	}

}
