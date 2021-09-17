<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tạo bài viết</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/admin?action=tao-bai-viet" method="post" enctype="multipart/form-data">
	<select class="form-control" name="cate">
		<c:forEach var="cate" items="${cates }">
				<option value="${cate.id }">${cate.name }</option>
		</c:forEach>
	</select>
		Tags( Mỗi tag cách nhau dấu ','): <input type="text" class="form-control" name="tags">
		Tiêu đề: <input type="text" class="form-control" name="title">
		Tóm tắt: <input type="text" class="form-control" name="excerpt">
		Hình ảnh : <input type="file" class="form-control" name="thumb">
		Nội dung :  <textarea name="content" id="content" rows="60" cols="80"></textarea>
		<button type="submit" class="btn btn-primary">Tạo bài viết</button>
	</form>
	<script type="text/javascript">
	   CKEDITOR.replace('content')
	</script>
</body>
</html>