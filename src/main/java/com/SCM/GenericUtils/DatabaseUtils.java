package com.SCM.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtils {

	Connection con = null;
	public void connectDB() throws Throwable
	{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IPathConstant.DBURL,IPathConstant.DB_Username, IPathConstant.DB_Password);
	}
	public String executeAndGetData(int colData,String ExpData, String query) throws Throwable
	{
		Statement state = con.createStatement();
		//String query = "select* from employee;"; // chnge the query as per your database
		ResultSet result = state.executeQuery(query);
		boolean flag = false;
		while(result.next())
		{
			String actual = result.getString(colData);
			
			if(actual.equalsIgnoreCase(ExpData))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("Project created succesfully");
			return ExpData;
		}
		else
		{
			System.out.println("Project is not created");
			return "";
		}
		
		
	}
	
	public void disconnectDB() throws Throwable 
	{
		con.close();
	}
}
