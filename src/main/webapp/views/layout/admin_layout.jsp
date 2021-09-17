<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="dec"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
<link href="/assets/admin/css/bootstrap.min.css" rel="stylesheet" />
<link href="/assets/admin/css/light-bootstrap-dashboard.css?v=2.0.0 "
	rel="stylesheet" />
<link href="/assets/admin/css/demo.css" rel="stylesheet" />
<link href="/assets/admin/css/style.css" rel="stylesheet" />
<script type="text/javascript" src="/assets/lib/ckeditor/ckeditor.js"></script>
<title><dec:title></dec:title></title>
</head>
<body>
	<div class="wrapper">
		<div class="sidebar" data-image="../assets/img/sidebar-5.jpg">
			<div class="sidebar-wrapper">
				<div class="logo">
					<a href="${pageContext.request.contextPath }/admin"
						class="simple-text"> Quản Trị Tin Tức 24h </a>
				</div>
				<ul class="nav">
					<li class="nav-item active"><a class="nav-link"
						href="${pageContext.request.contextPath }/admin?action=thong-ke">
							<i class="nc-icon nc-chart-pie-35"></i>
							<p>Thống kê</p>
					</a></li>
					<li><a class="nav-link"
						href="${pageContext.request.contextPath }/admin?action=tai-khoan">
							<i class="nc-icon nc-circle-09"></i>
							<p>Tài khoản</p>
					</a></li>
					<li><a class="nav-link"
						href="${pageContext.request.contextPath }/admin?action=bai-viet&page=1">
							<i class="nc-icon nc-notes"></i>
							<p>Bài viết</p>
					</a></li>
					<li><a class="nav-link"
						href="${pageContext.request.contextPath }/admin?action=tao-bai-viet">
							<i class="nc-icon nc-paper-2"></i>
							<p>Tạo bài viết</p>
					</a></li>
				</ul>
			</div>
		</div>
		<div class="main-panel">
			<!-- Navbar -->
			<nav class="navbar navbar-expand-lg " color-on-scroll="500">
				<div class="container-fluid">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath }/admin?action=dang-xuat">
								<span class="no-icon">Đăng xuất</span>
						</a></li>
					</ul>
				</div>
			</nav>
			<!-- End Navbar -->
			<div class="content">
				<div class="container-fluid">
					<!--content will go here-->
					<dec:body></dec:body>
				</div>
			</div>
			<footer class="footer">
				<div class="container-fluid">
					<nav>
						<p class="copyright text-center">
							©
							<script>
								document.write(new Date().getFullYear())
							</script>
							<a href="http://www.creative-tim.com">Team Thi HoangAnh</a>, hân
							hạnh tài trợ :))
						</p>
					</nav>
				</div>
			</footer>
		</div>
	</div>

</body>
<script type="text/javascript" src="/assets/lib/jquery/dist/jquery.min.js"></script>
<script type="text/javascript" src="/assets/admin/js/main.js"></script>
</html>