package com.codewage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class CRUD_PostgreSQL_JDBC_Delete {
	public static void main( String args[] ) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://1.1.1.1:5432/testdb","postgres", "askjcnsa");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "DELETE from codewage where EmployeeID = 2;";
			stmt.executeUpdate(sql);
			c.commit();

			ResultSet rs = stmt.executeQuery( "SELECT * FROM codewage;" );
			while ( rs.next() ) {
				int EmployeeID = rs.getInt("EmployeeID");
				String  name = rs.getString("Name");
				String role  = rs.getString("Role");
				String  location = rs.getString("Location");
				float salary = rs.getFloat("Salary");
				System.out.println( "Employee ID = " + EmployeeID );
				System.out.println( "NAME = " + name );
				System.out.println( "ROLE = " + role );
				System.out.println( "LOCATION = " + location );
				System.out.println( "SALARY = " + salary );
				System.out.println();
			}
			rs.close();
			stmt.close();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
		System.out.println("Record Deleted Successfully");
	}
}