package com.almita.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.almita.models.DefaultUserConnection;

/**
 * Servlet implementation class NewUserController
 */
@WebServlet("/NewUserController")
public class NewUserController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
	private String fName;
    private String lName;
	
	private String phone;
    
	private String street;
    private String city;
    private String state;
    
    private String email;
    private String pwd;
   
	private int cust_ID;
	private String apos="\'";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String url;
		getParameters(request);
		
		
		//ToDo test if email address is not a duplicate.	
		if(emailIsDuplicate())
		{
		   //goto error page
			url ="/Views/NewUserErrorPage.jsp";
			getServletContext()
			.getRequestDispatcher(url)
			.forward(request, response);
		}
		else 
		{
		   //get next customers id and user Data and insert them into their tables.
			getNextCustID();
			insertUser();
		  
			// put data into customer table and contact table
			createCustomer();
			insertContact();
		    // go to success page 
			
			url="/Views/AccountCreated.jsp";
			 getServletContext()
			.getRequestDispatcher(url)
			.forward(request, response);
		}
	}
    
	private void getParameters(HttpServletRequest request) 
	{
		 fName = request.getParameter("Fname");
	     lName= request.getParameter("Lname");
		
		 phone= request.getParameter("phone");
	    
		 street= request.getParameter("street");
	     city= request.getParameter("city");
	     state= request.getParameter("state");
	     
	     email= request.getParameter("email");
	     pwd=request.getParameter("pwd");
	     
	     
	}
	private boolean emailIsDuplicate() 
	{ 
	    
		int res;
		
			
	    DefaultUserConnection con = new DefaultUserConnection();
	    
	    
		String query = "SELECT "+
	                       "COUNT(email) "+
				        "FROM "+
	                       "user_table "+ 
				        "WHERE "+
	                       "email ="+apos+email+apos+";";
		
		System.out.println(query);
		
		con.queryDB(query);
		
		try 
		{
			
			con.getResults().next();
			res= con.getResult().getInt("COUNT(email)");
		    
		    
			con.close();
			return (res >= 1)? true: false;
			
		}
		catch (SQLException e) 
		{
			System.out.println("from emailIsDup: "+e.getMessage());
		    con.close();
		    return true;
		}
		
					
	}
    private void createCustomer() 
    {
    	DefaultUserConnection con = new DefaultUserConnection();
    	
    	String cmd= "INSERT INTO customer(F_Name,L_Name,cust_ID)"
    			+ " Values("+apos+fName+apos+','+apos+lName+apos+','+apos+cust_ID+apos+")";
    	
    	System.out.println(cmd);
    	con.updateDB(cmd);
    	con.close();
    	   	
    	
    }
    
    private void getNextCustID() 
    {
    	DefaultUserConnection con = new DefaultUserConnection();
    	String query = "SELECT COUNT(cust_ID) as res FROM customer";
    	
    	con.queryDB(query);
    	con.getResult();
    	
    	try 
		{
			con.getResult().next();
			cust_ID= con.getResult().getInt("res");
		    
			con.close();
		    System.out.println(cust_ID);	
			
		    cust_ID++;
		    
		}
    	catch(SQLException e)
    	{
    		System.out.println("from getNext cust_ID: "+e.getMessage());
		    con.close();
    	}
    	
    }
    
    private void insertUser() 
    {

    	DefaultUserConnection con = new DefaultUserConnection();
    	String cmd= "INSERT INTO user_table (email,pwd,cust_ID)"+
    			                   "Values("+apos+email+apos+','+apos+pwd+apos+','+cust_ID+");";
    	
    	System.out.println(cmd);
    	con.updateDB(cmd);
    	con.close();
    }
    
    private void insertContact()
    {
    	DefaultUserConnection con = new DefaultUserConnection();
    	String cmd= "INSERT INTO contact(cust_ID, phone, street, city, state)"+
    			                   "Values("+cust_ID+','+apos+phone+apos+','+apos+street+apos+
    			                   ','+apos+city+apos+','+apos+state+apos+");";
    	
    	System.out.println(cmd);
    	con.updateDB(cmd);
    	con.close();
    }

}
