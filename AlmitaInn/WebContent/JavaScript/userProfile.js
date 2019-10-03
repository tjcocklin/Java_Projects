


function loadRoom() 
{
		
	//alert("its working!");
    
    var parentElement = document.getElementById("dropDownOutPut");   
    var newElement = document.createElement("p");
    var node= document.createTextNode("Room number: ${custRoom.ID}");
    
    newElement.appendChild(node);
    parentElement.appendChild(newElement);


}
