<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tag ${tag }</title>
</head>
<body>

	<!-- Single News Start-->
	<div class="single-news">
		<div class="container">
		<h3>Tìm kiếm #${tag } tag</h3>
			<div class="row">
				<div class="col-lg-8">
					<div class="sn-container">
						<div class="post-item">
							<c:forEach var="post" items="${post}">
								<div class="row mt-3">
									<div class="col-md-6 col-sm-6 col-lg-6">
										<a
											href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}"><img
											width="330" src=" assets/thumb/${post.thumb }" class="thumb"></a>
									</div>
									<div class="col-md-6 col-sm-6 col-lg-6 mt-3">
										<a
											href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}" ><h5 class="anchor-h4">${post.title }</h5></a>
										<p>
											<i>${post.timeAgo }</i>
										</p>
									</div>
								</div>
								<hr>
							</c:forEach>


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
								<a href="https://www.facebook.com/thihoanganh.it/" target="_blank"><img src="/assets/img/ads-2.jpg"
									alt="Image"></a>
							</div>
						</div>

					
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>