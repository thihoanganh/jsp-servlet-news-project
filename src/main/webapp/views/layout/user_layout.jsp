<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="dec"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="icon" href="/assets/img/24h.png">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:400,600&display=swap"
	rel="stylesheet">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- CSS Libraries -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">
<link href="/assets/lib/slick/slick.css" rel="stylesheet">
<link href="/assets/lib/slick/slick-theme.css" rel="stylesheet">
<!-- Template Stylesheet -->
<link href="/assets/css/style.css" rel="stylesheet">
<title><dec:title default="Trang chủ"></dec:title></title>
</head>
<body>
	<!-- Top Bar Start -->
	<div class="top-bar">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<div class="tb-contact">
						<p>
							<i class="fas fa-envelope"></i>thihoanganh.it@mail.com
						</p>
						<p>
							<i class="fas fa-phone-alt"></i>+84 777777661
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Top Bar Start -->

	<!-- Brand Start -->
	<div class="brand">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-3 col-md-4">
					<div class="b-logo">
						<a href="${pageContext.request.contextPath }/trang-chu"> <img src="/assets/img/logo.png"
							alt="Logo">
						</a>
					</div>
				</div>
				<div class="col-lg-6 col-md-4">
					<div class="b-ads">
						<a href="https://www.facebook.com/thihoanganh.it/" target="_blank"> <img
							src="/assets/img/ads-1.jpg" alt="Ads">
						</a>
					</div>
				</div>
				<div class="col-lg-3 col-md-4 text-center">
					<div class="b-search">
						<form action="${pageContext.request.contextPath }/tim-kiem">
							<input type="text" placeholder="Tìm kiếm" class="mb-3" name="key">
							<input type="hidden" name="page" value="1">
							<button type="submit">
								<i class="fa fa-search"></i>
							</button>
						</form>
						<c:if test="${sessionScope.user == null }">
							<a href="${pageContext.request.contextPath }/dang-nhap" class="btn btn-primary">Đăng nhập</a>
							<a href="#" class="btn btn-secondary" data-toggle="modal" data-target="#registerModal">Đăng kí</a>
						</c:if>
						<c:if test="${sessionScope.user != null }">
								<i class="fas fa-user user-icon"></i><i>${ sessionScope.user}</i>
								<a href="${pageContext.request.contextPath }/dang-xuat" class="ml-3">Đăng xuất</a>
						</c:if>

					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Brand End -->

	<!-- Nav Bar Start -->
	<div class="nav-bar">
		<div class="container">
			<nav class="navbar navbar-expand-md bg-dark navbar-dark">
				<a href="#" class="navbar-brand">MENU</a>
				<button type="button" class="navbar-toggler" data-toggle="collapse"
					data-target="#navbarCollapse">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse justify-content-between"
					id="navbarCollapse">
					<div class="navbar-nav mr-auto">
						<a href="${pageContext.request.contextPath }/trang-chu" class="nav-item nav-link active">Trang
							Chủ</a>
						<c:forEach var="cate" items="${cates }">
						<a href="${pageContext.request.contextPath }/the-loai?name=${cate.cateSlug}&id=${cate.id}&page=1" class="nav-item nav-link">${cate.name }</a>
						</c:forEach>
						
					</div>
					<div class="social ml-auto">
						<a href="https://www.facebook.com/thihoanganh.it/" target="_blank"><i
							class="fab fa-facebook-f"></i></a> <a
							href="https://www.linkedin.com/in/thi-truong-hoang-anh-b1ba951b8/"
							target="_blank"><i class="fab fa-linkedin-in"></i></a>

					</div>
				</div>
			</nav>
		</div>
	</div>
	<!-- Nav Bar End -->
	<dec:body></dec:body>

	<!-- Footer Start -->
	<div class="footer">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-6">
					<div class="footer-widget">
						<h3 class="title">Liên hệ</h3>
						<div class="contact-info">
							<p>
								<i class="fa fa-map-marker"></i>+84 777777661
							</p>
							<p>
								<i class="fa fa-envelope"></i>thihoanganh.it@gmail.com
							</p>
							<div class="social">
								<a href="https://www.facebook.com/thihoanganh.it/"><i
									class="fab fa-facebook-f"></i></a>
							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-3 col-md-6">
					<div class="footer-widget">
						<h3 class="title">Liên kết</h3>
						<ul>
							<li><a href="https://baomoi.com/" target="_blank">Báo mới</a></li>
							<li><a href="https://vnexpress.net/" target="_blank">VnExpress</a></li>
							<li><a href="https://zingnews.vn/" target="_blank">ZingsNew</a></li>
							<li><a href="https://plo.vn/" target="_blank">Báo pháp luật</a></li>
						</ul>
					</div>
				</div>

				<div class="col-lg-3 col-md-6">
					<div class="footer-widget">
						<h3 class="title">Nguồn</h3>
						<ul>
						<li><a href="https://baomoi.com/" target="_blank">Báo mới</a></li>
							<li><a href="https://vnexpress.net/" target="_blank">VnExpress</a></li>
							<li><a href="https://zingnews.vn/" target="_blank">ZingsNew</a></li>
							<li><a href="https://plo.vn/" target="_blank">Báo pháp luật</a></li>
						</ul>
					</div>
				</div>

				<div class="col-lg-3 col-md-6">
					<div class="footer-widget">
						<h3 class="title">Về chúng tôi</h3>
						<div class="newsletter">
							<p>Chúng tôi chuyên cập nhật các thông tin về tryền thông, báo
								chí, tạp chí trên mọi lĩnh vực đời sống, văn hóa, thể thao...</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer End -->


	<!-- Footer Bottom Start -->
	<div class="footer-bottom">
		<div class="container">
			<div class="row">
				<div class="col-md-6 copyright">
					<p>
						Copyright &copy; <a href="">Internet</a>. All Rights Reserved
					</p>
				</div>

				<div class="col-md-6 template-by">
					<p>
						Created By <a href="https://www.facebook.com/thihoanganh.it/" target="_blank">Thi HoangAnh</a>
					</p>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer Bottom End -->
	<!-- Modal đăng kí -->
	<div class="modal fade" id="registerModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered  role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title" id="exampleModalLabel">Đăng kí</h1>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close" #closeModal>
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body ">
					<form action="${pageContext.request.contextPath }/dang-ki"
						method="post" id="formRegister">
						<input type="text" class="form-control" name="name"
							placeholder="Họ và tên"> <input type="text"
							class="form-control" name="email" placeholder="Email"> <label>Nam:</label>
						<input type="radio" name="gender" value="Male" checked="checked">
						<label>Nữ:</label> <input type="radio" name="gender"
							value="Female"> <input type="text" class="form-control"
							name="username" placeholder="Tài khoản"> <span
							class="text-danger" id="user-error"></span> <input
							type="password" class="form-control" name="password"
							id="password" placeholder="Mật khẩu"> <input
							type="password" class="form-control" name="repassword"
							placeholder="Nhập lại mật khẩu">
						<hr>
						<button type="submit" class="btn btn-primary text-center"
							id="btnRegister">Đăng kí</button>
					</form>
				</div>
			</div>
		</div>
	</div>



	<!-- Back to Top -->
	<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>


	<script type="text/javascript"
		src="/assets/lib/jquery/dist/jquery.min.js"></script>
	<script type="text/javascript"
		src="/assets/lib/jquery-validation/dist/jquery.validate.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
	<script src="/assets/lib/easing/easing.min.js"></script>
	<script src="/assets/lib/slick/slick.min.js"></script>
	<script src="/assets/js/main.js"></script>
	<dec:getProperty property="page.local_script"></dec:getProperty>
</body>
</html>