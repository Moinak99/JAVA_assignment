<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>    
    <script>    
    $(document).ready(function(){    
        $("button").click(function(){    
            $("div.d1").toggle();   // $("div.d1").toggle(1500);  
        });    
    });    
    </script>
</head>
<body>
<button>About Us</button>    
    <div class="d1" style="border:1px solid black;padding:10px;width:250px">    
    <p>  <b>About Us:</b><br/>  
    This is about us page<br/>  
    Hello  </p>   
    </div>
    <div>
    <a href="login.jsp">Login</a>
    <br />
    <a href="register.jsp">Register</a>
    </div>
</body>
</html>