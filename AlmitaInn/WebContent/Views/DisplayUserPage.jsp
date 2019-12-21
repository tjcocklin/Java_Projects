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
   <h1>Welcome back ${custName}!</h1>
 </div>
  
  <div class="navigation">
   <ul >
	 <li><a class="active" href="AlmitaInn/Welcome.jsp">profile</a></li>
	 <li><a  href="Welcome.jsp">Log out</a></li>
	 <li><a  href="Login.jsp">Activities</a></li>
	 <li><a  href="Contact.jsp">Store</a></li>
	 <li><a  href="About.jsp">Update my profile</a></li>
  </ul>
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
	   <table >
	   	<thead> 
	    	<tr>
	        	<th>Room ID</th>
	         	<th>Description</th>
            	<th>Price</th>	      
	        </tr>
	  	</thead>    
	    <tbody>
	    
	     <%
	               
	    out.print(request.getAttribute("custRoom"));
	   %>
	   </tbody>
	 </table>
	    
	 </div>
	
	 <div id="Activities">
	    <table class = "ActTable" >
	   	<thead class = "ActTable"> 
	    	<tr class = "ActTable">
	        	<th class = "ActTable">Activity</th>
	         	<th class = "ActTable">Description</th>
            	     
	        </tr>
	  	</thead>    
	    <tbody>
	    
	     <%
	               
	    out.print(request.getAttribute("custActs"));
	   %>
	   </tbody>
	 </table>
	 </div>
	 
	 <div id="Purchases">
	  <table >
	   	<thead> 
	    	<tr>
	        	<th>Receipt no.</th>
	         	<th>Item</th>
            	<th>Price</th>	      
	        </tr>
	  	</thead>    
	    <tbody>
	    
	     <%
	               
	    out.print(request.getAttribute("custPurchases"));
	   %>
	   </tbody>
	 </table>
	 </div>
</div>


</body>
</html>