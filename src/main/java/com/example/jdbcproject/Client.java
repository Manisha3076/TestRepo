package com.example.jdbcproject;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

import jdk.internal.org.objectweb.asm.Type;

public class Client {

	public static void main(String[] args)throws Exception {
		String url="jdbc:mysql://localhost:3306/test";
		Connection con=null;
		try {
	    con=DriverManager.getConnection(url,"root","Root");
		con.setAutoCommit(false);
		Statement stmt=con.createStatement();
		
		stmt.addBatch("update course set duration=2 where duration=3");
		stmt.addBatch("delete from course where cname='Full Stack'");
		stmt.addBatch("Insert into course values(207,'Java',4)");
		 stmt.executeBatch();
		 con.commit();
		 System.out.println("Batch executed successfully...");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			con.rollback();
			System.out.println("Rolled back...");
			con.close();
			
		}

	}

}
