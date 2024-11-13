package com.example.jdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
        System.out.println( "Hello World!" );
        
        //Class.forName("Mysql connector/j");//that was used for driver registration 
        String url="jdbc:mysql://localhost:3306/test";//jdbc:mysql://localhost:3306/mydb4","root","Root");
        //url,username,password
        Connection con=null;
        try {
			con=DriverManager.getConnection(url, "root", "Root");
			System.out.println("Connected successfully....");
			//Statement stmt=con.createStatement();
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			//int i=stmt.executeUpdate("insert into course values(103,'Excel',1),(104,'MS-Office',2)");
			//int i=stmt.executeUpdate("update course set cname='Data Analysis' where cid=103" );
			//int i=stmt.executeUpdate("delete from course where cid>=102");
	
			//System.out.println(i+" records deleted");
			ResultSet rs=stmt.executeQuery("Select * from course");
			System.out.println("Cid\t Name\t  Duration");
			while(rs.next())
			{
		       System.out.println(rs.getInt("cid")+"\t"+rs.getString("cname")+"\t"+rs.getInt("duration"));
			   //System.out.println("Cname :"+);
			   //System.out.println("Duration :"+rs.getInt("duration"));
			   System.out.println("--------------------------------------------------------------");
			}
			rs.previous();
			System.out.println(rs.getInt("cid")+"\t"+rs.getString("cname")+"\t"+rs.getInt("duration"));
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
        finally {
        	con.close();
        }
    }
}
