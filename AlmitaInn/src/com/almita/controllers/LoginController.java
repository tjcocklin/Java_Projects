package com.almita.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.almita.models.Participant;
import com.almita.models.Room;
import com.almita.models.SecureLogin;

import java.sql.*;
import com.almita.models.UserConnection;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		String url = "/Views/DisplayUserPage.jsp";
		String email = request.getParameter("e-mail");
						
		
		String custRoom = getUserRoom(email);
		String custActs = getActivities(email);
		String custPurchases = getPurchases(email);
		String custName = getUserName(email);
		
		
		request.setAttribute("custRoom", custRoom);
		request.setAttribute("custActs", custActs);
		request.setAttribute("custPurchases", custPurchases);
		request.setAttribute("custName", custName);
		
		getServletContext()
		.getRequestDispatcher(url)
		.forward(request, response);
		
		
	}
	
	//
	//
	protected String getUserRoom(String email )
	{
		String toReturn = "blank";
		
		UserConnection user = new UserConnection();
		
			
		String apos="\'";
		String query= "SELECT "+
	             		"room_ID, description, price "+
	             	  "FROM "+
	                     "room "+
	                   "WHERE "+
	                       "room.cust_ID = "+
	                        "(select cust_ID FROM user_table WHERE email="+apos+email+apos+");";
		
		
		user.queryDB(query);
		
		try 
		{
			  toReturn="";
			  
			  String roomID, price, description;
			  
			  while(user.getResult().next())
			  {
				
				  roomID= ""+user.getResult().getInt("room_ID");
				  description= user.getResult().getString("description");
				  price = String.format("$%1.2f",user.getResult().getDouble("Price"));
				  
				  toReturn+="<tr><td>"+roomID+"</td>"+"<td>"+description+"</td>"+
				            "<td>"+price+"</td></tr>";
			  }
		 
		
			 return toReturn;
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return toReturn;
		}
		finally 
		{
		   user.close();	
		}
				
	}
	
	//
	//
    protected String getActivities(String email) 
    {
    	String toReturn="blank";
    	UserConnection user = new UserConnection();
		
		
		String apos="\'";
		String subquery ="(SELECT cust_ID FROM user_table WHERE email ="+apos+email+apos+")";
		String query="SELECT "+
				       "activities.activity_name, description "+ 
				     "FROM "+
				       "activities, participants, user_table " + 
				     "WHERE " + 
				        "user_table.cust_ID ="+subquery+" "+
				         "AND "+
				         "participants.customer_ID ="+subquery+" "+
				         "AND "+
				         "participants.activity_name = activities.activity_name; ";
				
    	user.queryDB(query);
    	try 
		{
    		String name, description;
    		
    		toReturn="";
    		
    		
    		while(user.getResult().next()) 
			{ 
			   name = user.getResult().getString("activity_name");
			   description = user.getResult().getString("description");
			   
			   toReturn+="<tr><td class= \"ActTable\">"+name+"</td>"+"<td class= \"ActTable\">"+description+"</td></tr>";
			}
			
						
			return toReturn;
		}
		
    	catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return toReturn;
		}
		finally 
		{
		   user.close();	
		}
    	
    	
    }
  	
    //
    //
    protected String getPurchases(String email) 
    {
        String toReturn = "blank";
		
		UserConnection user = new UserConnection();
		
			
		String apos="\'";
		String query= "SELECT "+
	             		"name, price, receipt_number "+
	             	  "FROM "+
	                     "purchase, item "+
	                   "WHERE "+
	                       "customer_ID = "+
	                         "(select cust_ID FROM user_table WHERE email="+apos+email+apos+")"+
	                       "AND "+
	                         "purchase.item_ID = item.item_ID;";
		
		
		user.queryDB(query);
		
		try 
		{
			
			String item, price, receiptNo;
			
		   
			toReturn="";
	       
		
			while(user.getResult().next()) 
			{
			     item = user.getResult().getString("name");
			     price = String.format("$%1.2f",user.getResult().getDouble("price"));
			     receiptNo = ""+ user.getResult().getInt("receipt_number");
				
				 toReturn+="<tr><td>"+receiptNo+"</td>"+"<td>"+item+"</td>"+
						 "<td>"+price+"</td><tr>";

			}
			
			return toReturn;
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return toReturn;
		}
		finally 
		{
		   user.close();	
		}
    }
	
    //
    //
    protected String getUserName(String email)
    {
    	String toReturn = "blank";
		
		UserConnection user = new UserConnection();
		
			
		String apos="\'";
		String query= "SELECT "+
	             		"F_name "+
	             	  "FROM "+
	                     "customer "+
	                   "WHERE "+
	                       "customer.cust_ID = "+
	                        "(select cust_ID FROM user_table WHERE email="+apos+email+apos+");";
		
		
		user.queryDB(query);
		
		try 
		{
			  		 
			  
			  user.getResult().next();
			  				
			  toReturn = user.getResult().getString("F_name");
			    		 
		
			 return toReturn;
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return toReturn;
		}
		finally 
		{
		   user.close();	
		}	
    }

	
	
}//end of class
