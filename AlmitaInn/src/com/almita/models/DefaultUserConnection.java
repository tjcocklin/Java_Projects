package com.almita.models;
import java.sql.*;
public class DefaultUserConnection extends UserConnection 
{
	 
	private static final String user= "default"; 
	private static final String pwd= "pass"; 
     
	 
	 public DefaultUserConnection()
	 {
	    super(user,pwd);	 
	 }
    
	 public void close() 
	 {
	    super.close();	 
	 }
     
	 public void queryDB(String query) 
	 {
	    super.queryDB(query);	 
	 }

     public ResultSet getResults ()
     {
    	 return super.getResult();
     }
}
