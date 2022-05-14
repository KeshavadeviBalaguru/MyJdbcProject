package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DeletingRecord {

	public static void main(String[] args) {
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/Student_database";
		String un="root";
		String pa="root";
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the  deleting id");
		int id=sc.nextInt();
		try
		{
			Class.forName(driver);
			conn =DriverManager.getConnection(url, un, pa);
			st=conn.createStatement();
			String sql="select * from login where id="+id;
			rs=st.executeQuery(sql);
			if(rs.next())
			{
				String del="delete from login where id="+id;
				int i=st.executeUpdate(del);
				if(i>0) {
					System.out.println("Record is deleted");
				}
			}
			else
			{
				System.out.println("Record not exist");
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
				

	}

}
