package com.almita.models;

import java.util.HashMap;

public class Participant
{
    
	private int customerID; 
    private String activityName;



	public  HashMap<String,String> activityList;
   

	public Participant()
	{
    	this.customerID= -1;
    	this.activityName ="blankName";
    }


	public Participant(int customerID, String activityName)
	{
		super();
		this.customerID = customerID;
		this.activityName = activityName;
	}


	public int getCustomerID() 
	{
		return customerID;
	}


	public void setCustomerID(int customerID) 
	{
		this.customerID = customerID;
	}


	public String getActivityName() 
	{
		return activityName;
	}


	public void setActivityName(String activityName)
	{

		this.activityName = activityName;
	}
    
	
	
    
}
