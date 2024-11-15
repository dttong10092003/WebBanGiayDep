<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Management</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&amp;display=swap">
<link rel="stylesheet" type="text/css"
	href="https://mdbootstrap.com/wp-content/themes/mdbootstrap4/css/mdb5/3.8.1/compiled.min.css">
<link rel="stylesheet" type="text/css"
	href="https://mdbootstrap.com/wp-content/themes/mdbootstrap4/css/mdb-plugins-gathered.min.css">
<!-- Your custom styles (optional) -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="css/style.css" rel="stylesheet" type="text/css" />

<style>
img {
	width: 150px;
	height: 150px;
}

body {
	background-color: #fbfbfb;
	margin: 0;
	padding: 0;
}

@media ( min-width : 991.98px) {
	main {
		padding-left: 240px;
	}
}

/* Sidebar */
.sidebar {
	position: fixed;
	top: 0;
	bottom: 0;
	left: 0;
	padding: 58px 0 0; /* Height of navbar */
	box-shadow: 0 2px 5px 0 rgb(0 0 0/ 5%), 0 2px 10px 0 rgb(0 0 0/ 5%);
	width: 240px;
	z-index: 600;
}

@media ( max-width : 991.98px) {
	.sidebar {
		width: 100%;
	}
}

.sidebar .active {
	border-radius: 5px;
	box-shadow: 0 2px 5px 0 rgb(0 0 0/ 16%), 0 2px 10px 0 rgb(0 0 0/ 12%);
}

.sidebar-sticky {
	position: relative;
	top: 0;
	height: calc(100vh - 48px);
	padding-top: 0.5rem;
	overflow-x: hidden;
	overflow-y: auto;
	/* Scrollable contents if viewport is shorter than content. */
}

