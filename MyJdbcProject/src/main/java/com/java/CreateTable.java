package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) {
		String mytable="create table cloudem(cid int(4) primary key, cname varchar(20) not null)";
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/employee";
		String un="root";
		String pa="root";
		try
		{
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url, un, pa);
			Statement st=conn.createStatement();
			st.execute(mytable);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
