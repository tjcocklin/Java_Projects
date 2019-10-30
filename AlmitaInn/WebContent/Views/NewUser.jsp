<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome new User</title>
<link rel="stylesheet" href="/AlmitaInn/StyleSheets/NewUserStyleSheet.css" type="text/css">
</head>
<body>

  <div class="header">
     <h1>New User Sign In</h1>
 </div>

  <div class= "container">
    <div id="formContainer">
        <form id= "userInput"action="">
	        <div id="name">
		        <h3>Name</h3>
		        First Name:
		        <input type="text" name=Fname ><br>
		        Last Name:
		        <input type="text" name=Lname ><br>
	        </div>
	        <div id="contact">
	        	<h3>Contact</h3>
	             Phone number:
	            <input type="tel" name=phone id=phone><br>  
	        </div>
	        <div id="address">
	        	<h3>Address</h3>
	        	Street:
	            <input type="text" name=street id=street><br> 
	        	City:
	            <input type="text" name=city id=city><br> 
	            State:
	            <input type="text" name=state id=state><br> 
	        </div>
	        <div id="login">
		        <h3>Login</h3>
		        e-mail:
		        <input type="email" name=email id=email ><br>
		        password:
		        <input type="text" name=pwd id=pwd><br>
	        </div>   
	           <input type="button" class= "button" id="backButton" onclick="window.location.href='Login.jsp'" value="back">  
	           <input type="reset" class="button" id="clearButton" value="clearAll">  
	           <input type="submit" class="button" id="sumbitButton" value="submit">  
        </form>
    </div>  
  </div>
</body>
</html>