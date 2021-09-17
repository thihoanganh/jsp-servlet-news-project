<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tìm kiếm</title>
</head>
<body>

	<!-- Single News Start-->
	<div class="single-news">
		<div class="container">
			<h3>${totalPosts} kết quả được tìm thấy với từ khóa "${key}"</h3>
			<div class="row">
				<div class="col-lg-8 search-result">
					<div class="sn-container">
						<div class="post-item">
							<c:forEach var="post" items="${posts}">
								<div class="row mt-3">
									<div class="col-md-6 col-sm-6 col-lg-6">
										<a
											href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}"><img
											width="330" src=" assets/thumb/${post.thumb }" class="thumb"></a>
									</div>
									<div class="col-md-6 col-sm-6 col-lg-6">
										<a
											href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}"><h4 class="anchor-h4">${post.title }</h4></a>
										<p>
											<i>${post.timeAgo }</i>
										</p>
									</div>
								</div>
								<hr>
							</c:forEach>


						</div>
					</div>
					<div class="text-center">
					<div class="pagination">
						  <a href="${pageContext.request.contextPath }/tim-kiem?page=1&key=${key}">&laquo; Đầu </a>
						  		
						  			<c:if test="${totalPage>3 && currentPage != 1 && currentPage != totalPage}">
						  					<c:forEach begin="${currentPage-1 }" end="${currentPage+1}" var="page">
												<c:if test="${page == currentPage }">
									  				<a href="${pageContext.request.contextPath }/tim-kiem?page=${page}&key=${key}" class="active">${page }</a>
									  			</c:if>
									  			<c:if test="${page != currentPage }">
									  				<a href="${pageContext.request.contextPath }/tim-kiem?page=${page}&key=${key}" >${page }</a>
									  			</c:if>		
									  	 </c:forEach>				
						  			</c:if>
						  			
						  			<c:if test="${totalPage>3 && currentPage == 1}">
						  					<c:forEach begin="1" end="3" var="page">
												<c:if test="${page == currentPage }">
									  				<a href="${pageContext.request.contextPath }/tim-kiem?page=${page}&key=${key}" class="active">${page }</a>
									  			</c:if>
									  			<c:if test="${page != currentPage }">
									  				<a href="${pageContext.request.contextPath }/tim-kiem?page=${page}&key=${key}" >${page }</a>
									  			</c:if>		
									  	 </c:forEach>				
						  			</c:if>
						  			
						  			<c:if test="${totalPage>3 && currentPage == totalPage}">
						  					<c:forEach begin="${totalPage-2}" end="${totalPage }" var="page">
												<c:if test="${page == currentPage }">
									  				<a href="${pageContext.request.contextPath }/tim-kiem?page=${page}&key=${key}" class="active">${page }</a>
									  			</c:if>
									  			<c:if test="${page != currentPage }">
									  				<a href="${pageContext.request.contextPath }/tim-kiem?page=${page}&key=${key}" >${page }</a>
									  			</c:if>		
									  	 </c:forEach>				
						  			</c:if>
						  			
						  			<c:if test="${totalPage <= 3 }">
						  				<c:forEach begin="1" end="${totalPage}" var="page">
												<c:if test="${page == currentPage }">
									  				<a href="${pageContext.request.contextPath }/tim-kiem?page=${page}&key=${key}" class="active">${page }</a>
									  			</c:if>
									  			<c:if test="${page != currentPage }">
									  				<a href="${pageContext.request.contextPath }/tim-kiem?page=${page}&key=${key}" >${page }</a>
									  			</c:if>		
									  	 </c:forEach>					  			
						  			</c:if>
						  	
					  			<c:if test="${totalPage>3 && totalPage != currentPage}">
					  					...
					  					<a href="${pageContext.request.contextPath }/tim-kiem?page=${totalPage}&key=${key}">${totalPage}</a>
					  			</c:if>
						  <a href="${pageContext.request.contextPath }/tim-kiem?page=${totalPage}&key=${key}">Cuối &raquo;</a>
					</div>
					</div>
				</div>
					
				<div class="col-lg-4">
					<div class="sidebar">





						<div class="sidebar-widget">
							<h2 class="sw-title">Thể loại</h2>
							<div class="category">
								<ul>
									<c:forEach var="cate" items="${PostOfCategory }">
										<li><a
											href="${pageContext.request.contextPath }/the-loai?name=${cate.cateSlug}&id=${cate.id}&page=1">${cate.name }</a><span>(${cate.totalPost})</span></li>
									</c:forEach>
								</ul>
							</div>
						</div>

						<div class="sidebar-widget">
							<div class="image">
								<a href="https://www.facebook.com/thihoanganh.it/" target="_blank"><img
									src="/assets/img/ads-2.jpg" alt="Image"></a>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>