package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DbConnect {

	public static void main(String[] args) {
		int id;
		String name;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name: ");
		name=sc.next();
		
		System.out.println("Enter the id: ");
		id=sc.nextInt();
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/student_database";
		String un="root";
		String pa="root";
		
		try
		{
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url, un, pa);
			Statement st=conn.createStatement();
			String ins="insert into login values("+id+",'"+name+"')";
			int i=st.executeUpdate(ins);
			if(i>0)
			{
				System.out.println("Record Inserted");
			}
			else
				System.out.println("Record NotInserted");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
             
	}

}
