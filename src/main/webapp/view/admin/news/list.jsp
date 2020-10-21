<%@ include file="/common/taglib.jsp"%>
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
	<form action="<c:url value = '/admin-news'/>" id="formSubmit"
		method="get">


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
										<c:forEach var="item" items="${model.listResults}">
											<tr>
												<td>${item.title}</td>
												<td>${item.shortDescription}</td>
											</tr>
										</c:forEach>

									</tbody>
								</table>
								<nav aria-label="Page navigation">
									<ul class="pagination" id="pagination"></ul>
								</nav>
								<input type="hidden" value="" id="page" name="page"/>
								<input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
							</div>

						</div>
					</div>
				</div>
			</div>
		
	</form>
</div>
	<!-- 	/.main-content -->
		<script>
		var visiblePages = ${model.maxPageItem}
		var totalPages = ${model.totalItem}
		var currentPage = ${model.page};
		var limit = 3;
		$(function () {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages: totalPages,
				visiblePages: limit,
				startPage: currentPage,
				onPageClick: function (event, page) {
					if(currentPage != page ){
						$('#maxPageItem').val(limit);
						$('#page').val(page);
						$('#formSubmit').submit();
					}

					
				}
			});
		});
	</script>
</body>

</html>