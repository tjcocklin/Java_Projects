package com.almita.models;

public  class SecureLogin {

	
	
	public static String hash(String pwd)
	{
		 return pwd+"withsalt";
	}
}
