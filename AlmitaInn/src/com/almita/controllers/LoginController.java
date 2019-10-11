package com.almita.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.almita.models.Room;

import java.sql.*;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String url = "/Views/DisplayUserPage.jsp";
//		String email = request.getParameter("e-mail");
//		String passWord = request.getParameter("password");
//		
//		Room custRoom;
				
//		PrintWriter out = response.getWriter();
//		out.println("Made it to login controller");
		
		
		//custRoom= getUserRoom(email,passWord);// it may be null
//		
//		Customer newCustomer = new Customer(fName,lName,phone);

//		request.setAttribute("newCustomer", newCustomer);
		 
//		request.setAttribute("custRoom", custRoom);
//		getServletContext()
//		.getRequestDispatcher(url)
//		.forward(request, response);
		
		String url = "/Views/DisplayUserPage.jsp";
		
		getServletContext()
		.getRequestDispatcher(url)
		.forward(request, response);
		
		
	}
	
	
	
	
    
//	protected Room getUserRoom(String email,String pass ) {
//		
//        Connection myConnection;
//		Room toReturn= null;
//		try {
//			
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		    
//			String url = "jdbc:mysql://127.0.0.1/almita_Inn";
//		    String user= email; 
//		    String pwd=pass; 
//		    
//		    myConnection = DriverManager.getConnection(url,user,pwd);
//		    Statement s = myConnection.createStatement();
//		   
//		    String apos="\'";
//		    String sPass=pwd+"withsalt";
//		    
//		    String queryRoom = "SELECT "+
//		    		             "room_ID, description, price "+
//		    		            "FROM "+
//		    		             "room "+
//		    		            "WHERE "+
//		    		             "room.cust_ID = "+
//		    		               "(select cust_ID FROM pwd_table WHERE pwd_table.pwd="+apos+sPass+apos+");";
//		    
//		    
//		   // System.out.println(queryRoom);
//		    ResultSet queryResults;
//		    
//		   	    
//		    queryResults=s.executeQuery(queryRoom);
//		     
//		    Room custRoom= new Room();
//		    
//		    
//		    while(queryResults.next()) {
//		    	
//		    	//custRoom.setCustomerID(queryResults.getInt("cust_ID"));
//		    	custRoom.setDescription(queryResults.getString("description"));
//		    	
//		    	custRoom.setRoomID(queryResults.getInt("room_ID"));
//		    	custRoom.setPrice(queryResults.getDouble("price"));
//		    }
//		
//		
//		    return custRoom;
//		}
//		catch(ClassNotFoundException e) {
//			System.out.println("my 1 "+e.getMessage());
//			return toReturn;
//		}
//		catch(SQLException e) {
//			System.out.println("my 2 "+e.getMessage());
//		    return toReturn;
//		}
//		
//		
//	}
	
	
}//end of class
