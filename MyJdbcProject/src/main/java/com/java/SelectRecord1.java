package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectRecord1 {

	public static void main(String[] args) {
		//Connection 
				String driver="com.mysql.cj.jdbc.Driver";
				String url="jdbc:mysql://localhost:3306/edu_chen"; //edudb is the database name of mysql
				String un="root";
				String pass="root";
				Connection conn=null;
				Statement st=null;
				ResultSet rs=null;
				try {
					Class.forName(driver);
					conn = DriverManager.getConnection(url,un,pass);
					st=conn.createStatement();
					
					String sql="select * from student";
					rs=st.executeQuery(sql);
					System.out.println("STUDENTNAME\tSTUDENTID\t\tSTUDENTEMAIL");
					while(rs.next()) {
						String n=rs.getString(1);
						int id=rs.getInt(2);
						String e=rs.getString(3);
						System.out.println(n+"\t\t "+id+"\t\t "+e);
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
					
			

	}

}
