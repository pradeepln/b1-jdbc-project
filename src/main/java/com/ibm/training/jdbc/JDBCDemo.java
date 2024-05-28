package com.ibm.training.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) {
		//useRawJdbcInsert();
		useRawJdbcSelect();

	}

	private static void useRawJdbcSelect() {
		try(Connection c = DBUtil.getConnection()) {
			
			Statement s = c.createStatement();
			String sql = "select * from product";
			ResultSet rs = s.executeQuery(sql);
			//can i close connection here?
			ResultSetMetaData rMeta = rs.getMetaData();
			int columnCount = rMeta.getColumnCount();
			for(int i = 1; i <= columnCount; i++) {
				System.out.print(rMeta.getColumnName(i)+"\t\t");
			}
			System.out.println("\n--------------------------------------------------------------------------------------");
			
			while(rs.next()) {
				for(int i = 1; i <= columnCount; i++) {
					System.out.print(rs.getString(i)+"\t\t\t");
				}
				System.out.println("");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	private static void useRawJdbcInsert() {
		
		try (Connection c = DBUtil.getConnection()) {
			String inserSQL = "insert into product(product_name,product_price,product_qoh) values ('name3',3000,10)"; 
			Statement s = c.createStatement();
			int numRows = s.executeUpdate(inserSQL);
			System.out.println("Inserted "+numRows+" row(s)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
