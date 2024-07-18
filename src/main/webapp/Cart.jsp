

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">

<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.11.2/css/all.css" />
<!-- Google Fonts Roboto -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" />
<!-- MDB -->
<link rel="stylesheet" href="css/mdb.min.css" />
<!-- Custom styles -->
<link rel="stylesheet" href="css/style.css" />
<!-- Roboto Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700&display=swap">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://mdbootstrap.com/previews/ecommerce-demo/css/bootstrap.min.css">
<!-- Material Design Bootstrap -->
<link rel="stylesheet"
	href="https://mdbootstrap.com/previews/ecommerce-demo/css/mdb-pro.min.css">
<!-- Material Design Bootstrap Ecommerce -->
<link rel="stylesheet"
	href="https://mdbootstrap.com/previews/ecommerce-demo/css/mdb.ecommerce.min.css">
<!-- Your custom styles (optional) -->


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">


<style>
.cart-item {
	display: flex;
	align-items: center;
	position: relative; /* To position the remove button absolutely */
}

.item-image {
	flex: 0 0 30%;
	text-align: center;
}

.item-image img {
	width: 130px;
	max-width: 100%;
	max-height: 100%;
	height: 130px;
	border-radius: 3px;
}

.item-details {
	flex: 0 0 70%;
	padding-left: 10px;
}

.item-details p {
	font-weight: bold;
	margin: 0;
	font-size: 18px;
}

.item-details span {
	display: block;
	margin: 5px 0;
	font-size: 15px;
}

h5 {
	font-weight: bold;
	color: red;
}

form#shippingForm .form-group {
    margin-bottom: 15px;
}

form#shippingForm .form-group label {
    font-weight: bold;
    display: block;
}

form#shippingForm .form-control {
    border: 1px solid #ced4da;
    border-radius: 0.25rem;
    padding: 0.5rem;
}

form#shippingForm .form-control::placeholder {
    color: #6c757d;
}

form#shippingForm .form-control:focus {
    border-color: #80bdff;
    outline: 0;
    box-shadow: 0 0 0 0.2rem rgba(0, 123, 255, 0.25);
}

</style>

</head>

