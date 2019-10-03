<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
   <meta charset="ISO-8859-1">
   <title>Welcome back!</title>
   <script type= text/javascript src="../JavaScript/userProfile.js"></script>
   <link rel="stylesheet" href="/AlmitaInn/StyleSheets/ProfileStyleSheet.css" type="text/css">
  
</head>
<body onload="loadRoom()">
 
 <div class="header">
   <h1>Profile</h1>
 </div>
 


 <div class="displayMode">
  <label for="dropDown" >Show:</label>
  <select name="dropDown"id="dropDown">
        
     <option value="Room">Room</option>
     <option value="Activites">Activities</option>
     <option value="Purchases">Store</option>
  
  </select>
 </div>

 <div class="dropDownOutPut">
  
 </div>





</body>
</html>