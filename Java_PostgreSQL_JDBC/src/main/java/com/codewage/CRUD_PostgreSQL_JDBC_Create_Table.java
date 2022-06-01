package com.codewage;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class CRUD_PostgreSQL_JDBC_Create_Table {
	public static void main( String args[] ) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://1.1.1.1:5432/testdb","postgres", "xyzzzzz");
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "CREATE TABLE codewage " +
					"(EmployeeID INT PRIMARY KEY     NOT NULL," +
					" Name           TEXT    NOT NULL, " +
					" Role            TEXT     NOT NULL, " +
					" Location        TEXT, " +
					" Salary       REAL)";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
		System.out.println("Table created successfully");
	}
}
