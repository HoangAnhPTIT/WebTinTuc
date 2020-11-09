<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" href="<c:url value='/template/login/style.css'/>" />
</head>
<body>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<!-- Tabs Titles -->
			<c:if test="${not empty message}">
				<div class="alert alert-${alert}">${message}</div>
			</c:if>

			<!-- Login Form -->
			<form action="<c:url value='/dang-nhap' />" method="POST">
				<input type="text" id="login" class="fadeIn second" name="userName"
					placeholder="Login" /> <input type="password" id="password"
					class="fadeIn third" name="password" placeholder="Password" /> <input
					type="submit" class="fadeIn fourth" value="Log In" /> <input
					type="hidden" name="action" value="login" />
			</form>

			<!-- Remind Passowrd -->
			<div id="formFooter">
				<a class="underlineHover" href="#">Forgot Password?</a>
			</div>

		</div>
	</div>
</body>
</html>