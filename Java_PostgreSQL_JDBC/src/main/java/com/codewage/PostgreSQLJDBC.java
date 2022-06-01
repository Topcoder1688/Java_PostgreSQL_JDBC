package com.codewage;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgreSQLJDBC {
	public static void main(String args[]) {
		Connection c = null;
		try {
			// Load the PostgreSQL Driver
			Class.forName("org.postgresql.Driver");
			
			//Create a new Postgresql Connection using Host, Port, Database Name, Username and Password
			c = DriverManager.getConnection("jdbc:postgresql://1.1.1.1:5432/testdb","postgres", "sdcsdc");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened database successfully");
	}
}