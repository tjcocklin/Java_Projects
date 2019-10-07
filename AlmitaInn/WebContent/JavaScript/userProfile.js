


function loadDefault() 
{
		
	var selected = document.getElementById("dropDown").value;
	//alert("selected: "+selected);
	
	makeVisible(selected);
  
}


function loadData()
{
	var selected = document.getElementById("dropDown").value;
	//alert("new selected: "+selected);
	makeVisible(selected);
}



function makeVisible(elem)
{
   arr=['Room','Activities','Purchases']
   
   
   
   for( i=0; i < arr.length; i++)
   {
	   
	   if(elem == arr[i])
	   {
		   document.getElementById(arr[i]).style.visibility= "visible";
	   }
	   else
	   {
		   document.getElementById(arr[i]).style.visibility= "hidden";
	   }
	   
   }
     
	
}

