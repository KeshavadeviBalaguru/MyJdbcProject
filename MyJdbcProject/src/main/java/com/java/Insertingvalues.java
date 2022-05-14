package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Insertingvalues {

	public static void main(String[] args) {
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/student_database";
		String un="root";
		String pa="root";
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id to insert");
		int id=sc.nextInt();
		String sql="select * from login where id="+id;
		try
		{
			Class.forName(driver);
			conn=DriverManager.getConnection(url, un, pa);
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			if(!rs.next())
			{    
				System.out.println("Enter the name");
				String name=sc.next();
				String ins="insert into login values("+id+",'"+name+"')";
				int i=st.executeUpdate(ins);
			
			if(i>0)
			{
				System.out.println("Record inserted successfully");
			}
			}
			else
			{
				System.out.println("Record already exist");
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
