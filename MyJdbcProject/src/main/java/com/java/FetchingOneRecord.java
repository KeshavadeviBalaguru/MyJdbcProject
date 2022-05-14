package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class FetchingOneRecord {

	public static void main(String[] args) {
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/edu_chen";
		String un="root";
		String pa="root";
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the fetching userpassword:");
		 int userpassword=sc.nextInt();	
		 System.out.println("Username\tUserpasssword");
		 try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,un,pa);
			st=conn.createStatement();
			String sql="select * from loginid where userpassword="+userpassword;
			rs=st.executeQuery(sql);
			if(rs.next())
			{
				System.out.println(rs.getString("username")+" "+rs.getInt("userpassword"));
			}
			else
			{
				System.out.println("Record is not fund..");
			}
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 
		
	
	}

}