[type=radio]:checked, [type=radio]:not(:checked), [type=checkbox]:checked,
	[type=checkbox]:not(:checked) {
	position: static !important;
	pointer-events: auto !important;
	opacity: 1 !important;
}
</style>
</head>
<body>

	<!--Main Navigation-->
	<header>
		<jsp:include page="LeftAdmin.jsp"></jsp:include>


	</header>
	<!--Main Navigation-->

	<!--Main layout-->
	<main>
		<div class="container pt-4">
			<!--Section: Quan Ly tai Khoan-->
			<section class="mb-4">
				<div class="card">
					<div class="card-header py-3 row">
						<div class="col-sm-3">
							<h5 class="mb-0 text-left" id="">
								<strong>Quản lý sản phẩm</strong>
							</h5>
						</div>
						<div class="col-sm-9 text-right">
							<!-- 
								<form action="uploadProductData" method="post"
								enctype="multipart/form-data">
								<div class="form-group">
									<label for="file">Choose CSV or Excel file:</label> <input
										type="file" class="form-control" id="file" name="file"
										accept=".csv, .xlsx, .xls" required>
								</div>
								<button type="submit" class="btn btn-primary">Upload</button>
							</form>
						 -->
							<a href="#addProductModal" class="btn btn-success"
								data-toggle="modal"><i class="material-icons">ADD</i></a>
							<!-- 
								<form action="xuatExcelProductControl" method="get">
								<button type="submit" class="mb-0 text-center btn btn-primary">Xuất
									file Excel</button>
							</form>
							 -->
						</div>
					</div>


					<c:if test="${error!=null }">
						<div id="errorAlert" class="alert alert-danger" role="alert">${error}</div>
					</c:if>
					<c:if test="${mess!=null }">
						<div id="messAlert" class="alert alert-success" role="alert">${mess}</div>
					</c:if>

					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-hover text-nowrap">
								<thead>
									<tr>
										<th scope="col">ID</th>
										<th scope="col">Name</th>
										<th scope="col">Image</th>
										<th scope="col">Price</th>
										<th scope="col">RetailPrice</th>
										<th scope="col">Actions</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listP}" var="o">
										<tr>
											<td>${o.id}</td>
											<td>${o.name}</td>
											<td><img src="${o.image}"></td>
											<td>${o.price}$</td>
											<td>${o.retailPrice}$</td>
											<td><a href="loadProduct?pid=${o.id}"><button
														type="button" class="btn btn-warning">
														<i class="material-icons" data-toggle="tooltip"
															title="Edit">Edit</i>
													</button></a> <!-- 
														<a href="delete?pid=${o.id}"><button type="button"
														class="btn btn-danger">
														<i class="material-icons" data-toggle="tooltip"
															title="Delete">Delete</i>
													</button></a></td>
													 -->
										</tr>
									</c:forEach>
								</tbody>
							</table>

							<div class="clearfix">
								<ul
									class="pagination justify-content-center float-md-right mb-0">
									<c:if test="${tag != 1}">
										<li class="page-item"><a href="manager?index=${tag-1 }"
											class="page-link"><i class="fas fa-chevron-left"></i></a></li>
									</c:if>
									<c:forEach begin="1" end="${endPage }" var="i">
										<li class="${tag==i?" page-item active":"" }"><a
											href="manager?index=${i }" class="page-link">${i }</a></li>
									</c:forEach>
									<c:if test="${tag != endPage}">
										<li class="page-item"><a href="manager?index=${tag+1 }"
											class="page-link"><i class="fas fa-chevron-right"></i></a></li>
									</c:if>
								</ul>
							</div>

						</div>
					</div>
				</div>
			</section>
			<!--Section: Quan Ly tai Khoan-->
		</div>


	</main>

	<!-- Add Product Modal HTML -->
	<div id="addProductModal" class="modal fade">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<form action="addProduct" method="post">
					<div class="modal-header">
						<h4 class="modal-title">Add Product</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>Name</label> <input name="name" type="text"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label>Image URL</label> <input name="image" type="text"
								class="form-control">
						</div>
						<div class="form-group">
							<label>Price</label> <input name="price" type="number"
								class="form-control">
						</div>
						<div class="form-group">
							<label>Retail Price</label> <input name="retailPrice"
								type="number" class="form-control">
						</div>
						<div class="form-group">
							<label for="gender">Gender</label>
							<div>
								<input id="men" type="radio" name="gender" value="1"> <label
									for="men">Men</label> <input id="women" type="radio"
									name="gender" value="0"> <label for="women">Women</label>
								<input id="unisex" type="radio" name="gender" value="-1">
								<label for="unisex">Unisex</label>
							</div>
						</div>
						<div class="form-group">
							<label>Description</label>
							<textarea name="description" class="form-control"></textarea>
						</div>
						<div class="form-group">
							<label>Brand</label> <select name="brandID" class="form-select"
								required>
								<c:forEach items="${listBrand}" var="brand">
									<option value="${brand.id}">${brand.name}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label>Category</label> <select name="categoryID"
								class="form-select" required>
								<c:forEach items="${listCategory}" var="category">
									<option value="${category.id}">${category.name}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label>Supplier</label> <select name="supplierID"
								class="form-select" required>
								<c:forEach items="${listSupplier}" var="supplier">
									<option value="${supplier.id}">${supplier.name}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label>Colors</label>
							<div>
								<!-- <input type="checkbox" name="colors" value="white">
								White <input type="checkbox" name="colors" value="black">
								Black <input type="checkbox" name="colors" value="yellow">
								Yellow <input type="checkbox" name="colors" value="red">
								Red <input type="checkbox" name="colors" value="blue">
								Blue -->
								<c:forEach items="${listColor}" var="color">
									<input type="checkbox" name="colors" value="${color}">
                                    ${color}
                                </c:forEach>
							</div>
						</div>
						<div id="variantsContainer">
							<h5>Product Variants</h5>
							<!-- Các biến thể sẽ được thêm vào đây -->
						</div>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancel"> <input type="submit"
							class="btn btn-success" value="Add">
					</div>
				</form>
			</div>
		</div>
	</div>



	<script>
		setTimeout(function() {
			var errorAlert = document.getElementById('errorAlert');
			if (errorAlert) {
				errorAlert.style.display = 'none';
			}
		}, 3000);

		setTimeout(function() {
			var messAlert = document.getElementById('messAlert');
			if (messAlert) {
				messAlert.style.display = 'none';
			}
		}, 3000);
		$(document)
				.ready(
						function() {
							$("input[type='checkbox'][name='colors']")
									.change(
											function() {
												let color = $(this).val();
												console.log(color);
												if ($(this).is(":checked")) {
													let variantForm = '<div class="variant form-group" data-color="' + color + '">'
															+ '<h4 style="color: black;">'
															+ color
															+ '</h4>'
															+ '<label>Size</label>'
															+ '<input name="size_' + color + '" type="text" class="form-control">'
															+ '<label>Quantity</label>'
															+ '<input name="quantity_' + color + '" type="number" class="form-control">'
															+ '<label>Image URL 1</label>'
															+ '<input name="image1_' + color + '" type="text" class="form-control">'
															+ '<label>Image URL 2</label>'
															+ '<input name="image2_' + color + '" type="text" class="form-control">'
															+ '<label>Image URL 3</label>'
															+ '<input name="image3_' + color + '" type="text" class="form-control">'
															+ '<label>Image URL 4</label>'
															+ '<input name="image4_' + color + '" type="text" class="form-control">'
															+ '</div>';
													$("#variantsContainer")
															.append(variantForm);
													console
															.log(
																	"Added variant form for color: ",
																	color);
												} else {
													$(
															'.variant[data-color="'
																	+ color
																	+ '"]')
															.remove();
													console
															.log(
																	"Removed variant form for color: ",
																	color);
												}
											});
						});
	</script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!--Main layout-->
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
	<!-- MDB -->
	<script type="text/javascript" src="js/mdb.min.js"></script>
	<!-- Custom scripts -->
	<script type="text/javascript" src="js/script.js"></script>
	<script
		src="https://mdbootstrap.com/api/snippets/static/download/MDB5-Free_3.8.1/js/mdb.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"></script>


	<script type="text/javascript"
		src="https://mdbootstrap.com/wp-content/themes/mdbootstrap4/js/plugins/mdb-plugins-gathered.min.js"></script>
	<!-- MDB -->
	<script type="text/javascript" src="js/mdb.min.js"></script>
	<!-- Custom scripts -->
	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>