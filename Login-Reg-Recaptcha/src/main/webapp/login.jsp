<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>Login Page</title>
<script src="https://www.google.com/recaptcha/api.js"></script>
</head>
<body>

	<form action="LoginServlet" method="post">

		email: <input type="email" name="email"> <br> password:
		<input type="password" name="pass"> <br>
		<div class="g-recaptcha"
			data-sitekey="6LeIxAcTAAAAAJcZVRqyHh71UMIEGNQ_MXjiZKhI" Secret key= "6LeIxAcTAAAAAGG-vFI1TnRWxMZNFuojJ4WifJWe"></div>
		<br> <input type="submit" value="Login">
	</form>
</body>
</html>