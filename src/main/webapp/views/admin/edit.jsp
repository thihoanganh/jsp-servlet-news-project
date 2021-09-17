<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh sửa</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/admin?action=chinh-sua" method="post" enctype="multipart/form-data">
	<select class="form-control" name="cate">
		<c:forEach var="cate" items="${cates }">
				<option value="${cate.id }" ${post.cateId == cate.id ? 'selected="selected"':'' }>${cate.name }</option>
		</c:forEach>
	</select>
	
	    Tags( Mỗi tag cách nhau dấu ','):  <input type="text" class="form-control" name="tags" value="${tags }">
		Tiêu đề: <input type="text" class="form-control" name="title" value="${ post.title}">
		Tóm tắt: <input type="text" class="form-control" name="excerpt" value="${ post.excerpt}">
		<input type="hidden" value="${post.thumb }" name="oldthumb">
		<input type="hidden" value="${post.id }" name="id">
		<img  src="assets/thumb/${post.thumb}" width="200">
		<br>
		Hình ảnh mới: <input type="file" class="form-control" name="thumb">
		Nội dung :  <textarea name="content" id="content" rows="60" cols="80" >${ post.content}</textarea>
		<button type="submit" class="btn btn-primary">Lưu</button>
	</form>
	<script type="text/javascript">
	   CKEDITOR.replace('content')
	</script>
</body>
</html>