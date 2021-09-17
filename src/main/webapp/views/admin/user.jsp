<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tài khoản</title>
</head>
<body>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Id</th>
				<th>Họ tên</th>
				<th>Tài khoản</th>
				<th>Email</th>
				<th>Giới tính</th>
				<th>Chặn</th>
				<th>Ngày tạo</th>
			</tr>
		<thead>
		<c:forEach var="user" items="${users }">
			<tr>
				<td>${user.id }</td>
				<td>${user.name }</td>
				<td>${user.username }</td>
				<td>${user.email }</td>
				<td>${user.gender ? 'Nam' : 'Nữ' }</td>
				<td>${user.block }</td>
				<td><fmt:formatDate value="${user.createDate }" pattern="yyyy-MM-dd HH:mm" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>