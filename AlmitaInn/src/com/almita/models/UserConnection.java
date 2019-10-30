package com.almita.models;

import java.sql.*;

public class UserConnection {

	
	

	public final String url = "jdbc:mysql://127.0.0.1/almita_Inn";
  
	
    public Connection Con;
    public Statement statement;
    public ResultSet results;
	
    
	
    public UserConnection() 
    {
    	
    }
    
    // Constructor opens connection to almitaInn 
    public UserConnection(String user, String pwd) 
	{
		try 
		{
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  this.Con= DriverManager.getConnection(url,user,pwd);
		  this.statement= this.Con.createStatement();
	
	 	} catch(Exception e) {
	 		System.out.println("Initialization failed "+e.getMessage());
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
	       catch (Exception e)
	       {
			 System.out.println("MY QUERY ERRORED: "+e.getMessage());
		   } 
	     
	     
    }
    
    public ResultSet getResult() 
    {
       return this.results;
    }
    

	
}
