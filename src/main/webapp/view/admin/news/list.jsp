<%@ include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Danh Sách Bài Viết</title>
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
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>
									  <th>Tên bài viết</th>
									  <th>Mô tả ngắn</th>
									</tr>
								  </thead>
								  <tbody>
									<tr>
									  <td>John</td>
									  <td>Doe</td>
								  
									</tr>
								</tbody>
							  </table>
							  <nav aria-label="Page navigation">
								<!-- <ul class="pagination" id="pagination"></ul> -->
							</nav>
							  
						</div>
						
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.main-content -->
<!-- 	<script type="text/javascript">
		$(function () {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages: 10,
				visiblePages: 3,
				startPage: 2,
				onPageClick: function (event, page) {
					console.info(page + ' (from options)');
				}
			}).on('page', function (event, page) {
				console.info(page + ' (from event listening)');
			});
		});
	</script> -->
</body>

</html>