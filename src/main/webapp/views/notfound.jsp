<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Không tìm thấy trang</title>
<link href="/assets/css/notfound.css" rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<section class="page_404 text-center">
			<div class="container">
				<div class="row">
					<div class="col-sm-12 ">
						<div class="col-sm-10 col-sm-offset-1  text-center">
							<div class="four_zero_four_bg">
								<h1 class="text-center ">404</h1>
							</div>
							<div class="contant_box_404">
								<h3 class="h2">Không tìm thấy trang</h3>
								<a href="${ pageContext.request.contextPath}/trang-chu" class="btn btn-outline-primary">Trở lại</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>
</html>