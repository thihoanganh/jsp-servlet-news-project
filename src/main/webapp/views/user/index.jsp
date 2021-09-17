<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
</head>
<body>
	<c:if test="${createStatus=='true' }">
		<div class="alert alert-success text-center">
			<strong>Thành công!</strong> Tạo tài khoản thành công.
		</div>
	</c:if>
	<c:if test="${createStatus=='false' }">
		<div class="alert alert-danger  text-center">
			<strong>Thất bại!</strong> Đã có lỗi xảy ra. Vui lòng thử lại !
		</div>
	</c:if>
	<!-- Top News Start-->
	<div class="top-news">
		<div class="container">
			<h3>Hôm nay</h3>
			<div class="row">
				<div class="col-md-6 tn-left">
					<div class="row tn-slider">
						<c:forEach var="post" items="${latestPost }">
							<div class="col-md-6">
								<div class="tn-img">
									<a
										href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}">
										<img src="/assets/thumb/${post.thumb }" />
									</a>
									<div class="tn-title">
										<a
											href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}">${post.title }</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="col-md-6 tn-right">
					<div class="row">
						<c:forEach var="post" items="${outstandingPost }">
							<div class="col-md-6">
								<div class="tn-img">
									<a
										href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}"><img
										src="/assets/thumb/${post.thumb }" class="img-top-popular" /></a>
									<div class="tn-title">
										<a
											href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}">${post.title }</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<!-- Top News End-->

	<!-- Category News Start-->
	<div class="cat-news">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<h2>Covid-19</h2>
					<div class="col-md-12">
						<c:forEach var="post" items="${covidPost }">
							<div class="row">
								<div class="col-md-6">
									<div class="cn-img">
										<a
											href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}"><img
											src="/assets/thumb/${post.thumb }" /></a>
									</div>
								</div>
								<div class="col-md-6">
									<a
										href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}"
										class="anchor">${post.title}</a>
									<p class="mt-3 time-ago">
										<i class="mt-3">${post.timeAgo =="cách đây khắc" ? "Vừa xong" : post.timeAgo}</i>
									</p>
								</div>
							</div>
						</c:forEach>
						<a
							href="${pageContext.request.contextPath }/the-loai?name=${covidCate.cateSlug}&id=${covidCate.id}&page=1"
							class="anchor"><i>Xem thêm ...</i></a>
					</div>
				</div>
				<div class="col-md-6">
					<h2>Xã hội</h2>
					<div class="col-md-12">
						<c:forEach var="post" items="${SocietyPost }">
							<div class="row">
								<div class="col-md-6">
									<div class="cn-img">
										<a
											href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}"><img
											src="/assets/thumb/${post.thumb }" /></a>
									</div>
								</div>
								<div class="col-md-6">
									<a
										href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}"
										class="anchor">${post.title}</a>
									<p class="mt-3 time-ago">
											<i class=" mt-3">${post.timeAgo =="cách đây khắc" ? "Vừa xong" : post.timeAgo}</i>
									</p>
								</div>
							</div>
						</c:forEach>
						<a
							href="${pageContext.request.contextPath }/the-loai?name=${SocietyCate.cateSlug}&id=${SocietyCate.id}&page=1"
							class="anchor"><i>Xem thêm ...</i></a>
					</div>
				</div>
				<div class="col-md-6">
					<h2>Kinh tế</h2>
					<div class="col-md-12">
						<c:forEach var="post" items="${EcomercePost }">
							<div class="row">
								<div class="col-md-6">
									<div class="cn-img">
										<a
											href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}"><img
											src="/assets/thumb/${post.thumb }" /></a>
									</div>
								</div>
								<div class="col-md-6">
									<a
										href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}"
										class="anchor">${post.title}</a>
									<p class="mt-3 time-ago">
											<i class=" mt-3">${post.timeAgo =="cách đây khắc" ? "Vừa xong" : post.timeAgo}</i>
									</p>
								</div>
							</div>
						</c:forEach>
						<a
							href="${pageContext.request.contextPath }/the-loai?name=${EcomerceCate.cateSlug}&id=${EcomerceCate.id}&page=1"
							class="anchor"><i>Xem thêm ...</i></a>
					</div>
				</div>
				<div class="col-md-6">
					<h2>Văn hóa</h2>
					<div class="col-md-12">
						<c:forEach var="post" items="${CulturePost }">
							<div class="row">
								<div class="col-md-6">
									<div class="cn-img">
										<a
											href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}"><img
											src="/assets/thumb/${post.thumb }" /></a>
									</div>
								</div>
								<div class="col-md-6">
									<a
										href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}"
										class="anchor">${post.title}</a>
									<p class="mt-3 time-ago">
											<i class=" mt-3">${post.timeAgo =="cách đây khắc" ? "Vừa xong" : post.timeAgo}</i>
									</p>
								</div>
							</div>
						</c:forEach>
						<a
							href="${pageContext.request.contextPath }/the-loai?name=${CultureCate.cateSlug}&id=${CultureCate.id}&page=1"
							class="anchor"><i>Xem thêm ...</i></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Category News End-->


	<!-- Tab News Start-->
	<div class="tab-news">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<ul class="nav nav-pills nav-justified">
						<li class="nav-item"><a class="nav-link active"
							data-toggle="pill" href="#featured">Phòng chống Covid-19</a></li>
						<li class="nav-item"><a class="nav-link" data-toggle="pill"
							href="#popular">Mới nhất trong ngày</a></li>
						<li class="nav-item"><a class="nav-link" data-toggle="pill"
							href="#latest">Nổi bậc trong tuần</a></li>
					</ul>
					<div class="tab-content">
						<div id="featured" class="container tab-pane active">
							<c:forEach var="post" items="${covidPostInCollectionBar }">
								<div class="tn-news">
										<a
											href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}"><img
											src="/assets/thumb/${post.thumb }" width="290"
											 class="thumb"></a>
									<div class="tn-title">
										<a
											href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}"
											class="anchor-h5">${post.title }</a>
											<p class="mt-3 time-ago">
											<i class=" mt-3">${post.timeAgo =="cách đây khắc" ? "Vừa xong" : post.timeAgo}</i>
									</p>
									</div>
								</div>
							</c:forEach>
						</div>
						<div id="popular" class="container tab-pane fade">
							<c:forEach var="post" items="${latestPostInCollectionBar }">
								<div class="tn-news">
										<a
											href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}"><img
											src="/assets/thumb/${post.thumb }" width="290" class="thumb" /></a>
									<div class="tn-title col-md-8">
										<a
											href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}"
											class="anchor-h5">${post.title }</a>
											<p class="mt-3 time-ago">
											<i class=" mt-3">${post.timeAgo =="cách đây khắc" ? "Vừa xong" : post.timeAgo}</i>
									</p>
									</div>
								</div>
							</c:forEach>
						</div>
						<div id="latest" class="container tab-pane fade">
							<c:forEach var="post" items="${highViewWeek }">
								<div class="tn-news">
										<a
											href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}"><img
											src="/assets/thumb/${post.thumb }" width="290" class="thumb" /></a>
									<div class="tn-title col-md-8">
										<a
											href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}"
											class="anchor-h5">${post.title }</a>
											<p class="mt-3 time-ago">
											<i class=" mt-3">${post.timeAgo =="cách đây khắc" ? "Vừa xong" : post.timeAgo}</i>
									</p>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>


			</div>
		</div>
	</div>
	<!-- Tab News Start-->

	<!-- Main News Start-->
	<div class="main-news">
		<div class="container">
			<h3 class="mt-3">Xem nhiều</h3>
			<div class="row">
				<div class="col-lg-9">
					<div class="row">
						<c:forEach var="post" items="${highView }">
							<div class="col-md-4">
								<div class="mn-img">
									<a href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}"><img src="/assets/thumb/${post.thumb }" /></a>
								</div>
										<a href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}" class="anchor">${post.title }</a>
								<p class="mt-3 time-ago">
											<i class=" mt-3">${post.timeAgo =="cách đây khắc" ? "Vừa xong" : post.timeAgo}</i>
									</p>
							</div>
						</c:forEach>
					</div>
				</div>

				<div class="col-lg-3">
					<div class="mn-list">
						<h2>Đọc thêm</h2>
						<ul>
							<c:forEach var="post" items="${randomPost }">
									<li class="mb-3"><a href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}">${post.title}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>