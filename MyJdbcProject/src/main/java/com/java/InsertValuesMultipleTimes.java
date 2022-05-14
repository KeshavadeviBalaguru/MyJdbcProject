package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InsertValuesMultipleTimes {

	public static void main(String[] args) {
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/edu_chen";
		String un="root";
		String pa="root";
		Connection conn=null;
		Statement st=null;
		String ins=null;
		String username;
		int userpassword;
		Scanner sc=new Scanner(System.in);
		try
		{
			Class.forName(driver);
		    conn=DriverManager.getConnection(url, un, pa);
		    st=conn.createStatement();
		    while(true)
		    {
		   
		    System.out.println("Enter the username: ");
		    username=sc.next();
		 
		    System.out.println("Enter the password");
		    userpassword=sc.nextInt();
		    ins="insert into loginid values('"+username+"',"+userpassword+")";
		    int i=st.executeUpdate(ins);
		    if(i>0)
		    {
		    	System.out.println("Record inserted successfully");
		    	
		    }
		    else
		    {
		    	System.out.println("Record not inserted");
		    	
		    }
		    System.out.println("Do you want to continue y/n");
		    char ch=sc.next().charAt(0);
		    if(ch=='n')
		    {
		    	break;
		    }
		    }
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("Program Ended.....");
	}

}
