package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Testjdbc {

	public static void main(String[] args) {

		String jdbcurl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user="hbstudent";
		String pass="123456";
		try {
			System.out.println("connection to mysql");
			
			Connection conn=DriverManager.getConnection(jdbcurl, user, pass);
			
			System.out.println("connection success");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
