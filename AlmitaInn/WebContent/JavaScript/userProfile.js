


function loadRoom() 
{
		
	alert("its working!");
    
    var parentElement = document.getElementById("dropDownOutPut");   
//    var newElement = document.createElement("p");
//    var node= document.createTextNode("Room number: ${custRoom.ID}");
    
    var cNodes= parentElement.children;
    
    cNodes[0].innerHTML="${custRoom.roomID}"; //"Here's your room: deomNum";
    
//    newElement.appendChild(node);
//    parentElement.appendChild(newElement);


}
