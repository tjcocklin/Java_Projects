package com.almita.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.almita.models.UserConnection;

class UserConnectionTest {
    
	UserConnection myConnection;
	
   
  
    @BeforeEach
	void init() {
		myConnection = new UserConnection();
		
	}
	
    @DisplayName("Test Query")
	@Test
	void testQueryDB() {
		String query = "SHOW TABLES;";
		myConnection.queryDB(query);
		
		ResultSet res = myConnection.getResult();
		assertNotNull(res,"query should not return null");
	}
    
    
}
