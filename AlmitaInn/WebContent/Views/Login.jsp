<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Login</title>
<link rel="stylesheet" href="/AlmitaInn/StyleSheets/LoginStyleSheet.css" type="text/css">
</head>
<body>
  
  <div class=Header>
    <h1>Sign in</h1>
  </div>
  
  <div class="container">
	  <div class=Login >
	    <form action="../LoginController" method="post">
	     e-mail:
	     <input required type="email" name=e-mail id=e-mail><br>
	     password:
	     <input required type="password" name=password id=password><br>
	     <input type="submit" value="Login" id=submitButton>
	     <a href="NewUser.jsp" id=createLink>Create account </a>
	    </form>
	  </div>
  </div>
  
  
</body>
</html>