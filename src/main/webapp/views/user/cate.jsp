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
		<h3>Tin tức ${cate.name }</h3>
			<div class="row">
				<div class="col-lg-8">
					<div class="sn-container">
						<div class="post-item">
							<c:forEach var="post" items="${posts }">
								<div class="row mt-3">
									<div class="col-md-6 col-sm-6 col-lg-6">
										<a
											href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}"><img
											width="330" src=" assets/thumb/${post.thumb }" class="thumb"></a>
									</div>
									<div class=" col-lg-6 mt-3">
										<a
											href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}" ><h5 class="anchor-h4">${post.title }</h5></a>
										<p>
											<i>${post.timeAgo =="cách đây khắc" ? "Vừa xong" : post.timeAgo}</i>
										</p>
									</div>
								</div>
								<hr>
							</c:forEach>


						</div>
					</div>
							<div class="text-center">
											<div class="pagination">
												  <a href="${pageContext.request.contextPath }/the-loai?name=${cate.cateSlug}&id=${cate.id}&page=1">&laquo; Đầu </a>
												  			<c:if test="${totalPage>3 && currentPage != 1 && currentPage != totalPage}">
												  					<c:forEach begin="${currentPage-1 }" end="${currentPage+1}" var="page">
																		<c:if test="${page == currentPage }">
															  				<a href="${pageContext.request.contextPath }/the-loai?name=${cate.cateSlug}&id=${cate.id}&page=${page}" class="active">${page }</a>
															  			</c:if>
															  			<c:if test="${page != currentPage }">
															  				<a href="${pageContext.request.contextPath }/the-loai?name=${cate.cateSlug}&id=${cate.id}&page=${page}" >${page }</a>
															  			</c:if>		
															  	 </c:forEach>				
												  			</c:if>
												  			
												  			<c:if test="${totalPage>3 && currentPage == 1}">
												  					<c:forEach begin="1" end="3" var="page">
																		<c:if test="${page == currentPage }">
															  				<a href="${pageContext.request.contextPath }/the-loai?name=${cate.cateSlug}&id=${cate.id}&page=${page}" class="active">${page }</a>
															  			</c:if>
															  			<c:if test="${page != currentPage }">
															  				<a href="${pageContext.request.contextPath }/the-loai?name=${cate.cateSlug}&id=${cate.id}&page=${page}" >${page }</a>
															  			</c:if>		
															  	 </c:forEach>				
												  			</c:if>
												  			
												  			<c:if test="${totalPage>3 && currentPage == totalPage}">
												  					<c:forEach begin="${totalPage-2}" end="${totalPage }" var="page">
																		<c:if test="${page == currentPage }">
															  				<a href="${pageContext.request.contextPath }/the-loai?name=${cate.cateSlug}&id=${cate.id}&page=${page}" class="active">${page }</a>
															  			</c:if>
															  			<c:if test="${page != currentPage }">
															  				<a href="${pageContext.request.contextPath }/the-loai?name=${cate.cateSlug}&id=${cate.id}&page=${page}" >${page }</a>
															  			</c:if>		
															  	 </c:forEach>				
												  			</c:if>
												  			
												  			<c:if test="${totalPage <= 3 }">
												  				<c:forEach begin="1" end="${totalPage}" var="page">
																		<c:if test="${page == currentPage }">
															  				<a href="${pageContext.request.contextPath }/the-loai?name=${cate.cateSlug}&id=${cate.id}&page=${page}" class="active">${page }</a>
															  			</c:if>
															  			<c:if test="${page != currentPage }">
															  				<a href="${pageContext.request.contextPath }/the-loai?name=${cate.cateSlug}&id=${cate.id}&page=${page}" >${page }</a>
															  			</c:if>		
															  	 </c:forEach>					  			
												  			</c:if>
												  	
											  			<c:if test="${totalPage>3 && totalPage != currentPage}">
											  					...
											  					<a href="${pageContext.request.contextPath }/the-loai?name=${cate.cateSlug}&id=${cate.id}&page=${totalPage}">${totalPage}</a>
											  			</c:if>
												  <a href="${pageContext.request.contextPath }/the-loai?name=${cate.cateSlug}&id=${cate.id}&page=${totalPage}">Cuối &raquo;</a>
											</div>
											</div>
				</div>

				<div class="col-lg-4">
					<div class="sidebar">
						<div class="sidebar-widget">
							<h2 class="sw-title">Gợi ý</h2>
							<div class="news-list">
								<c:forEach var="post" items="${randomPost }">
									<div class="nl-item">
										<div class="nl-img">
											<img src="/assets/thumb/${post.thumb }" />
										</div>
										<div class="nl-title">
											<a href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}">${post.title }</a>
										</div>
									</div>
								</c:forEach>
								
							
							
							</div>
						</div>

						<div class="sidebar-widget">
							<div class="image text-center">
								<a href="https://www.facebook.com/thihoanganh.it/" target="_blank"><img src="/assets/img/ads-2.jpg"
									alt="Image"></a>
							</div>
						</div>

						<div class="sidebar-widget">
							<div class="tab-news">
								<ul class="nav nav-pills nav-justified">
									<li class="nav-item"><a class="nav-link active"
										data-toggle="pill" href="#featured">Covid-19</a></li>
									<li class="nav-item"><a class="nav-link"
										data-toggle="pill" href="#popular">Gần đây</a></li>
									<li class="nav-item"><a class="nav-link"
										data-toggle="pill" href="#latest">Nổi bậc</a></li>
								</ul>
								<div class="tab-content">
									<div id="featured" class="container tab-pane active">
										<c:forEach var="post" items="${covidPostInCollectionBar }">
											<div class="tn-news">
												<div class="tn-img">
													<img src="/assets/thumb/${post.thumb }" />
												</div>
												<div class="tn-title">
													<a href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}">${post.title }</a>
												</div>
											</div>
										</c:forEach>
									</div>
									<div id="popular" class="container tab-pane fade">
											<c:forEach var="post" items="${latestPostInCollectionBar }">
											<div class="tn-news">
												<div class="tn-img">
													<img src="/assets/thumb/${post.thumb }" />
												</div>
												<div class="tn-title">
													<a href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}">${post.title }</a>
												</div>
											</div>
										</c:forEach>
									</div>
									<div id="latest" class="container tab-pane fade">
										<c:forEach var="post" items="${	popularPostInCollectionBar }">
											<div class="tn-news">
												<div class="tn-img">
													<img src="/assets/thumb/${post.thumb }" />
												</div>
												<div class="tn-title">
													<a href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}">${post.title }</a>
												</div>
											</div>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>

						<div class="sidebar-widget">
							<div class="image text-center">
								<a href="https://www.facebook.com/thihoanganh.it/" target="_blank"><img src="/assets/img/ads-2.jpg"
									alt="Image"></a>
							</div>
						</div>

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
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>