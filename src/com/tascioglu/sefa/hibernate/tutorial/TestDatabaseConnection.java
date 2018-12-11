package com.tascioglu.sefa.hibernate.tutorial;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TestDatabaseConnection {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String password = "hbstudent";
		
		try {
			String query = "from student";
			Connection con = DriverManager.getConnection(jdbcUrl, user, password);
			String resQuery = con.nativeSQL(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
