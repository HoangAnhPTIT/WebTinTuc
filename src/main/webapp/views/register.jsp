<%@include file="/common/taglib.jsp"%>
<c:url var="userAPI" value="/api-user" />
<c:url var="dangNhap" value="/dang-nhap" />
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<div class="signup-form">
		<form id="formRegister">
			<h2>Sign Up</h2>
			<p>Please fill in this form to create an account!</p>
			<hr>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <i
							class="fa fa-paper-plane"></i>
						</span>
					</div>
					<input type="text" class="form-control" name="fullName"
						placeholder="Fullname" required="required">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <span class="fa fa-user"></span>
						</span>
					</div>
					<input type="text" class="form-control" name="userName"
						placeholder="Username" required="required">
				</div>
			</div>

			<div class="form-group">
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <i class="fa fa-lock"></i>
						</span>
					</div>
					<input type="password" class="form-control" name="password"
						placeholder="Password" required="required">
				</div>
			</div>
			<input type="hidden" name="roleId" value="2" />
<!-- 			<div class="form-group">
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <i class="fa fa-lock"></i>
							<i class="fa fa-check"></i>
						</span>
					</div>
					<input type="text" class="form-control" name="confirm_password"
						placeholder="Confirm Password" required="required">
				</div>
			</div> -->
			<div class="form-group">
				<label class="form-check-label"><input type="checkbox"
					required="required"> I accept the <a href="#">Terms of
						Use</a> &amp; <a href="#">Privacy Policy</a></label>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-lg"
					id="buttonSubmit">Sign Up</button>
			</div>
		</form>
		<div class="text-center">
			Already have an account? <a href="<c:url value='/dang-nhap'/>">Login
				here</a>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
		$('#buttonSubmit').click(function (e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formRegister').serializeArray();
			$.each(formData, function (i, v) {
				data[""+v.name+""] = v.value;
			})
			addNew(data);

			function addNew(data) {
				$.ajax({
					url: '${userAPI}',
					type: 'POST',
					contentType: 'application/json',
					data: JSON.stringify(data),
					dataType: 'json',
					success: function (result) {
						window.location.replace("${dangNhap}");
					},
					error: function (error) {
						console.log(error);
					}
				})
			}
		})
	</script>
</body>

</html>