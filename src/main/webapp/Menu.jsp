<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--begin of menu-->
<style>
/* Styling the navbar */
.navbar {
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

.navbar .nav-link {
	color: #fff !important;
	transition: color 0.3s;
}

.navbar .nav-link:hover {
	color: #f39c12 !important;
}

.navbar-brand {
	font-weight: bold;
	color: #f39c12 !important;
	transition: color 0.3s;
}

.navbar-brand:hover {
	color: #e67e22 !important;
}

.btn-success {
	background-color: #28a745 !important;
	border-color: #28a745 !important;
	transition: background-color 0.3s, border-color 0.3s;
}

.btn-success:hover {
	background-color: #218838 !important;
	border-color: #1e7e34 !important;
}
/* Dropdown styling */
.dropdown-menu {
	background-color: #343a40;
	border: none;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.dropdown-item {
	color: #fff !important;
	transition: background-color 0.3s, color 0.3s;
}

.dropdown-item:hover {
	background-color: #495057;
	color: #f39c12 !important;
}
/* Cart badge styling */
.right {
	display: flex;
	align-items: flex-end;
	padding-left: 270px;
}

.center {
	display: flex;
	align-items: center;
	padding-left: 280px;
}
</style>

<nav class="navbar navbar-expand-md navbar-dark bg-dark"
	style="position: fixed; top: 0; width: 100%; z-index: 100000">
	<div class="container">
		<a class="navbar-brand" href="home">Torch Shoes</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExampleDefault"
			aria-controls="navbarsExampleDefault" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse justify-content-end"
			id="navbarsExampleDefault">
			<ul class="navbar-nav m-auto">
				<div class="center">
					<li class="nav-item"><a class="nav-link" href="home">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="shop">Shop</a></li>
					<li class="nav-item"><a class="nav-link" href="shop?brand=1">Nike</a></li>
					<li class="nav-item"><a class="nav-link" href="shop?brand=2">Adidas</a></li>
					<c:if test="${sessionScope.acc == null}">
						<li class="nav-item"><a class="nav-link"
							href="forgotPassword">Forgot Password</a></li>
					</c:if>
				</div>

				<div class="right">
					<form action="search" method="post"
						class="form-inline my-2 my-lg-0">
						<a class="btn btn-success btn-sm ml-3" href="managerCart"> <i
							class="fa fa-shopping-cart"></i> <span style="font-size: 14px;">Cart</span>
							<b><span id="amountCart" class="badge badge-light"
								style="color: black; font-size: 12px;"> </span></b>
						</a>
					</form>

					<c:if test="${sessionScope.acc == null}">
						<li class="nav-item"><a class="nav-link" href="login">Login</a></li>
					</c:if>

					<c:if test="${sessionScope.acc != null}">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fa fa-user"></i>
						</a>
							<div class="dropdown-menu dropdown-menu-right"
								aria-labelledby="userDropdown">
								<a class="dropdown-item" href="EditProfile.jsp">Edit Profile</a>
								<a class="dropdown-item" href="logout">Logout</a>
							</div></li>
					</c:if>
				</div>
			</ul>
		</div>
	</div>
</nav>