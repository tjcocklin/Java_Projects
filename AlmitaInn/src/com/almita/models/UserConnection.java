package com.almita.models;

import java.sql.*;

public class UserConnection {

	
	

	private final String url = "jdbc:mysql://127.0.0.1/almita_Inn";
    private final String user= "default"; 
    private final String pwd= "pass"; 
	
    private Connection Con;
    private Statement statement;
    private ResultSet results;
	
    
	// Constructor opens default connection to almitaInn for users (nonAdmin)

	public UserConnection() 
	{
		try 
		{
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  this.Con= DriverManager.getConnection(url,user,pwd);
		  this.statement= this.Con.createStatement();
	
	 	} catch(Exception e) {
	 		System.out.println(e.getMessage());
	 	}
	}

	public void close()
	{
		
		try 
		{
			this.Con.close();
		} 
		catch (SQLException e)
		{
		  System.out.println(e.getMessage());
		}
	}

    public void queryDB(String query) 
    {
	       this.results= null;
	       
	       try 
	       {
			 this.results= this.statement.executeQuery(query);
			 
		   } 
	       catch (SQLException e)
	       {
			 System.out.println("MY QUERY ERRORED: "+e.getMessage());
		   } 
	     
	     
    }
    
    public ResultSet getResult() 
    {
       return this.results;
    }
    

	
}
