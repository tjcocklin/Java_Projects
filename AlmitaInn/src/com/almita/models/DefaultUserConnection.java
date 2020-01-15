package com.almita.models;
import java.sql.*;
public class DefaultUserConnection extends UserConnection 
{
	 
	private static final String user= "default"; 
	private static final String pwd= "pass"; 
    
	private Statement update;
	 
	 public DefaultUserConnection()
	 {
	    super(user,pwd);
	    
	    try 
	    {
			this.update = super.Con.createStatement();
		} 
	    catch (SQLException e)
	    {
			System.out.println(e.getMessage());
		}
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
     
     public int updateDB(String cmd) 
     {
    	 int result=0;
    	     	     	 
    	 try 
    	 {
			result= this.update.executeUpdate(cmd);
		 } 
    	 catch (SQLException e) 
    	 {
			System.out.println(e.getMessage());
		 }
         return result;
     }
     
}
