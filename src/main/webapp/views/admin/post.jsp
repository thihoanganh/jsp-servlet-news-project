<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Bài viết</title>
</head>
<body>
	<c:if test="${success != null }">
		<div class="alert alert-success">
			<strong>${success }</strong>
		</div>
	</c:if>
	<c:if test="${error != null }">
		<div class="alert alert-danger">
			<strong>${error }</strong>
		</div>
	</c:if>
	<form action="${pageContext.request.contextPath }/admin?action=search" method="post">
		<div class="row">
			<div class="col-sm-4">
				<input type="text" name="key" class="form-control">
			</div>
			<div class="col-sm-4">
				<button class="btn btn-primary" type="submit">Tìm kiếm</button>
			</div>
		</div>
	</form>
	<form action="${pageContext.request.contextPath }/admin?action=filter"  class="mt-3" method="post">
		<div class="row">
			<div class="col-sm-4">
				<select class="form-control" name="cateid">
					<c:forEach var="cate" items="${cates }">
						<option value="${cate.id }">${cate.name }</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-sm-4">
				<button class="btn btn-primary" type="submit">Lọc</button>
			</div>
		</div>
	</form>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Id</th>
				<th>Tiêu đề</th>
				<th>Lượt xem</th>
				<th>Thể loại</th>
				<th>Nổi bậc</th>
				<th>Ngày tạo</th>
				<th>Thiết lập</th>
			</tr>
		<thead>
			<c:forEach var="post" items="${posts }">
				<tr>
					<td>${post.id }</td>
					<td>${post.title }</td>
					<td>${post.view }</td>
					<td>${post.cateName }</td>
					<td><label class="switch"> <input type="checkbox"
							name="trending" ${post.trending ? 'checked="checked"':'' }>
							<span class="slider"> <input type="hidden"
								name="article_id" value="${post.id }"></span>
					</label></td>
					<td><fmt:formatDate value="${post.createdDate }"
							pattern="yyyy-MM-dd HH:mm" /></td>
							<td><a href="${pageContext.request.contextPath }/admin?action=chinh-sua&id=${post.id}" class="btn btn-primary">Chỉnh sửa</a><a  href="${pageContext.request.contextPath }/admin?action=xoa&id=${post.id}" class="btn btn-danger">Xóa</a></td>
				</tr>
			</c:forEach>
			
	</table>
	 <p><b>Tổng cộng:</b><span>${totalPost }</span></p>
    <form method="post" action="${pageContext.request.contextPath }/admin?action=paginate">
        <input type="submit" value="Đi đến" class="btn btn-success" />
        <span>trang <input type="number" name="page" value="${page }" /> of ${totalPage}</span>
    </form>
</body>
</html>