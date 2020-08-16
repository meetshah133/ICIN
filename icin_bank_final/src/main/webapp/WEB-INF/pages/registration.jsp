<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
<style> 

.container {
        
               background: linear-gradient(90deg,rgb(216, 179, 206),rgb(201, 248, 245));
    } 
  
* {    
  box-sizing: border-box; 
     
}    
    
input[type=text], select, textarea {    
  width: 80%;    
  padding: 12px;    
  border: 1px solid rgb(70, 68, 68);    
  border-radius: 4px;    
  resize: vertical;    
}    
input[type=email], select, textarea {    
  width: 80%;    
  padding: 12px;    
  border: 1px solid rgb(70, 68, 68);    
  border-radius: 4px;    
  resize: vertical;    
}    
    
label {    
  padding: 12px 12px 12px 0;    
  display: inline-block;    
}    
    
input[type=submit] {    
left:20px;
top: 1000px;
  background-color: rgb(37, 116, 161);    
  color: white;    
  padding: 12px 20px;    
  border: none;    
  border-radius: 4px;    
  cursor: pointer;    
  float: right;    
}    
    
input[type=submit]:hover { 
   
  background-color: rgb(143, 207, 58);    
}    
    
.container {    
  border-radius: 5px;    
  background-color: #f2f2f2;    
  padding: 20px;    
}    
    
.col-25 {    
  float: left;    
  width: 25%;    
  margin-top: 6px;    
}    
    
.col-75 {    
  float: left;    
  width: 55%;    
  margin-top: 6px;    
}    
    
/* Clear floats after the columns */    
.row:after {    
  content: "";    
  display: table;    
  clear: both;    
}    
</style>
</head>
<body>



<h2>Registration</h2>    
<div class="container">    


<form method="post" action="/registration">
<div class="row">    
      <div class="col-25"><strong>Username :</strong>  <br></div>    
      <div class="col-75">
      <input type = "text" name = "uName" placeholder="Your Name " required><br>
      </div>    
    
		<div class="col-25"><strong>Email :</strong> <br></div>
		      <div class="col-75">
		<input type = "email" name ="uEmail" placeholder="Your Email " required><br>
		</div>    
    
		<div class="col-25"><strong>Contact :</strong> <br></div>
			<div class="col-75">
				<input type = "number" name ="uContact" placeholder="Your Phone" required><br>
				      
			</div>    
			
			<div class="col-25"><strong>PanCard Details :</strong> <br></div>
			<div class="col-75">
				<input type = "number" name ="uPan" placeholder="Your Pan" required><br>
				      
			</div>   
			
			 <div class="col-25"><strong>Password :</strong>  <br></div>    
      <div class="col-75">
      <input type = "text" name = "uPass" placeholder="Your Password " required><br>
      </div> 
      
       <div class="col-25"><strong>Date of Birth :</strong>  <br></div>    
      <div class="col-75">
      <input type = "date" name = "uDOB" placeholder=" " required><br>
      </div>  
		
		
        <br>
        <br>
		
		
		
         
                 
	</form>
	
    </div> 
    
    
    <script>

    var x= document.getElementById("submit")
    function getLocation(){
        if(navigator.geolocation){
            navigator.geolocation.getCurrentPosition(showPosition)
        }
    }

    function showPosition(position){
        x.innerHTML="Latitude:" + position.coords.latitude +
        "<br> Longitude"+ position.coords.longitude
    }


    </script>     
</body>
</html>