<body class="skin-light" onload="initialize()">
	<jsp:include page="Menu.jsp"></jsp:include>
	<div class="shopping-cart">
		<div class="px-4 px-lg-0">

			<div class="pb-5">
				<div class="container">
					<div class="row">
						<div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

							<!-- Shopping cart table -->
							<div class="table-responsive">
								<table class="table">
									<thead>
										<c:if test="${error!=null }">
											<div class="alert alert-danger" role="alert">${error}</div>
										</c:if>
										<c:if test="${mess!=null }">
											<script type="text/javascript">
												alert("${mess}");
											</script>
										</c:if>
										<tr>
											<th scope="col" class="border-0 bg-light">
												<div class="p-2 px-3 text-uppercase">Sản Phẩm</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Đơn Giá</div>
											</th>



											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Số Lượng</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Thành tiền</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Xóa</div>
											</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listCart}" var="item">
											<tr>
												<th scope="row">
													<div class="p-2 cart-item">
														<div class="item-image">
															<img src="${item.productVariant.image1}"
																alt="${item.productVariant.productID.name}" width="70"
																class="img-fluid rounded shadow-sm">
														</div>

														<div class="ml-3 d-inline-block align-middle item-details">
															<p>${item.productVariant.productID.name}</p>
															<span>Size: ${item.productVariant.size}</span> <span>Color:
																${item.productVariant.color}<span>
														</div>
													</div>
												</th>
												<td style="font-size: 15px;" class="align-middle"><strong>${item.productVariant.productID.retailPrice}$</strong></td>






												<td class="align-middle"><a
													href="subAmountCart?productVariantID=${item.productVariant.id}&amount=${item.amount}"><button
															class="btnSub">-</button></a> <strong>${item.amount}</strong>
													<a
													href="addAmountCart?productVariantID=${item.productVariant.id}&amount=${item.amount}"><button
															class="btnAdd">+</button></a></td>

												<td style="font-size: 15px;" class="align-middle"><strong>${item.productVariant.productID.retailPrice * item.amount}$</strong></td>

												<td class="align-middle"><a
													href="deleteCart?productVariantID=${item.productVariant.id}"
													class="text-dark">
														<button type="button" class="btn btn-danger">Delete</button>
												</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<!-- End -->
						</div>
					</div>

					<div class="row py-5 p-4 bg-white rounded shadow-sm">








						<div class="col-lg-6">
							<div
								class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thông
								tin vận chuyển</div>
							<div class="p-4">
								<form id="shippingForm">
									<div class="form-row">
										<div class="form-group col-md-6">
											<label for="fullName">Họ tên</label> <input type="text"
												class="form-control" id="fullName" placeholder="Nhập họ tên">
										</div>
										<div class="form-group col-md-6">
											<label for="phoneNumber">Số điện thoại</label> <input
												type="text" class="form-control" id="phoneNumber"
												placeholder="Nhập số điện thoại">
										</div>
									</div>
									<div class="form-row">
										<div class="form-group col-md-6">
											<label for="address">Địa chỉ nhận hàng</label> <input
												type="text" class="form-control" id="address"
												placeholder="Nhập địa chỉ">
										</div>
										<div class="form-group col-md-6">
											<label for="ward">Xã/Phường</label> <input type="text"
												class="form-control" id="ward" placeholder="Nhập xã/phường">
										</div>
									</div>
									<div class="form-row">
										<div class="form-group col-md-6">
											<label for="district">Quận/Huyện</label> <input type="text"
												class="form-control" id="district"
												placeholder="Nhập quận/huyện">
										</div>
										<div class="form-group col-md-6">
											<label for="province">Tỉnh</label> <input type="text"
												class="form-control" id="province" placeholder="Nhập tỉnh">
										</div>
									</div>
								</form>
							</div>
						</div>













						<div class="col-lg-6">
							<div
								class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thành
								tiền</div>

							<div class="p-4">
								<ul class="list-unstyled mb-4" id="contentTotalMoney">
									<li class="d-flex justify-content-between py-3 border-bottom"><strong
										class="text-muted">Tổng tiền hàng</strong><strong>0 $</strong></li>
									<li class="d-flex justify-content-between py-3 border-bottom"><strong
										class="text-muted">Phí vận chuyển</strong><strong>Free
											ship</strong></li>
									<li class="d-flex justify-content-between py-3 border-bottom"><strong
										class="text-muted">Tổng thanh toán</strong>
										<h5 class="font-weight-bold">0 $</h5></li>
								</ul>
								<a href="order"
									class="btn btn-dark rounded-pill py-2 btn-block text-white">Thanh
									Toán</a>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!-- Footer -->



	<!-- SCRIPTS -->
	<!-- JQuery -->
	<script
		src="https://mdbootstrap.com/previews/ecommerce-demo/js/jquery-3.4.1.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript"
		src="https://mdbootstrap.com/previews/ecommerce-demo/js/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript"
		src="https://mdbootstrap.com/previews/ecommerce-demo/js/bootstrap.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript"
		src="https://mdbootstrap.com/previews/ecommerce-demo/js/mdb.min.js"></script>
	<!-- MDB Ecommerce JavaScript -->
	<script type="text/javascript"
		src="https://mdbootstrap.com/previews/ecommerce-demo/js/mdb.ecommerce.min.js"></script>

	<script>
		function initialize() {
			loadAmountCart();
			loadTotalMoney();

		}

		function loadTotalMoney() {
			$
					.ajax({
						url : "/WebBanGiayDep/totalMoneyCart",
						type : "get", //send it through get method
						data : {

						},
						success : function(responseData) {
							document.getElementById("contentTotalMoney").innerHTML = responseData;
						}
					});
		}

		function loadAmountCart() {
			$
					.ajax({
						url : "/WebBanGiayDep/loadAllAmountCart",
						type : "get", //send it through get method
						data : {

						},
						success : function(responseData) {
							document.getElementById("amountCart").innerHTML = responseData;
						}
					});
		}
	</script>
</body>

</html>

