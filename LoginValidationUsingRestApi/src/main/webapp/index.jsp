<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="rest/product/add" method="post">  
<label> Firstname </label>         
<input type="text" name="name" size="15"/> <br> <br>  

  


  
<label>   
Phone :  
</label>  
<input type="text" name="country code"  value="+91" size="2"/>   
<input type="text" name="phone" size="10"/> <br> <br>  
Address  
<br>  
<textarea cols="80" rows="5" value="address" name="address">  
</textarea>  
<br> <br>  
Email:  
<input type="email" id="email" name="email"/> <br>    
<br> <br>  
Password:  
<input type="Password" id="pass" name="pass"> <br>   
<br> <br>  

<input type="submit" value="Add"/>
</form>
</body>
</html>