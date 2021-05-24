package com.cognizant.truyum.dao;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {
	public static Connection getConnection()
	{
		Connection con = null;
	    try
	    {
	    	Properties props = new Properties();
	    	props.load(new FileInputStream("C:\\Users\\Ajay\\eclipse-workspace\\truYum\\src\\connection.properties"));
	   	
	    	con = DriverManager.getConnection(props.getProperty("connection-url"),props.getProperty("user"),props.getProperty("password"));
	    	if(con!=null) 
	    	{
	    		System.out.println("connected to database");
	    		
	    	}
	    	
	    }
	    catch (SQLException e) 
	    {
	    	System.out.println("Not connected to the database");
		
		} catch (IOException e) 
	    {
			System.out.println("Connection Properties file not found");
		}
	    return con;
	}

	public static void main(String[] args) {
		ConnectionHandler.getConnection();
	}
}


