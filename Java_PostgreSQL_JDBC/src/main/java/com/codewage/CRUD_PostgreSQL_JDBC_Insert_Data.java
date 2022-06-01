package com.codewage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CRUD_PostgreSQL_JDBC_Insert_Data {
   public static void main(String args[]) {
      Connection c = null;
      Statement stmt = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager.getConnection("jdbc:postgresql://1.1.1.1:5432/testdb","postgres", "ascscsc");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "INSERT INTO codewage (EmployeeID,Name,Role,Location,Salary) "
            + "VALUES (1, 'Deepika', 'Founder & CEO', 'Bangalore', 1000000.00 );";
         stmt.executeUpdate(sql);

         sql = "INSERT INTO codewage (EmployeeID,Name,Role,Location,Salary) "
            + "VALUES (2, 'Rob', 'CTO', 'Texas', 15000.00 );";
         stmt.executeUpdate(sql);

         sql = "INSERT INTO codewage (EmployeeID,Name,Role,Location,Salary) "
            + "VALUES (3, 'Carl', 'Developer', 'Norway', 20000.00 );";
         stmt.executeUpdate(sql);

         sql = "INSERT INTO codewage (EmployeeID,Name,Role,Location,Salary) "
            + "VALUES (4, 'Jeena', 'HR', 'Rich-Mond ', 65000.00 );";
         stmt.executeUpdate(sql);

         stmt.close();
         c.commit();
         c.close();
      } catch (Exception e) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
      System.out.println("Records created successfully");
   }
}