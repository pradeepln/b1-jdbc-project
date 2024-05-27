package com.ibm.training.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/ibm_b1", "root", "secret");
	}

	public static void main(String[] args) {
		try {
			Connection c = getConnection();
			System.out.println(c);
			DatabaseMetaData meta = c.getMetaData();
			System.out.println("Name: "+meta.getDatabaseProductName());
			System.out.println("Version: "+meta.getDatabaseProductVersion());
			
		} catch (Exception e) {
			System.out.println("Error connecting to DB");
			e.printStackTrace();
		}

	}

}
