<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="icon" href="/assets/img/24h.png">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" />
<link href="/assets/css/login.css" rel="stylesheet">
<title>Đăng nhập</title>
</head>
<body class="main-bg">
	<!-- Login Form -->
	<div class="container">
		<div class="row justify-content-center mt-5">
			<div class="col-lg-4 col-md-6 col-sm-6">
				<div class="card shadow">
					<div class="card-title text-center border-bottom">
						<h2 class="p-3">Đăng nhập</h2>
					</div>
					<div class="card-body">
						<form action="${pageContext.request.contextPath }/dang-nhap" method="post">
							<div class="mb-4">
								<label for="username" class="form-label">Tài khoản</label> <input
									type="text" class="form-control" id="username" name="username" />
							</div>
							<div class="mb-4">
								<label for="password" class="form-label">Mật khẩu</label> <input
									type="password" class="form-control" id="password"  name="password"/>
							</div>
							<input type="hidden" value="${returnUrl }" name="returnUrl">
							<div class="mb-4">
								<input type="checkbox" class="form-check-input" id="remember" />
								<label for="remember" class="form-label">Ghi nhớ</label>
							</div>
							<div class="mb-4">
								<span class="text-danger">${error }</span>
							</div>
							<div class="d-grid">
								<button type="submit" class="btn text-light main-bg">Đăng
									nhập</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>