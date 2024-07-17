

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
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
	width: 110px;
	max-width: 100%;
	max-height: 100%;
	height: 110px;
	border-radius: 3px;
}

.item-details {
	flex: 0 0 70%;
	padding-left: 10px;
}

.item-details p {
	font-weight: bold;
	margin: 0;
}

.item-details span {
	display: block;
	margin: 5px 0;
}
</style>

</head>

<body onload="loadTotalMoney()">
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
											<div class="alert alert-success" role="alert">${mess}</div>
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
																${item.productVariant.color}<span> <span>${item.amount}
																		x ${item.productVariant.productID.price}$<span>
														</div>
													</div>
												</th>
												<td class="align-middle"><strong>${item.productVariant.productID.price}$</strong></td>





												<td class="align-middle"><a
													href="subAmountCart?productID=${item.productVariant.productID.id}&amount=${item.amount}"><button
															class="btnSub">-</button></a> <strong>${item.amount}</strong>
													<a
													href="addAmountCart?productID=${item.productVariant.productID.id}&amount=${item.amount}"><button
															class="btnAdd">+</button></a></td>
												<td class="align-middle"><a
													href="deleteCart?productID=${item.productVariant.productID.id}"
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
								class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thành
								tiền</div>

							<div class="p-4">
								<ul class="list-unstyled mb-4" id="contentTotalMoney">
									<!--  <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng tiền hàng</strong><strong>100 $</strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Phí vận chuyển</strong><strong>Free ship</strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">VAT</strong><strong>10 $</strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng thanh toán</strong>
                                            <h5 class="font-weight-bold">110 $</h5>
                                        </li> -->
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
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
		
	</script>
</body>

</html>

