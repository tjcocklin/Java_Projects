<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
   <meta charset="ISO-8859-1">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>Welcome back!</title>
   <script type= text/javascript src="JavaScript/userProfile.js"></script>
   <link rel="stylesheet" href="/AlmitaInn/StyleSheets/ProfileStyleSheet.css" type="text/css">
  
</head>
  <script type="text/javascript"></script>


<body onload="loadDefault()">
 
 <div class="header">
   <h1>Profile</h1>
 </div>
 

 <div class="displayMode">
  <label for="dropDown" >Show:</label>
  <select name="dropDown"id="dropDown" onchange= "loadData()">
        
     <option value="Room">Room</option>
     <option value="Activities">Activities</option>
     <option value="Purchases">Purchases</option>
  
  </select>
 </div>
 <div class="container">
	 <div id="Room">
	   <pre>Room ID: ${custRoom.roomID}</pre>
	   <pre>Description: ${custRoom.description}</pre>
	   <pre>Price: $${custRoom.price}</pre>
	 </div>
	
	 <div id="Activities">
	   <pre>Activity ID: ${custRoom.roomID}</pre>
	   <pre>Description: ${custRoom.description}</pre>
	 </div>
	 
	 <div id="Purchases">
	   <pre>Item Name: ${custRoom.roomID}</pre>
	   <pre>Description: ${custRoom.description}</pre>
	 </div>
</div>


</body>
</html>