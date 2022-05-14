package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UpdatingRecord {

	public static void main(String[] args) {
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/edu_chen";
		String un="root";
		String pa="root";
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter userpassword for update");
		int userpassword=sc.nextInt();
		try
		{
			Class.forName(driver);
			conn =DriverManager.getConnection(url, un, pa);
			st=conn.createStatement();
			String sql="select * from loginid where userpassword="+userpassword;
			rs=st.executeQuery(sql);
			if(rs.next())
			{
				System.out.println("enter the name to update");
			    String username=sc.next();
				String upd="update loginid set username='"+username+"' where userpassword=" +userpassword;
				int i=st.executeUpdate(upd);
				if(i>0) {
					System.out.println("Record is updating");
				}
			}
			else
			{
				System.out.println("Record not exist");
			}
			

	}catch(Exception e) {
		e.printStackTrace();
		
	}

}
}
