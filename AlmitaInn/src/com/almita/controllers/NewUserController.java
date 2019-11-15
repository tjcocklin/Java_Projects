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
			.getRequestDispatcher(url);
		}
		else 
		{
		   //put data into customer table and get cust_ID for the other tables
			createCustomerEntry();
			retrieveCustID();
		  // put data into user table and contact table
			insertUser();
			insertContact();
		 // go to success page 
			
			url="/Views/AccountCreated.jsp";
			getServletContext()
			.getRequestDispatcher(url);
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
	    
		String query = "SELECT EXISTS (SELECT email from user_table WHERE email ="+email+ ") res FROM user_table";
		
		con.queryDB(query);
		
		try 
		{
			con.getResult().next();
			res= con.getResult().getInt("res");
		    
			con.close();
			return (res == 1)? true: false;
			
		}
		catch (SQLException e) 
		{
			System.out.println("from emailIsDup: "+e.getMessage());
		    con.close();
		    return true;
		}
		
					
	}
    private void createCustomerEntry() 
    {
    	DefaultUserConnection con = new DefaultUserConnection();
    	String query= "INSERT INTO customer(F_Name,L_Name) Values("+fName+lName+")";
    	
    	con.queryDB(query);
    	con.close();
    	   	
    	
    }
    
    private void retrieveCustID() 
    {
    	DefaultUserConnection con = new DefaultUserConnection();
    	String query = "SELECT"+
    			         "cust_ID FROM customer"+
    			       "WHERE"+
    			         "F_name ="+fName+
    			          "AND"+
    			         "L_Name ="+lName+";";
    	
    	
    	con.queryDB(query);
    	con.getResult();
    	
    	try 
		{
			con.getResult().next();
			cust_ID= con.getResult().getInt("cust_ID");
		    
			con.close();
			
			
		}
    	catch(SQLException e)
    	{
    		System.out.println("from retrieve cust_ID: "+e.getMessage());
		    con.close();
    	}
    	
    }
    
    private void insertUser() 
    {

    	DefaultUserConnection con = new DefaultUserConnection();
    	String query= "INSERT INTO user_table (email,pwd,cust_ID)"+
    			                   "Values("+email+pwd+cust_ID+");";
    	
    	con.queryDB(query);
    	con.close();
    }
    
    private void insertContact()
    {
    	DefaultUserConnection con = new DefaultUserConnection();
    	String query= "INSERT INTO contact(cust_ID, phone, street, city, state)"+
    			                   "Values("+cust_ID+phone+street+city+state+");";
    	
    	con.queryDB(query);
    	con.close();
    }

}
