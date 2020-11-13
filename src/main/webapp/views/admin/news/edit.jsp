<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url var="APIurl" value="/api-new" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chỉnh sửa bài viết</title>
</head>

<body>
	<div class="main-content">

		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
							chủ</a></li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">

						<div class="row">
							<form id="formSubmit">

								<div class="col-xs-12">
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Thể
											loại</label>
										<div class="col-sm-9">
											<select class="form-control" id="categoryCode"
												name="categoryCode">
												<c:if test="${empty model.categoryCode}">
													<option>Chọn loại bài viết</option>
													<c:forEach var="item" items="${categories}">
														<option value="${item.code}">${item.name}</option>
													</c:forEach>
												</c:if>
												<c:if test="${not empty model.categoryCode}">
													<option>Chọn loại bài viết</option>
													<c:forEach var="item" items="${categories}">
														<c:if test="${model.categoryCode == item.code}">
															<option value="${item.code}" selected="selected">
																${item.name}</option>
														</c:if>
														<option value="${item.code}">${item.name}</option>
													</c:forEach>


												</c:if>
											</select>
										</div>
									</div>
									<br /> <br />
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Tiêu
											đề</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="title"
												name="title" value="${model.title}" />
										</div>
									</div>
									<br /> <br />
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Hình
											đại diện</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="thumbnail"
												name="thumbnail" value="" />
										</div>
									</div>
									<br /> <br />
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Mô
											tả ngắn</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="shortDescription"
												name="shortDescription" value="${model.shortDescription}" />
										</div>
									</div>
									<br /> <br />
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Nội
											dung</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="content"
												name="content" value="${model.content}" />
										</div>
									</div>
									<br /> <br />
									<div class="form-group">

										<div class="col-sm-12">
											<c:if test="${not empty model.id}">
												<input type="button"
													class="btn btn-white btn-warning btn-bold"
													value="Sửa bài viết" id="btnAddOrUpdateNew" />
											</c:if>
											<c:if test="${empty model.id}">
												<input type="button"
													class="btn btn-white btn-warning btn-bold"
													value="Thêm mới bài viết" id="btnAddOrUpdateNew" />
											</c:if>
										</div>
									</div>
								</div>
								<input type="hidden" value="${model.id}" id="id" name="id" />
							</form>
						</div>
					</div>
				</div>
			</div>

		</div>
		<!-- /.main-content -->
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script>
			$('#btnAddOrUpdateNew').click(function (e) {
				e.preventDefault();
				var data = {};
				var formData = $('#formSubmit').serializeArray();
				$.each(formData, function (i, v) {
					data[""+v.name+""] = v.value;
				})
				var id = $('#id').val();
				if (id == "") {
					addNew(data);
				} else {
					updateNew(data);
				}
	
				function addNew(data) {
					$.ajax({
						url: '${APIurl}',
						type: 'POST',
						contentType: 'application/json',
						data: JSON.stringify(data),
						dataType: 'json',
						success: function(result){
							console.log(result);
						},
						error: function(error){
							console.log(error);
						}
					})
				}
	
				function updateNew(data) {
					$.ajax({
						url: '${APIurl}',
						type: 'PUT',
						contentType: 'application/json',
						data: JSON.stringify(data),	
						dataType: 'json',
						success: function(result){
							console.log(result);
						},
						error: function(error){
							console.log(error);
						} 
					})
				}
			});
			
		</script>
</body>

</html>