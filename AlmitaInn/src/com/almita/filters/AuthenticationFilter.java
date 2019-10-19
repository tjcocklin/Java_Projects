package com.almita.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.almita.models.SecureLogin;
import com.almita.models.UserConnection;
/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/LoginController")
public class AuthenticationFilter implements Filter {

	UserConnection user;
	
    /**
     * Default constructor. 
     */
    public AuthenticationFilter()
    {
        user= new UserConnection();
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy()
	{
		// TODO Auto-generated method stub
		user.close();
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		     //get params from login.jsp
		     
		     String email = request.getParameter("e-mail");
		     String pwd = request.getParameter("password");
		
		
		     // hash the pwd
		     pwd= SecureLogin.hash(pwd);
		     
		     // authenticate
		     int result= authenticate(email,pwd);
		     
		     if(result == 1)
		     {
		    	 chain.doFilter(request, response);
		     }
		     else 
		     {
		    	String url = "/Views/LoginErrorPage.jsp";
		 		
		    	request.getRequestDispatcher(url)
		 		.forward(request,response);
		     }
		     
		     
				
	}

	
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException
	{
		// TODO Auto-generated method stub
		
		//System.out.println("Entering the authentication filter");
	}

		
	
	
	private int authenticate(String email, String saltedPwd) 
	{
		int toReturn = -1;
		
		try 
		{
			String apos= "\'";
			
			email =apos+email+apos;
			saltedPwd= apos+saltedPwd+apos;
						
			
			String query= "SELECT Count(*) "+
			              "FROM "+
					          "user_table "+
			               "WHERE "+
					           "email = "+email+
			                   "AND "+
					           "pwd = "+saltedPwd+";";
					      
			
			this.user.queryDB(query);

			
			this.user.getResult().next();
			
			    toReturn = user.getResult().getInt("Count(*)");	
			
			
						
			
		} 
		catch (SQLException e)
		{
		    System.out.println("ERROR FROM FILTER "+e.getMessage());	
		    return toReturn;
		}
	
		return toReturn;
	}
	
	
	
}
